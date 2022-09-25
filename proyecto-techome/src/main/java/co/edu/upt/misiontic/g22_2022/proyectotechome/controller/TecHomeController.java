//Controla la navegación de mi sitio web.
//Spring MVC Application
package co.edu.upt.misiontic.g22_2022.proyectotechome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TecHomeController {

    @GetMapping("/homeconsumidor")
    public String goToHomeConsumidor(Model model){
        return "/homeconsumidor";
    }

    @GetMapping("/iniciotechomepro")
    public String goToInicioTecHomePro(Model model){
        return "iniciotechomepro";
    }

    @GetMapping("/login")
    public String goToLogin(Model model){
        return "login";
    }

    @GetMapping("/registronuevostecnicos")
    public String goToRegistronuevostecnicos(Model model){
        return "registronuevostecnicos";
    }

    @GetMapping("/registronuevosconsumidores")
    public String goToRegistronuevosConsumidores(Model model){
        return "registronuevosconsumidores"; 
    }
}