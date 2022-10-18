package br.com.queiroz.catapibreed.spring.controller;

import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.services.interfaces.CatApiBreedInterfaces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static br.com.queiroz.catapibreed.spring.mother.UtilsMother.getBreedDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CatApiControllerTest{

    private CatApiBreedController catApiBreedController;
    private CatApiBreedInterfaces catApiBreedInterfaces;

    @BeforeEach
    public void setup(){
        this.catApiBreedInterfaces = Mockito.mock(CatApiBreedInterfaces.class);
        this.catApiBreedController = new CatApiBreedController(catApiBreedInterfaces);
    }

    @Test
    public void should_return_breed_by_temperament(){
        //given
        String insert = "Affectionate";
        BreedDto expected = getBreedDto();

        when(catApiBreedInterfaces.getBreed(any())).thenReturn(expected);

        //when
        ResponseEntity<BreedDto> response = catApiBreedController.getBreedById(insert);

        //then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expected, response.getBody());
    }
}
