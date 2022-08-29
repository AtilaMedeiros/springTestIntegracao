package com.lab.sprintTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //criando um endpoit do tipo get com parametro nome e defalt, caso não passado nenhum parametro
    @GetMapping("/test")
    public String returMenssage(@RequestParam(name="nome", defaultValue = "MsgQuandoNaoPassamosParametro") String menssagem){
        return menssagem;
    }
}
