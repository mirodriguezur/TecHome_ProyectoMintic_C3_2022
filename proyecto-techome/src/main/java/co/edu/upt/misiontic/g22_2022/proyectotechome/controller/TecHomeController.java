//Controla la navegación de mi sitio web.
//Spring MVC Application
package co.edu.upt.misiontic.g22_2022.proyectotechome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.upt.misiontic.g22_2022.proyectotechome.controller.dto.RegistroTecnicoDto;
import co.edu.upt.misiontic.g22_2022.proyectotechome.model.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j   //para que funcione el log (imprimir en consola)
@Controller
public class TecHomeController {

    private ProjectService projectService;

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

    @GetMapping("/oportunidadesnegocio")
    public String goToOportunidadesNegocio(Model model){
        return "oportunidadesnegocio"; 
    }

    //TODO: Implementar inicio del consumer

    @PostMapping("/registronuevostecnicos/registro")
    public String postRegistroTecnicos(@ModelAttribute RegistroTecnicoDto tecnicoInfo, Model model) {  //@ModelAttribute recibe la informacion de un formulario HTML
        log.info(tecnicoInfo.toString());

        projectService.crearTecnico(tecnicoInfo);

        model.addAttribute("info", tecnicoInfo); //thymeleaf obtiene todo el objeto, y puedo hacer uso de cualquier propiedad del objeto dentro de la plantilla oportunidadesnegocio
        return "oportunidadesnegocio";
     }

     //TODO: Implementar envio de formulario del consumer (descomentar e implementar)

    //@PostMapping("/registronuevosconsumidores/registro")
    //public String postRegistroConsumidores(@ModelAttribute RegistroConsumidorDto consumidorInfo, Model model) {  //@ModelAttribute recibe la informacion de un formulario HTML
       // log.info(consumidorInfo.toString());

        //ProjectService.crearConsumidor(tecnicoInfo);

        //model.addAttribute("info", consumidorInfo); //thymeleaf obtiene todo el objeto, y puedo hacer uso de cualquier propiedad del objeto dentro de la plantilla oportunidadesnegocio
        //return "oportunidadesnegocio";
     //}

}