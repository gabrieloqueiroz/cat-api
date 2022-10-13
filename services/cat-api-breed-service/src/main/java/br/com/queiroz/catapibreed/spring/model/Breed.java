package br.com.queiroz.catapibreed.spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Breed {

    @Id
    private String id;
    private String name;
    private String description;
    private String origin;
    private String life_spam;
    private String wikipedia_url;
    private String country_code;
}
