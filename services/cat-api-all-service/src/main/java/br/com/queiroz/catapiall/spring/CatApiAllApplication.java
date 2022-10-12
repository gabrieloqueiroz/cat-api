package br.com.queiroz.catapiall.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatApiAllApplication {


        public static void main(String[] args) {
            SpringApplication.run(CatApiAllApplication.class, args);
        }
}