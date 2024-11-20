package com.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petapi.Pet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PetDao {

    Pet getPet() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = null;
        pet = mapper.readValue(response, Pet.class);
        return pet;
    }
}
