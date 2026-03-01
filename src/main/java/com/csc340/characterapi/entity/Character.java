package com.csc340.characterapi.entity;

import jakarta.persistence.*;

/*
 - this annotation specifies that this is an entity
 - must use this or nothing will work
 */
@Entity

/*
 - @Table means I can name the table myself
 - gonna call it characters bc that's what it is.
 */
@Table(name = "characters")
public class Character {

    /*
     - @Id means this is the primary key - pretty self expl
     - @GeneratedValue means the DB will handle the counting of IDs
     - so I don't have to do that manually
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    /*
     - this is the character's name
     - can never be null
     */
    @Column(nullable = false)
    private String name;

    /*
     - bio for the character
     - also can't be null
     */
    @Column(nullable = false)
    private String description;

    /*
     - the extra fields that were required for the assignment
     - keeping them as Strings for simplicity
     */
    private String universe;
    private String species;

    /*
     - no-arg constructor - JPA requires this
     - don't delete it or nothing will work lol
     */
    public Character() {}

    /*
     - constructor with parameters
     - allows me to create a character without setting each field
     */
    public Character(String name, String description, String universe, String species) {
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.species = species;
    }

    // ===== getters n setters (the boring but necessary part) =====

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}