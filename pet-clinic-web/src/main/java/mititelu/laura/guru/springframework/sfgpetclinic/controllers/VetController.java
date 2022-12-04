package mititelu.laura.guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LMiti3030
 * created on 04.12.2022
 */
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html"})
    public String listVets(){
        return "vets/index";
    }

}
