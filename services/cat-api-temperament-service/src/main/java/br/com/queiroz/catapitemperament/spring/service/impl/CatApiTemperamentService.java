package br.com.queiroz.catapitemperament.spring.service.impl;

import br.com.queiroz.catapitemperament.spring.dto.BreedDto;
import br.com.queiroz.catapitemperament.spring.repository.CatApiTemperamentRepository;
import br.com.queiroz.catapitemperament.spring.service.interfaces.CatApiTemperamentInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatApiTemperamentService implements CatApiTemperamentInterfaces {

    CatApiTemperamentRepository temperamentRepository;
//    CatApiClient catApiClient;
    ModelMapper mapper;

    @Autowired
    public CatApiTemperamentService(CatApiTemperamentRepository temperamentRepository,ModelMapper mapper) {
        this.temperamentRepository = temperamentRepository;
//        this.catApiClient = catApiClient;
        this.mapper = mapper;
    }


    @Override
    public List<BreedDto> getBreedByTemperament(String temperament) {
        return null;
    }
}
