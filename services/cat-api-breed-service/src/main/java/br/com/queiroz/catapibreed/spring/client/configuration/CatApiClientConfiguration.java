package br.com.queiroz.catapibreed.spring.client.configuration;

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

    public String getBreedById(String breed){
        return this.getUrl() + PATH_SEPARATOR + CAT_API_ALL_BREEDS + PATH_SEPARATOR + breed;
    }
}
