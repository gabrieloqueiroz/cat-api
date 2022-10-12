package br.com.queiroz.catapitemperament.spring.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static br.com.queiroz.utils.ConstantsUtils.CAT_API_ALL_BREEDS;
import static br.com.queiroz.utils.ConstantsUtils.PATH_SEPARATOR;

@Data
@Component
public class CatApiClientConfiguration {

    @Value("${cat.api.base.url}")
    private String clientHost;

    public String getUrl(){
        return this.getClientHost();
    }

    public String getAllBreedsUrl(){
        return this.getUrl() + PATH_SEPARATOR + CAT_API_ALL_BREEDS;
    }
}
