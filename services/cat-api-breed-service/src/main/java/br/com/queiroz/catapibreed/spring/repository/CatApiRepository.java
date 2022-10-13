package br.com.queiroz.catapibreed.spring.repository;

import br.com.queiroz.catapibreed.spring.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatApiRepository extends JpaRepository <Breed, String> {
}
