const login = () => {
    const email = document.getElementById("txtemail").value;
    const password = document.getElementById("txtPassword").value;
    const esTecnico = document.getElementById("tecnico").checked;

    if (email == "") {
        showError("El email es requerido.");
        return;
    }
    if (password == "") {
        showError("La contraseña es requerida.");
        return;
    }

    const body = {
        "email": email,
        "password": password,
        "esTecnico": esTecnico
    };
    postToLogin(body);
};

const postToLogin = async (bodyObject) => {     //metodo asíncrono
    const url = "/api/login";                   //url del restController
    const response = await fetch(url, {         //espera a que obtenga un response
        method: "POST",
        body: JSON.stringify(bodyObject),       //le paso la informacion necesari por el cuerpo por ser response.
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();     //el metodo .json() es una promesa, por eso lo espero con await.

        localStorage.setItem("loggedUser", JSON.stringify(user)); //permite guardar la informacion del login en la cache del navegador. (funciona parecido a un diccionario)

        alert("Bienvenido "+user.primerNombre+" "+user.primerApellido+"!", "success");

        await new Promise(r => setTimeout(r, 2000));

        if(user.esTecnico){
            window.location.href = "/oportunidadesnegocio";     //Si es tecnico lo direccionará a la página oportunidadesnegocio
        } 
        else {
            window.location.href = "/proyectosconsumidor";      //Si es consumidor, lo direccionará a la página proyectosconsumidor
        }

        
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}