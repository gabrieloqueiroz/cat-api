package br.com.queiroz.catapitemperament.spring.service.impl;

import br.com.queiroz.catapitemperament.spring.dto.BreedDto;
import br.com.queiroz.catapitemperament.spring.model.Cat;
import br.com.queiroz.catapitemperament.spring.repository.CatApiTemperamentRepository;
import br.com.queiroz.catapitemperament.spring.service.interfaces.CatApiTemperamentInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.queiroz.utils.LoggingUtil.logInfo;

@Service
public class CatApiTemperamentService implements CatApiTemperamentInterfaces {

    CatApiTemperamentRepository temperamentRepository;
    ModelMapper mapper;

    @Autowired
    public CatApiTemperamentService(CatApiTemperamentRepository temperamentRepository,ModelMapper mapper) {
        this.temperamentRepository = temperamentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BreedDto> getBreedByTemperament(String temperament) {
        logInfo(this.getClass(), "Search all cats in repository");
        List<Cat> allCats = temperamentRepository.findAll();
        logInfo(this.getClass(), "Found " + allCats.size() + " in repository");

         List<BreedDto> catsByTemperament = allCats
                 .stream()
                 .filter(cat ->
                         cat.getTemperament()
                                 .contains(temperament)
                 ).map(cat ->
                         mapper.map(cat, BreedDto.class)
                 ).toList();

        if (catsByTemperament.isEmpty()) throw new RuntimeException("Temperament not found");

        logInfo(this.getClass(), "Breeds with temperament -- " + temperament + ". Found " + catsByTemperament.size());
        System.out.println("Cats com o temperament " + temperament + ". Total de: " + catsByTemperament.size());
        return catsByTemperament;
    }
}
