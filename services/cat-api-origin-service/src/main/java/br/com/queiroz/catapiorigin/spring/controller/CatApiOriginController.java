package br.com.queiroz.catapiorigin.spring.controller;

import br.com.queiroz.catapiorigin.spring.dto.OriginDto;
import br.com.queiroz.catapiorigin.spring.service.interfaces.CatApiOriginInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ConstantsUtils.CAT_API_ORIGIN)
public class CatApiOriginController {

    CatApiOriginInterfaces originInterfaces;

    @Autowired
    public CatApiOriginController(CatApiOriginInterfaces originInterfaces) {
        this.originInterfaces = originInterfaces;
    }

    @GetMapping("/{origin}")
    public ResponseEntity<List<OriginDto>> getCatByOrigin(@PathVariable String origin){
        List<OriginDto> originDto = originInterfaces.getCatByOrigin(origin);

        return ResponseEntity.ok(originDto);
    }
}
