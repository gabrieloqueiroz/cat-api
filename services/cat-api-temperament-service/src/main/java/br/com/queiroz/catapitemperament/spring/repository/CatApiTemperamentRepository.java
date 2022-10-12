package br.com.queiroz.catapitemperament.spring.repository;

import br.com.queiroz.catapitemperament.spring.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatApiTemperamentRepository extends JpaRepository<Cat, String> {
}
