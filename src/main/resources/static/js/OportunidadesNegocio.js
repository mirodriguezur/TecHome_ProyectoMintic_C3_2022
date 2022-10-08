function informacion() {
    alert("En esta página  encontrará información sobre los proyectos que hay cerca a su área. \n Haga buen uso de la información  de los consumidores pues son sus potenciales clientes.")
}

function logout() {
    const tecnico = JSON.parse(localStorage.getItem("loggedUser")) //Obtengo el objeto que viene de la información del login
                                                                   //JSON.parse()convierte lo que venga a un objeto de javascript.

    const nombre = tecnico.primerNombre                           //Ahora  puedo acceder a los atributos de mi ojbeto.
    alert( nombre +" Vuelva pronto, mas oportunidades  lo estarán esperando.")
    
    localStorage.removeItem("loggedUser")                        //Borro la información del tecnico de la caché
}

const consultar = () => {
    const tecnico = JSON.parse(localStorage.getItem("loggedUser")) //Obtengo el objeto que viene de la información del login

    const especialidad = tecnico.especialidad

    const body = {
        "categoria": especialidad,
    };
    consultarOportunidades(body);
}

const consultarOportunidades = async (bodyObject) => {
    const url = "/api/project/consultarproyectos";
    const response = await fetch(url, {         //espera a que obtenga un response
        method: "POST",
        body: JSON.stringify(bodyObject),       //le paso la informacion necesari por el cuerpo por ser response.
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) { 
        const oportunidad = await response.json();
       oportunidad.forEach(lead => {
            const info = `<li href="#" class="list-group-item list-group-item-action py-3 lh-tigh">
                                <div class="d-flex w-100 align-items-center justify-content-between">
                                    <strong class="mb-1">${lead.nombreProyecto}</strong>
                                    <small class="text-muted">${lead.presupuesto}</small>
                                </div>
                                <div class="col-10 mb-1 small">${lead.descripcion}</div>
                            </li>`;

            document.querySelector('[data-id="field"]').insertAdjacentHTML('beforeend', info);
       });
    } else if (response.status == 400) {
        console.log("Error en la ruta del link.")
    } else {
        const message = await response.text();
        showError(message);
    }
    
}