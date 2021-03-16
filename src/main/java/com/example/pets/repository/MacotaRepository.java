package com.example.pets.repository;

import com.example.pets.entity.MacotaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MacotaRepository extends JpaRepository<MacotaVO,Integer> {
	List<MacotaVO> findAllActive();
}
