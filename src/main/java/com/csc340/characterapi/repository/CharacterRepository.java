package com.csc340.characterapi.repository;

import com.csc340.characterapi.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 - Repository layer = database access
 - JpaRepository gives me all basic CRUD operations for free
 - no SQL required for basic stuff (huge W)
 */
public interface CharacterRepository extends JpaRepository<Character, Long> {

    /*
     - find all characters from a specific universe
     - Spring auto-generates the query based on the method name
     */
    List<Character> findByUniverse(String universe);

    /*
     - find all characters of a specific species
     - again, no SQL needed because Spring is magic
     */
    List<Character> findBySpecies(String species);
}