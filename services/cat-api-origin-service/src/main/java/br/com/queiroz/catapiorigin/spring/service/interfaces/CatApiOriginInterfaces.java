package br.com.queiroz.catapiorigin.spring.service.interfaces;

import br.com.queiroz.catapiorigin.spring.dto.OriginDto;

import java.util.List;

public interface CatApiOriginInterfaces {
    List<OriginDto> getCatByOrigin(String origin);
}
