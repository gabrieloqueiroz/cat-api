package br.com.queiroz.catapitemperament.spring.controller;

import br.com.queiroz.catapitemperament.spring.dto.BreedDto;
import br.com.queiroz.catapitemperament.spring.service.interfaces.CatApiTemperamentInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.queiroz.utils.LoggingUtil.logInfo;

@RestController
@RequestMapping(value = ConstantsUtils.CAT_API_TEMPERAMENT)
public class CatApiTemperamentController {

    CatApiTemperamentInterfaces breedTemperamentInterfaces;

    @Autowired
    public CatApiTemperamentController(CatApiTemperamentInterfaces breedTemperamentInterfaces) {
        this.breedTemperamentInterfaces = breedTemperamentInterfaces;
    }

    @GetMapping("/{temperament}")
    public ResponseEntity<List<BreedDto>> getBreedByTemperament(@PathVariable String temperament){
        logInfo(this.getClass(), "Starting search breeds by temperament");
        List<BreedDto> breedDto = breedTemperamentInterfaces.getBreedByTemperament(temperament);

        logInfo(this.getClass(), "Finishing search breeds by temperament");
        return ResponseEntity.ok(breedDto);
    }
}
