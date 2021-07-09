package com.leantech.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leantech.example.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
