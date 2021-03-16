package com.example.pets.service;
import com.example.pets.entity.MacotaDTO;
import com.example.pets.entity.MacotaVO;
import java.util.List;
import java.util.Map;
public interface MacotaService {
	
		void insert (MacotaDTO macotaDTO) throws Exception;
		void update (Integer id, Map<String, Object>data) throws Exception;
		void delete (Integer id) throws Exception;
		List<MacotaVO> findAll() throws Exception;
		List<MacotaVO> findAllActive() throws Exception;
		
}
