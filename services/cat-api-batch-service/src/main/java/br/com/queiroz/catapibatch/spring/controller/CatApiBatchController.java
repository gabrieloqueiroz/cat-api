package br.com.queiroz.catapibatch.spring.controller;

import br.com.queiroz.catapibatch.spring.service.interfaces.CatApiInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatApiBatchController implements Runnable{

    private CatApiInterfaces catApiInterfaces;

    @Autowired
    public CatApiBatchController(CatApiInterfaces catApiInterfaces) {
        this.catApiInterfaces = catApiInterfaces;
        Thread t = new Thread(this);
        t.start();
    }



    @Override
    public void run() {
        //Logger
        System.out.println("iniciando processamento");
        catApiInterfaces.saveAllBreeds();
    }
}
