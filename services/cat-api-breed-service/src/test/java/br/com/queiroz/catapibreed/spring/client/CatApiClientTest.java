package br.com.queiroz.catapibreed.spring.client;

import br.com.queiroz.CatApiBreedApplication;
import br.com.queiroz.catapibreed.spring.client.configuration.CatApiClientConfiguration;
import br.com.queiroz.catapibreed.spring.model.Breed;
import br.com.queiroz.config.SelfConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.QueueDispatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static br.com.queiroz.catapibreed.spring.mother.UtilsMother.getBreed;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = { CatApiBreedApplication.class, SelfConfiguration.class }, webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatApiClientTest {

    @Autowired
    CatApiClient catApiClient;
    public static String serverBaseUrl;
    @MockBean
    private CatApiClientConfiguration catApiClientConfiguration;
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static MockWebServer mockServer ;

    @BeforeEach
    public void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.setDispatcher(new QueueDispatcher());
        mockServer.start();
        serverBaseUrl = "http://127.0.0.1:" + mockServer.getPort();
        when(catApiClientConfiguration.getBreedById(any())).thenReturn(serverBaseUrl);
    }

    @Test
    public void should_return_breed_by_temperament() throws JsonProcessingException {
        //Given
        String insert = "Sensitive";
        Breed expected = getBreed();

        mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(OBJECT_MAPPER.writeValueAsString(expected)).addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));

        //When
        Breed response = catApiClient.getBreedById(insert);

        //Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expected.getId(), response.getId());
        Assertions.assertEquals(expected.getCountry_code(), response.getCountry_code());
        Assertions.assertEquals(expected.getDescription(), response.getDescription());
        Assertions.assertEquals(expected.getName(), response.getName());
        Assertions.assertEquals(expected.getOrigin(), response.getOrigin());
        Assertions.assertEquals(expected.getLife_span(), response.getLife_span());
    }
}
