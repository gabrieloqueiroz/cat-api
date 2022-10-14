package br.com.queiroz.catapibatch.spring.controller;

import br.com.queiroz.catapibatch.spring.service.interfaces.CatApiInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import br.com.queiroz.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantsUtils.PATH_SEPARATOR + ConstantsUtils.CAT_API_BATCH)
public class CatApiBatchController implements Runnable {

    private CatApiInterfaces catApiInterfaces;

    @Autowired
    public CatApiBatchController(CatApiInterfaces catApiInterfaces) {
        this.catApiInterfaces = catApiInterfaces;
        Thread t = new Thread(this);
        t.start();
    }

    @GetMapping
    public void refreshCatsTable() {
        catApiInterfaces.saveAllBreeds();
    }

    @Override
    public void run() {
        //Logger
        LoggingUtil.logInfo(this.getClass(), "Starting update cats table");
        catApiInterfaces.saveAllBreeds();
    }
}
