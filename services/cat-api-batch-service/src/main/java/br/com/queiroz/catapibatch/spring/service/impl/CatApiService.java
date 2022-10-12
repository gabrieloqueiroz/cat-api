package br.com.queiroz.catapibatch.spring.service.impl;

import br.com.queiroz.catapibatch.spring.client.CatApiClient;
import br.com.queiroz.catapibatch.spring.model.Cat;
import br.com.queiroz.catapibatch.spring.repository.CatApiRepository;
import br.com.queiroz.catapibatch.spring.service.interfaces.CatApiInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        System.out.println("Encontrando " + cats.size() + " registros.");

        if (Objects.isNull(cats) || cats.isEmpty()) throw new RuntimeException("check the information");

        //logger
        System.out.println("deletando registros");
        catApiRepository.deleteAll();

        System.out.println("inserindo " + cats.size() + " novos registros.");
        catApiRepository.saveAll(cats);

        System.out.println("finalizado atualização de breeds");
    }
}
