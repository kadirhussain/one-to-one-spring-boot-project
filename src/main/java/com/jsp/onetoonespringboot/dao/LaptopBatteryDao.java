package com.jsp.onetoonespringboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onetoonespringboot.dto.Battery;
import com.jsp.onetoonespringboot.dto.Laptop;
import com.jsp.onetoonespringboot.repositry.BatteryRepository;
import com.jsp.onetoonespringboot.repositry.LaptopRepository;

@Repository
public class LaptopBatteryDao {
	
    @Autowired
	private LaptopRepository laptopRepository;
    
	@Autowired
	private BatteryRepository batteryRepository;
	

	
	
	public Laptop saveLaptop( Laptop laptop ) {
		return laptopRepository.save(laptop);
		
	}
  
	
	public List<Object> getLaptopById(int laptopId){
	List<Object> laptops=new ArrayList<Object>();
	Optional<Laptop> optional=laptopRepository.findById(laptopId);
	if(optional.isPresent()) {
		Laptop laptop=optional.get();
		
		Battery battery=laptop.getBattery();
		
		laptops.add(laptop);
		laptops.add(battery);
		return laptops;
	}else {
		return null;
	}
	}
	
	/*
	 * 
	 */

	public void deleteLaptopBatteryById(int laptopId) {
		Optional<Laptop> optional=laptopRepository.findById(laptopId);
		if(optional.isPresent()) {
			laptopRepository.delete(optional.get());
		}
	}
	
	/*
	 * getAllData
	 */
	public List<Battery> getAllLaptopBattery(){
		
		List<Battery> list=new ArrayList<Battery>();
		
		List<Laptop> laptops=laptopRepository.findAll();
		
		for (Laptop laptop : laptops) {
			list.add(laptop.getBattery());
		}
		return list;
	}
}
