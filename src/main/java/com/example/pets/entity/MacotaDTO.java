package com.example.pets.entity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;


public class MacotaDTO {
	private Integer id;
	private String owner;
	private String paternalSurname;
	private String maternalSurname;
	private String name;
	private String breed;
	private String gender;
	private Date birthdate;
	private float weight;
	private String service;
	private Integer status;
    private Date createdAt;
    private Integer createdBy;
    private Date modifiedAt;
    private Integer modifiedBy; 
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPaternalSurname() {
		return paternalSurname;
	}
	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}
	public String getMaternalSurname() {
		return maternalSurname;
	}
	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Override
	public String toString(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		}catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}	
}
