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