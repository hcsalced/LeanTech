package com.leantech.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.example.model.Position;
import com.leantech.example.repository.PositionRepository;

import java.util.List;

@Service
public class PositionService {

private final PositionRepository positionRepository;
    
    @Autowired
    public PositionService(final PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position get(final int id) {
        final Position position = positionRepository.getById(id);
        return position;
    }

    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    public void update(final int id) {
    	final Position positionFind = get(id);
    	positionRepository.save(positionFind);
    }

    public void delete(final int position) {
    	final Position positionFind = get(position);
        positionRepository.delete(positionFind);
    }
    
    public void create(final Position position) {
        positionRepository.save(position);
    }
}
