function logout() {
    const consumidor = JSON.parse(localStorage.getItem("loggedUser")) //Obtengo el objeto que viene de la información del login
                                                                   //JSON.parse()convierte lo que venga a un objeto de javascript.

    const nombre = consumidor.primerNombre                           //Ahora  puedo acceder a los atributos de mi ojbeto.
    alert( nombre +" gracias por confiar en nosotros, vuelva pronto.")
    
    localStorage.removeItem("loggedUser")                        //Borro la información del tecnico de la caché
}