DROP VIEW IF EXISTS estudiante;
DROP VIEW IF EXISTS profesor;
DROP TABLE IF EXISTS nota;
DROP TABLE IF EXISTS curso_estudiante;
DROP TABLE IF EXISTS curso_profesor;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS materia;
DROP TABLE IF EXISTS persona CASCADE;

CREATE TABLE persona (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre varchar,
    apellido varchar,
    correo varchar,
    rol char(1) DEFAULT 'E' CHECK (rol in ( 'E', 'P'))
);

CREATE TABLE materia (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre varchar,
    creditos integer
);

CREATE TABLE curso (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    numero varchar NOT NULL,
    materia_id integer NOT NULL,
    profesor_id integer NOT NULL,
    fecha_inicio integer,
    fecha_fin integer,
    FOREIGN KEY (profesor_id) REFERENCES persona (id),
    FOREIGN KEY (materia_id) REFERENCES materia (id)
);

CREATE TABLE curso_estudiante (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    curso_id integer NOT NULL,
    estudiante_id integer NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso (id),
    FOREIGN KEY (estudiante_id) REFERENCES persona (id)
);

CREATE TABLE curso_profesor (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    curso_id integer NOT NULL,
    profesor_id integer NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso (id),
    FOREIGN KEY (profesor_id) REFERENCES persona (id)
);

CREATE TABLE nota (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    curso_id integer NOT NULL,
    estudiante_id integer NOT NULL,
    observacion varchar,
    valor numeric(3, 2),
    FOREIGN KEY (curso_id) REFERENCES curso (id),
    FOREIGN KEY (estudiante_id) REFERENCES persona (id)
);

CREATE VIEW estudiante AS
    SELECT id, nombre, apellido, correo
    FROM persona    WHERE rol = 'E';

CREATE VIEW profesor AS
    SELECT id, nombre, apellido, correo
    FROM persona    WHERE rol = 'P';

CREATE OR REPLACE FUNCTION check_estudiante_rol() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.estudiante_id IN (SELECT id FROM persona WHERE rol != 'E') THEN
        RAISE EXCEPTION 'Invalid rol for estudiante_id %', NEW.estudiante_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_estudiante_rol_trigger
BEFORE INSERT OR UPDATE ON curso_estudiante
FOR EACH ROW EXECUTE FUNCTION check_estudiante_rol();

CREATE OR REPLACE FUNCTION check_profesor_rol() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.profesor_id IN (SELECT id FROM persona WHERE rol != 'P') THEN
        RAISE EXCEPTION 'Invalid rol for profesor_id %', NEW.profesor_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_profesor_rol_trigger
BEFORE INSERT OR UPDATE ON curso_profesor
FOR EACH ROW EXECUTE FUNCTION check_profesor_rol();