package br.com.queiroz.catapiall.spring.controller;

import br.com.queiroz.catapiall.spring.dto.CatDto;
import br.com.queiroz.catapiall.spring.service.interfaces.CatApiInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ConstantsUtils.PATH_SEPARATOR + ConstantsUtils.CAT_API_ALL)
public class CatApiAllController {

    CatApiInterfaces catApiInterfaces;

    @Autowired
    public CatApiAllController(CatApiInterfaces catApiInterfaces) {
        this.catApiInterfaces = catApiInterfaces;
    }

    @GetMapping
    @Cacheable(value = "allBreed")
    public ResponseEntity<List<CatDto>> getAllBreed() {

        List<CatDto> allBreed = catApiInterfaces.getAllBreed();

        return ResponseEntity.ok(allBreed);
    }
}
