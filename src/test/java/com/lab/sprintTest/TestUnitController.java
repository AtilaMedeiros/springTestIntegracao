package com.lab.sprintTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestUnitController {

    @Test
    public void testUnit(){
        TestController testController = new TestController();
        String result = testController.returMenssage("Oi Pessoal");
        Assertions.assertEquals("Oi Pessoall", result);

    }
}
