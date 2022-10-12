package br.com.queiroz.catapibatch.spring.client;
import br.com.queiroz.catapibatch.spring.client.configuration.CatApiClientConfiguration;
import br.com.queiroz.catapibatch.spring.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CatApiClient {
    WebClient webClient;
    CatApiClientConfiguration catApiClientConfiguration;

    @Autowired
    public CatApiClient(WebClient webClient, CatApiClientConfiguration catApiClientConfiguration) {
        this.webClient = webClient;
        this.catApiClientConfiguration = catApiClientConfiguration;
    }

    public Flux<Cat> findAllBreed(){
        return webClient
                .get()
                .uri(catApiClientConfiguration.getAllBreedsUrl())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .retrieve()
                .bodyToFlux(Cat.class);
    }
}
