package br.com.queiroz.catapibreed.spring.mother;

import br.com.queiroz.catapibreed.spring.dto.BreedDto;
import br.com.queiroz.catapibreed.spring.model.Breed;

public class UtilsMother {

    public static BreedDto getBreedDto(){
        BreedDto breedDto = new BreedDto();

        breedDto.setDescription("American Bobtails are loving and incredibly intelligent cats possessing a distinctive wild appearance. They are extremely interactive cats that bond with their human family with great devotion.");
        breedDto.setName("American Bobtai");
        breedDto.setLife_spam("1 - 4");
        breedDto.setWikipedia_url("https://en.wikipedia.org/wiki/American_Bobtail");
        breedDto.setOrigin("United States");

        return breedDto;
    }

    public static Breed getBreed(){
        Breed breed = new Breed();
        breed.setId("abob");
        breed.setName("American Bobtai");
        breed.setDescription("American Bobtails are loving and incredibly intelligent cats possessing a distinctive wild appearance. They are extremely interactive cats that bond with their human family with great devotion.");
        breed.setOrigin("United States");
        breed.setLife_spam("1 - 4");
        breed.setWikipedia_url("https://en.wikipedia.org/wiki/American_Bobtail");
        breed.setCountry_code("ts");

        return breed;
    }
}
