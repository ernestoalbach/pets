package com.example.pets.service.impl;

import com.example.pets.entity.MacotaBuilder;
import com.example.pets.entity.MacotaDTO;
import com.example.pets.entity.MacotaVO;
import com.example.pets.repository.MacotaRepository;
import com.example.pets.service.MacotaService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

@Service
public class MacotaServiceImpl implements MacotaService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MacotaServiceImpl.class);
	
	@Autowired
	private  MacotaRepository macotaRepository;
	
	@Override
	public void insert(MacotaDTO macotaDTO) throws Exception{
		MacotaVO vo= null;
		LOGGER.debug(">>>>Insert()->mascotas:{} ",macotaDTO);
		try {
			vo= MacotaBuilder.fromDTO(macotaDTO);
			vo.setId(0);
			vo.setCreatedAt(new Date());
			vo.setCreatedBy(1);
			vo.setModifiedAt(new Date());
			vo.setModifiedBy(1);
			vo.setStatus(1);
			macotaRepository.save(vo);
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
	}
	
	@Override
	public void update(Integer id, Map<String,Object>data) throws Exception{
		LOGGER.debug(">>> update-->id: {}, mascotas: {}",id,data);
		try {
			 Optional<MacotaVO> macotaOptional = macotaRepository.findById(id);
			 if(!macotaOptional.isPresent()) {
				 throw new Exception("No existe el registro");
			 }
			 
			 //owner
			 
			 LOGGER.debug("birthdate:{}", data.get("birthdate"));
			 
			 if(data.containsKey("owner")){
				 String owner = data.get("owner").toString();
				 macotaOptional.get().setOwner(owner);
			 }
			//paternalSurname
				if(data.containsKey("paternalSurname")){
					String paternalSurname = data.get("paternalSurname").toString();
					macotaOptional.get().setPaternalSurname(paternalSurname);
				}
				//maternalSurname
				if(data.containsKey("maternalSurname")){
					String maternalSurname = data.get("maternalSurname").toString();
					macotaOptional.get().setMaternalSurname(maternalSurname);
				}
				
				//name
				if(data.containsKey("name")){
					String name = data.get("name").toString();
					macotaOptional.get().setName(name);
				}
				
				//breed
				if(data.containsKey("breed")){
					String breed = data.get("breed").toString();
					macotaOptional.get().setBreed(breed);
				}
				
				//gender
				if(data.containsKey("gender")){
					String gender = data.get("gender").toString();
					macotaOptional.get().setGender(gender);
				}
				
				//birthdate
				if(data.containsKey("birthdate")){
					Date birthdate = new SimpleDateFormat("yyyy-MM-dd").parse((String) data.get("birthdate"));
					macotaOptional.get().setBirthdate(birthdate);
				}
			 
				//weigth
				if(data.containsKey("weight")) {
					float weight = Float.parseFloat(data.get("weight").toString());
					macotaOptional.get().setWeight(weight);
				}
				
				//service
				if(data.containsKey("service")) {
					String service = data.get("service").toString();
					macotaOptional.get().setService(service);				}
			
				//status
				if(data.containsKey("status")){
					Integer status = (Integer)data.get("status");
					macotaOptional.get().setStatus(status);
				}
				//createdAt
				if(data.containsKey("createdAt")){
					Date createdAt = (Date)data.get("createdAt");
					macotaOptional.get().setCreatedAt(createdAt);
				}
				//createdBy
				if(data.containsKey("createdBy")){
					Integer createdBy = (Integer)data.get("createdBy");
					macotaOptional.get().setCreatedBy(createdBy);
				}
				//modifiedAt
				if(data.containsKey("modifiedAt")){
					Date modifiedAt = (Date)data.get("modifiedAt");
					macotaOptional.get().setModifiedAt(modifiedAt);
				}
				//modifiedBy
				if(data.containsKey("modifiedBy")){
					Integer modifiedBy = (Integer)data.get("modifiedBy");
					macotaOptional.get().setModifiedBy(modifiedBy);
				}
				macotaRepository.save(macotaOptional.get());
			}catch (Exception e){
				LOGGER.error("Exception: {}",e);
				throw new Exception(e);
			}
	
	}
	
	
	@Override
	public void delete(Integer id) throws Exception{
		LOGGER.debug(">>>> delete->id: {}",id);
		try{
			MacotaVO macotaVO = macotaRepository.getOne(id);
			if (macotaVO == null) {
				throw new Exception("No existe el registro");
			}
			if (macotaVO.getStatus() == 0) {
				throw new Exception("No existe el registro");
			}
			macotaVO.setStatus(0);
			macotaRepository.save(macotaVO);
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
	}
	
	@Override
	public List<MacotaVO> findAll() throws Exception{
		LOGGER.debug(">>>> findAll <<<<");
		List<MacotaVO> macotaVOList =null;
		try{
			macotaVOList = macotaRepository.findAll();
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
		LOGGER.debug(">>>> findAll <<<< macotaList: {}", macotaVOList);
		return macotaVOList;
	}
	
	@Override
	public List<MacotaVO> findAllActive() throws Exception {
		LOGGER.debug(">>>> findAll <<<<");
		List<MacotaVO> macotaVOList =null;
		try{
			macotaVOList = macotaRepository.findAllActive();
		}catch (Exception e){
			LOGGER.error("Exception: {}",e);
			throw new Exception(e);
		}
		LOGGER.debug(">>>> findAll <<<< macotaList: {}", macotaVOList);
		return macotaVOList;
	}
	
	
	

}
	
	

