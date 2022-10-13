package br.com.queiroz.catapibreed.spring.service;

import br.com.queiroz.catapibreed.spring.client.CatApiClient;
import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.model.Breed;
import br.com.queiroz.catapibreed.spring.services.services.CatApiBreedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static br.com.queiroz.catapibreed.spring.mother.UtilsMother.getBreed;
import static br.com.queiroz.catapibreed.spring.mother.UtilsMother.getBreedDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatApiBreedServiceTest {

    private CatApiBreedService catApiBreedService;
    private CatApiClient catApiClient;
    private ModelMapper modelMapper;

    @BeforeEach()
    public void setup(){
        this.catApiClient = mock(CatApiClient.class);
        this.modelMapper = new ModelMapper();
        this.catApiBreedService = new CatApiBreedService(this.catApiClient, this.modelMapper);
    }

    @Test
    public void should_return_breed_by_temperament(){
        //given
        String insert = "Sensitive";
        Breed expectedEntity = getBreed();
        BreedDto expected = getBreedDto();

        when(catApiClient.getBreedById(any())).thenReturn(expectedEntity);

        //when
        BreedDto response = catApiBreedService.getBreed(insert);

        //then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expected, response);
    }
}
