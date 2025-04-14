package ru.innopolis.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.shop.entity.Television;
import ru.innopolis.shop.repositories.TelevisionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/televisions")
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    @GetMapping
    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    @PostMapping
    public Television createTelevision(@RequestBody Television television) {
        return televisionRepository.save(television);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        return televisionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television televisionDetails) {
        return televisionRepository.findById(id)
                .map(television -> {
                    television.setSize(televisionDetails.getSize());
                    television.setModel(televisionDetails.getModel());
                    Television updatedTelevision = televisionRepository.save(television);
                    return ResponseEntity.ok(updatedTelevision);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        return televisionRepository.findById(id)
                .map(television -> {
                    televisionRepository.delete(television);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
