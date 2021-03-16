package com.example.pets.entity;

public class MacotaBuilder {
	
	private MacotaBuilder() {
		
	}
	
	public static MacotaDTO fromVO (MacotaVO macotaVO) {
		MacotaVO origin=macotaVO;
		MacotaDTO destin = new MacotaDTO();
		
		destin.setOwner(origin.getOwner());
		destin.setPaternalSurname(origin.getPaternalSurname());
        destin.setMaternalSurname(origin.getMaternalSurname());
        destin.setName(origin.getName());
        destin.setBreed(origin.getBreed());
        destin.setGender(origin.getGender());
        destin.setBirthdate((origin.getBirthdate()));
        destin.setWeight(origin.getWeight());
        destin.setService(origin.getService());
		
        return destin;
	}
	
		public static MacotaVO fromDTO(MacotaDTO macotaDTO) {
			MacotaDTO origin= macotaDTO;
			MacotaVO destin= new MacotaVO();
			
			destin.setOwner(origin.getOwner());
			destin.setPaternalSurname(origin.getPaternalSurname());
	        destin.setMaternalSurname(origin.getMaternalSurname());
	        destin.setName(origin.getName());
	        destin.setBreed(origin.getBreed());
	        destin.setGender(origin.getGender());
	        destin.setBirthdate((origin.getBirthdate()));
	        destin.setWeight(origin.getWeight());
	        destin.setService(origin.getService());
			
			return destin;
		}

}
