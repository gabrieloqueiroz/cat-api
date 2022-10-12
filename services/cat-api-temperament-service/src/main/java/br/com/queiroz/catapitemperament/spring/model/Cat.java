package br.com.queiroz.catapitemperament.spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "cats")
public class Cat {

    @Id
    private String id;
    private String name;
    private String temperament;
    private String origin;
    private String description;
    private String wikipedia_url;
}
