package com.example.pets.endpoint;
import com.example.pets.entity.MacotaDTO;
import com.example.pets.entity.MacotaVO;
import com.example.pets.service.MacotaService;
import com.example.pets.config.ResponseBody;
import com.example.pets.config.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MacotaEndpoint {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MacotaEndpoint.class);

	@Autowired
	private MacotaService macotaService;


	@PostMapping("/insert")
	public ResponseEntity<ResponseBody<Void>> insert(@RequestBody MacotaDTO macotaDTO){
		LOGGER.debug(">>>Insert()->mascotas:{}", macotaDTO);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			macotaService.insert(macotaDTO);
			response= Utils.<Void>response(HttpStatus.CREATED,"Se inserto el registro2",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro2",null);
		}
	return response;
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<ResponseBody<Void>> update(@PathVariable Integer id, @RequestBody Map<String,Object> data){
		LOGGER.debug(">>>> update->id: {}, mascotas: {}",id,data);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			macotaService.update(id,data);
			response= Utils.<Void>response(HttpStatus.OK,"Se actualizo el registro2",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro2",null);
		}
	return response;
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<ResponseBody<Void>> delete(@PathVariable Integer id){
		LOGGER.debug(">>>> delete->id: {}",id);
		ResponseEntity<ResponseBody<Void>> response=null;
		try{
			macotaService.delete(id);
			response= Utils.<Void>response(HttpStatus.OK,"Se actualizo el registro2",null);
		}catch (Exception e){
			response=Utils.<Void>response(HttpStatus.BAD_REQUEST,false,"No se puedo insertar el registro2",null);
		}
	return response;
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseBody<List<MacotaVO>>> findAll(){
		LOGGER.debug(">>>> findAll <<<<");
		ResponseEntity<ResponseBody<List<MacotaVO>>> response=null;
		List<MacotaVO> macotaVOList =null;
		try{
			macotaVOList =macotaService.findAllActive();
			response=Utils.<List<MacotaVO>>response(HttpStatus.OK,"Lista enonctrada2", macotaVOList);
		}catch (Exception e){
			response=Utils.<List<MacotaVO>>response(HttpStatus.NOT_FOUND,"Lista enonctrada2", macotaVOList);
		}
		return response;
	}

}
