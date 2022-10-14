package br.com.queiroz.catapibatch.spring.service.impl;

import br.com.queiroz.catapibatch.spring.client.CatApiClient;
import br.com.queiroz.catapibatch.spring.model.Cat;
import br.com.queiroz.catapibatch.spring.repository.CatApiRepository;
import br.com.queiroz.catapibatch.spring.service.interfaces.CatApiInterfaces;
import br.com.queiroz.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static br.com.queiroz.utils.LoggingUtil.logInfo;

@Service
public class CatApiService implements CatApiInterfaces {

    CatApiRepository catApiRepository;
    CatApiClient catApiClient;

    @Autowired
    public CatApiService(CatApiRepository catApiRepository, CatApiClient catApiClient) {
        this.catApiRepository = catApiRepository;
        this.catApiClient = catApiClient;
    }

    @Override
    public void saveAllBreeds() {
        List<Cat> cats = catApiClient.findAllBreed().collectList().block();
       logInfo(this.getClass(), "Found " + cats.size() + " registers.");

        if (Objects.isNull(cats) || cats.isEmpty()) throw new RuntimeException("check the information");

        //logger
        logInfo(this.getClass(),"Deleting registers");
        catApiRepository.deleteAll();

        logInfo(this.getClass(),"Inserting " + cats.size() + " new registers.");
        catApiRepository.saveAll(cats);

        logInfo(this.getClass(), "All cats updated successfully");
    }
}
