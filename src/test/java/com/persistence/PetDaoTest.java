package com.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petapi.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PetDaoTest {

    @Test
    void getPetSuccess() throws JsonProcessingException {
        PetDao petDao = new PetDao();
        Pet pet = petDao.getPet();
        assertNotNull(pet);
        assertEquals("Mike", pet.getName());
    }
}