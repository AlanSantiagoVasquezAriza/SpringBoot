package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Controler {

    @GetMapping("/")
    public String home(){
        log.info("Home page");
        return "index";
    }

    @GetMapping("/agregar")
    public String subir(){
        log.info("Add page");
        return "add";
    }

    @GetMapping("/modificar")
    public String editar(){
        log.info("Edit page");
        return "update";
    }

    @GetMapping("/eliminar")
    public String eliminar(){
        log.info("Delete page");
        return "delete";
    }

    @GetMapping("/success")
    public String success(){
        log.info("Success page");
        return "success";
    }

    @GetMapping("/nofound")
    public String nofound(){
        log.info("No found page");
        return "nofound";
    }
}
