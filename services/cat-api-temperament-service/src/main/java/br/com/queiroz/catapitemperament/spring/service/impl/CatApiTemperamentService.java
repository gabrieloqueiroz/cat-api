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
        List<Cat> allCats = temperamentRepository.findAll();
        System.out.println("Cats encontrados: " + allCats.size());

         List<BreedDto> catsByTemperament = allCats
                 .stream()
                 .filter(cat ->
                         cat.getTemperament()
                                 .contains(temperament)
                 ).map(cat ->
                         mapper.map(cat, BreedDto.class)
                 ).toList();

        if (catsByTemperament.isEmpty()) throw new RuntimeException("Temperament not found");

        System.out.println("Cats com o temperament " + temperament + ". Total de: " + catsByTemperament.size());
        return catsByTemperament;
    }
}
