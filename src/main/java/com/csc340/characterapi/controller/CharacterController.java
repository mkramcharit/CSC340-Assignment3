package com.csc340.characterapi.controller;

import com.csc340.characterapi.entity.Character;
import com.csc340.characterapi.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 - alright so this is the controller
 -
 - every request that comes into the application has to go through this controller first
 -
 - this controller doesn't do anything itself, it just gives the request to the service and returns the response
 -
 - separation of concerns bro, look it up
 -
 - base URL for all endpoints on this controller will be /api/characters
 */
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * GET /api/characters
     * returns a list of all the characters from the database
     * if the database is empty, an empty list is returned rather than returning an error
     */
    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    /**
     * GET /api/characters/{id}
     * gets a specific character from the database by the character's id
     * in the case of not finding the character, returns a 404 not found response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/characters
     * adds a new character to the database
     * the character object is deserialized from the request body
     */
    @PostMapping
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        return ResponseEntity.ok(characterService.addCharacter(character));
    }

    /**
     * PUT /api/characters/{id}
     * updates an existing character
     * if the id fails to be found, a 404 is returned — caught in try-catch block
     */
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id,
                                                     @RequestBody Character updatedCharacter) {
        try {
            return ResponseEntity.ok(characterService.updateCharacter(id, updatedCharacter));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/characters/{id}
     * deletes a character from the database
     * returns a 204 response since there is no content to return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * GET /api/characters/universe/{universe}
     * gets a list of characters from a specific universe
     * for example, using "/universe/Marvel" will only return characters from that universe
     */
    @GetMapping("/universe/{universe}")
    public ResponseEntity<List<Character>> getCharactersByUniverse(@PathVariable String universe) {
        return ResponseEntity.ok(characterService.getCharactersByUniverse(universe));
    }

    /**
     * GET /api/characters/species/{species}
     * gets a list of characters from a specific species
     * for example, using "/species/Alien" will only return characters of that species
     */
    @GetMapping("/species/{species}")
    public ResponseEntity<List<Character>> getCharactersBySpecies(@PathVariable String species) {
        return ResponseEntity.ok(characterService.getCharactersBySpecies(species));
    }
}