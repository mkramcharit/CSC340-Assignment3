package com.csc340.characterapi.service;

import com.csc340.characterapi.entity.Character;
import com.csc340.characterapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 - service layer = the middleman, kinda like a group project member
 - who actually does their part
 - controller asks service, service asks repo, repo talks to DB
 - keeps everything from being one giant mess of spaghetti code
 */
@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    // Spring will do the wiring for us
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     - grab every character in the database
     */
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    /**
     - find one specific character by their id
     - returns an optional in case the character doesn't exist in the database
     */
    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    /**
     - adds a new character to the database
     - the .save() method does the heavy lifting
     */
    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    /**
     - updates an existing character
     - keeps the same id for the character
     - throws a fit if it can't find the character by id
     */
    public Character updateCharacter(Long id, Character updatedCharacter) {

        Character existing = characterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Character with id " + id + " not found"));

        existing.setName(updatedCharacter.getName());
        existing.setDescription(updatedCharacter.getDescription());
        existing.setUniverse(updatedCharacter.getUniverse());
        existing.setSpecies(updatedCharacter.getSpecies());

        return characterRepository.save(existing);
    }

    /**
     - grabs a character out of the database
     */
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    /**
     - custom query to filter characters by their universe
     - maybe you only want to work with Marvel characters, for example
     */
    public List<Character> getCharactersByUniverse(String universe) {
        return characterRepository.findByUniverse(universe);
    }

    /**
     - custom query to filter characters by the species of the character
     */
    public List<Character> getCharactersBySpecies(String species) {
        return characterRepository.findBySpecies(species);
    }
}