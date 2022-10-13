package br.com.queiroz.catapibreed.spring.controller;

import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.services.interfaces.CatApiBreedInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantsUtils.CAT_API_BREED)
public class CatApiOriginController {

    CatApiBreedInterfaces breedInterfaces;

    @Autowired
    public CatApiOriginController(CatApiBreedInterfaces breedInterfaces) {
        this.breedInterfaces = breedInterfaces;
    }

    @GetMapping("/{breed}")
    public ResponseEntity<BreedDto> getBreedByTemperament(@PathVariable String breed){
        BreedDto breedDto = breedInterfaces.getBreed(breed);

        return ResponseEntity.ok(breedDto);
    }
}
