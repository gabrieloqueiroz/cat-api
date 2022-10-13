package br.com.queiroz.catapiorigin.spring.repository;

import br.com.queiroz.catapiorigin.spring.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatApiOriginRepository extends JpaRepository<Cat, String> {
    List<Cat> findByOrigin(String origin);
}
