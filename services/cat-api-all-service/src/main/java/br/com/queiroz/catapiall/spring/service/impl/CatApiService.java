package br.com.queiroz.catapiall.spring.service.impl;

import br.com.queiroz.catapiall.spring.dto.CatDto;
import br.com.queiroz.catapiall.spring.model.Cat;
import br.com.queiroz.catapiall.spring.repository.CatApiRepository;
import br.com.queiroz.catapiall.spring.service.interfaces.CatApiInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CatApiService implements CatApiInterfaces {

    CatApiRepository catApiRepository;
    ModelMapper mapper;

    @Autowired
    public CatApiService(CatApiRepository catApiRepository, ModelMapper mapper) {
        this.catApiRepository = catApiRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CatDto> getAllBreed() {
        List<Cat> cats = catApiRepository.findAll();

        if (cats.isEmpty()) throw new RuntimeException("check the information");

        List<CatDto> catsDto = cats.
                stream()
                .map(cat ->
                    mapper.map(cat, CatDto.class)
                )
                .collect(Collectors.toList());

        return catsDto;
    }
}
