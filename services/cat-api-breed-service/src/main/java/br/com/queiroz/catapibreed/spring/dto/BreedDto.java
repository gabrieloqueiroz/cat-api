package br.com.queiroz.catapibreed.spring.dto;

import lombok.Data;

@Data
public class BreedDto {
    private String name;
    private String description;
    private String origin;
    private String life_spam;
    private String wikipedia_url;
}
