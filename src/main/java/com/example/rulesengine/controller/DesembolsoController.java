package com.example.rulesengine.controller;

import com.example.rulesengine.domain.DesembolsoRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesembolsoController {

    @Autowired
    KieContainer kieContainer;
/*
    public DesembolsoController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
*/
    @GetMapping("/getDesembolso")
    public DesembolsoRequest getReglas(@RequestParam(required = true) String documento, @RequestParam(required = true) Integer duracion){
        KieSession kieSession = kieContainer.newKieSession();
        DesembolsoRequest desembolsoRequest = new DesembolsoRequest(documento,duracion,false);
        kieSession.insert(desembolsoRequest);
        kieSession.fireAllRules();
        kieSession.dispose();

        return desembolsoRequest;
    }
}
