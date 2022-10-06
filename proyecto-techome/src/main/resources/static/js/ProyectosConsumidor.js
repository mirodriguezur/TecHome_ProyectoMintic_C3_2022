function logout() {
    const consumidor = JSON.parse(localStorage.getItem("loggedUser")) //Obtengo el objeto que viene de la información del login
                                                                   //JSON.parse()convierte lo que venga a un objeto de javascript.

    const nombre = consumidor.primerNombre                           //Ahora  puedo acceder a los atributos de mi ojbeto.
    alert( nombre +" gracias por confiar en nosotros, vuelva pronto.")
    
    localStorage.removeItem("loggedUser")                        //Borro la información del tecnico de la caché
}

function informacion() {
    alert("Bienvenido, en esta página podrá crear sus proyectos deseados. \n Agregue la información necesaria para que un técnico pueda contactarlo.")
}

const crearProyecto = () => {
    const consumidor = JSON.parse(localStorage.getItem("loggedUser")) //Obtengo el objeto que viene de la información del login
    
    const cedulaConsumidor = consumidor.cedulaConsumidor
    const tipoProyecto = document.getElementById("tipoProyectoConsumidor").value;
    const nombreProyecto = document.getElementById("nombre").value;
    const presupuestoProyecto = document.getElementById("presupuesto").value;
    const tiempoProyecto = document.getElementById("tiempo").value;
    const descripcionProyecto = document.getElementById("descripcion").value;

    const body = {
        "cedulaConsumidor": cedulaConsumidor,
        "tipoProyecto": tipoProyecto,
        "nombreProyecto": nombreProyecto,
        "presupuestoProyecto": presupuestoProyecto,
        "tiempoProyecto": tiempoProyecto,
        "descripcionProyecto": descripcionProyecto,
    };
    agregarProyecto(body);
}

const agregarProyecto = async (bodyObject) => {
    const url = "api/project";
    const response = await fetch(url, {         //espera a que obtenga un response
        method: "POST",
        body: JSON.stringify(bodyObject),       //le paso la informacion necesari por el cuerpo por ser response.
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) { 
        
    } else {
        const message = await response.text();
        showError(message);
    }


}