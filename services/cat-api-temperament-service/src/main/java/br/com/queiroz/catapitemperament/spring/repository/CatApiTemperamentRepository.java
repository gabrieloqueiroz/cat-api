package br.com.queiroz.catapitemperament.spring.repository;

import br.com.queiroz.catapitemperament.spring.dto.BreedDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatApiTemperamentRepository extends JpaRepository<BreedDto, String> {
}
