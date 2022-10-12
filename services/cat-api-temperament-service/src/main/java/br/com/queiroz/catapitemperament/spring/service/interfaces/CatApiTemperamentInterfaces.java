package br.com.queiroz.catapitemperament.spring.service.interfaces;

import br.com.queiroz.catapitemperament.spring.dto.BreedDto;

import java.util.List;

public interface CatApiTemperamentInterfaces {
    List<BreedDto> getBreedByTemperament(String temperament);

}
