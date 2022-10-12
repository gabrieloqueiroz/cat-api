package br.com.queiroz.catapiall.spring.repository;

import br.com.queiroz.catapiall.spring.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatApiRepository extends JpaRepository <Cat, String> {
}
