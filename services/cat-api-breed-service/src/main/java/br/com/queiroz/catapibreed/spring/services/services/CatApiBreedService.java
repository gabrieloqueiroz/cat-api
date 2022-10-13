package br.com.queiroz.catapibreed.spring.services.services;

import br.com.queiroz.catapibreed.spring.client.CatApiClient;
import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.model.Breed;
import br.com.queiroz.catapibreed.spring.services.interfaces.CatApiBreedInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CatApiBreedService implements CatApiBreedInterfaces {


    private CatApiClient catApiClient;
    private ModelMapper modelMapper;

    @Autowired
    public CatApiBreedService(CatApiClient catApiClient, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.catApiClient = catApiClient;
    }

    @Override
    public BreedDto getBreed(String breed) {
        Breed catByBreed = catApiClient.getBreedById(breed);

        BreedDto breedDto = modelMapper.map(catByBreed, BreedDto.class);

        return breedDto;
    }
}
