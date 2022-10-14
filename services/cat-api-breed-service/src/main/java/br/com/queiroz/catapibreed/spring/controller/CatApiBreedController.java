package br.com.queiroz.catapibreed.spring.controller;

import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.services.interfaces.CatApiBreedInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import br.com.queiroz.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantsUtils.CAT_API_BREED)
public class CatApiBreedController {

    CatApiBreedInterfaces breedInterfaces;

    @Autowired
    public CatApiBreedController(CatApiBreedInterfaces breedInterfaces) {
        this.breedInterfaces = breedInterfaces;
    }

    @GetMapping("/{breed}")
    public ResponseEntity<BreedDto> getBreedById(@PathVariable String breed){
        LoggingUtil.logInfo(this.getClass(), "Starting search breed by id");
        BreedDto breedDto = breedInterfaces.getBreed(breed);

        LoggingUtil.logInfo(this.getClass(), "Finishing search breed by id");
        return ResponseEntity.ok(breedDto);
    }
}
