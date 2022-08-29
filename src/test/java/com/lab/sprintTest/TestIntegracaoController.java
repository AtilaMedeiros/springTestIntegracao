package com.lab.sprintTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest
//feito para usar recursos Junit como o @Test
@ExtendWith(SpringExtension.class)
public class TestIntegracaoController {

    //MockMVC A classe é parte da estrutura de teste Spring MVC que ajuda a testar os controladores explicitamente iniciando um contêiner de Servlet.
    @Autowired
    private MockMvc mvc;

    //constroi uma requisicao fake(simulação) para testar o endpoint
    @Test
    public void testIntegracaoSemArgumento() throws  Exception {
        RequestBuilder requisicao = get("/test");
        MvcResult resultado = mvc.perform(requisicao).andReturn();
        Assertions.assertEquals("MsgQuandoNaoPassamosParametro", resultado.getResponse().getContentAsString());
    }

    //test integração serve para testar os endpoints
    //ao passar o parametro(?nome=Fulano) o retorno contem (content()) a parlavra Fulano
    @Test
    public  void tesIntegracaoComArgumento() throws Exception {
            mvc.perform(get("/test?nome=Fulano"))
                .andExpect(content().string("Fulano"));


    }
}
