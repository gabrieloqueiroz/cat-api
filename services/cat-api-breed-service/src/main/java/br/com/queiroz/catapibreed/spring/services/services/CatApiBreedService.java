package br.com.queiroz.catapibreed.spring.services.services;

import br.com.queiroz.catapibreed.spring.client.CatApiClient;
import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.model.Breed;
import br.com.queiroz.catapibreed.spring.services.interfaces.CatApiBreedInterfaces;
import br.com.queiroz.utils.LoggingUtil;
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
        LoggingUtil.logInfo(this.getClass(), "Find breed by Id: " + breed);
        Breed catByBreed = catApiClient.getBreedById(breed);

        if (Objects.nonNull(catByBreed)) {
            LoggingUtil.logInfo(this.getClass(), "Found breed!");
        }else{
            throw new RuntimeException("Breed not found");
        }

        BreedDto breedDto = modelMapper.map(catByBreed, BreedDto.class);

        return breedDto;
    }
}
