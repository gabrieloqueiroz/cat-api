package br.com.queiroz.catapiorigin.spring.controller;

import br.com.queiroz.catapiorigin.spring.dto.OriginDto;
import br.com.queiroz.catapiorigin.spring.service.interfaces.CatApiOriginInterfaces;
import br.com.queiroz.utils.ConstantsUtils;
import br.com.queiroz.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static br.com.queiroz.utils.LoggingUtil.logInfo;

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
        logInfo(this.getClass(), "Starting search cat by origin");
        List<OriginDto> originDto = originInterfaces.getCatByOrigin(origin);

        logInfo(this.getClass(), "Finishing search cats by origin");
        return ResponseEntity.ok(originDto);
    }
}
