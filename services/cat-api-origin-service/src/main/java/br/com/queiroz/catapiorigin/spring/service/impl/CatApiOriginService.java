package br.com.queiroz.catapiorigin.spring.service.impl;

import br.com.queiroz.catapiorigin.spring.dto.OriginDto;
import br.com.queiroz.catapiorigin.spring.model.Cat;
import br.com.queiroz.catapiorigin.spring.repository.CatApiOriginRepository;
import br.com.queiroz.catapiorigin.spring.service.interfaces.CatApiOriginInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatApiOriginService implements CatApiOriginInterfaces {
    CatApiOriginRepository originRepository;
    ModelMapper mapper;

    @Autowired
    public CatApiOriginService(CatApiOriginRepository originRepository,ModelMapper mapper) {
        this.originRepository = originRepository;
        this.mapper = mapper;
    }

    @Override
    public List<OriginDto> getCatByOrigin(String origin) {
        List<Cat> catsByOrigin = originRepository.findByOrigin(origin);
        System.out.println("Encontrados " + catsByOrigin.size());

        List<OriginDto> catsByOriginDto = catsByOrigin
                .stream()
                .map(cat ->
                    mapper.map(cat, OriginDto.class)
                ).toList();

        if (catsByOriginDto.isEmpty()) throw new RuntimeException("Cat by origin not found");

        System.out.println("Da origem " + origin + " Foram encontrados " + catsByOriginDto.size());
        return catsByOriginDto;
    }
}
