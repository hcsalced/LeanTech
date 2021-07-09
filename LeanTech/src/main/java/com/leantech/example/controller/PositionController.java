package com.leantech.example.controller;

import com.leantech.example.model.Position;
import com.leantech.example.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/position"
)
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(final PositionService PositionService) {
        this.positionService = PositionService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Position Position) {
        positionService.create(Position);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable final int id) {
        return new ResponseEntity<>(positionService.get(id), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final int id) {
        positionService.update(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        positionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
