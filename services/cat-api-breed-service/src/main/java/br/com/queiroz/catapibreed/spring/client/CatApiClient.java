package br.com.queiroz.catapibreed.spring.client;

import br.com.queiroz.catapibreed.spring.client.configuration.CatApiClientConfiguration;
import br.com.queiroz.catapibreed.spring.model.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CatApiClient {
    WebClient webClient;
    CatApiClientConfiguration catApiClientConfiguration;

    @Autowired
    public CatApiClient(WebClient webClient, CatApiClientConfiguration catApiClientConfiguration) {
        this.webClient = webClient;
        this.catApiClientConfiguration = catApiClientConfiguration;
    }

    public Breed getBreedById(String breed) {
        return webClient
                .get()
                .uri(catApiClientConfiguration.getBreedById(breed))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .retrieve()
                .bodyToMono(Breed.class).block();
    }
}
