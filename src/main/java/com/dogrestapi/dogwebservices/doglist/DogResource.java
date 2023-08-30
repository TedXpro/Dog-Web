package com.dogrestapi.dogwebservices.dogList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogResource {
    private DogService dogService;

    public DogResource(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/users/{username}/dogs")
    public List<Dog> retrieveDogs(@PathVariable String username) {
        return dogService.findByUsername(username);
    }

    @GetMapping("/users/{username}/dogs/{id}")
    public Dog retrieveDog(@PathVariable String username,
            @PathVariable int id) {
        return dogService.findById(id);
    }

    @GetMapping("/users/{username}/dogs/breeds/{breed}")
    public List<Dog> retrieveBreed(@PathVariable String username,
            @PathVariable String breed) {
        return dogService.findByBreed(breed);
    }

    @DeleteMapping("/users/{username}/dogs/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable String username,
            @PathVariable int id) {
        dogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/dogs/{id}")
    public Dog updateDog(@PathVariable String username,
            @PathVariable int id, @RequestBody Dog dog) { // RequestBody is what is the json i want to update
        dogService.updateDog(dog);
        return dog;
    }

    @PostMapping("/users/{username}/dog")
    public Dog createDog(
            @RequestBody Dog dog) {
        Dog createdDog = dogService.addDog(dog.getName(),
                dog.getAge(), dog.getColor(), dog.getBreed());

        return createdDog;
    }

}
