// Personas
// API
function obtenerPersonas(page, limit) {
    const url = `/api/personas/?page=${page}&limit=${limit}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function obtenerPersona(id) {
    const url = `/api/personas/${id}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function crearPersona(data) {
    const url = `/api/personas/`;
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}


function actualizarPersona(id, data) {
    const url = `/api/personas/${id}`;
    return fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}

function removerPersona(id) {
    const url = `/api/personas/${id}`;
    return fetch(url, {
        method: 'DELETE',
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}


// Materias
function obtenerMaterias(page, limit) {
    const url = `/api/materias/?page=${page}&limit=${limit}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function obtenerMateria(id) {
    const url = `/api/materias/${id}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function crearMateria(data) {
    const url = `/api/materias/`;
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}


function actualizarMateria(id, data) {
    const url = `/api/materias/${id}`;
    return fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}

function removerMateria(id) {
    const url = `/api/materias/${id}`;
    return fetch(url, {
        method: 'DELETE',
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}


// Cursos
function obtenerCursos(page, limit) {
    const url = `/api/cursos/?page=${page}&limit=${limit}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function obtenerCurso(id) {
    const url = `/api/cursos/${id}`;
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error(error));
}

function crearCurso(data) {
    const url = `/api/cursos/`;
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}


function actualizarCurso(id, data) {
    const url = `/api/cursos/${id}`;
    return fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}

function removerCurso(id) {
    const url = `/api/cursos/${id}`;
    return fetch(url, {
        method: 'DELETE',
    })
        .then(response => response.json())
        .catch(error => console.error(error));
}