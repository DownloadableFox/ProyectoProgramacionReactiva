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
    materia_id integer NOT NULL,
    profesor_id integer NOT NULL,
    numero varchar,
    estudiante_id integer,
    fecha_inicio date,
    fecha_fin date,
    PRIMARY KEY (materia_id, profesor_id, numero),
    FOREIGN KEY (estudiante_id) REFERENCES persona (id),
    FOREIGN KEY (profesor_id) REFERENCES persona (id),
    FOREIGN KEY (materia_id) REFERENCES materia (id)
);

CREATE TABLE nota (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    materia_id integer NOT NULL,
    profesor_id integer NOT NULL,
    estudiante_id integer NOT NULL,
    observacion varchar,
    valor numeric(3, 2)
);

CREATE VIEW estudiante AS
    SELECT id, nombre, apellido, correo
    FROM persona    WHERE rol = 'E';

CREATE VIEW profesor AS
    SELECT id, nombre, apellido, correo
    FROM persona    WHERE rol = 'P';

