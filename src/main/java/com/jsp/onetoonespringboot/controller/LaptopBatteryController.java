package com.jsp.onetoonespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onetoonespringboot.dao.LaptopBatteryDao;
import com.jsp.onetoonespringboot.dto.Battery;
import com.jsp.onetoonespringboot.dto.Laptop;

@RestController
public class LaptopBatteryController {
	
	@Autowired
	private LaptopBatteryDao batteryDao;
	
	
	@PostMapping(value = "/saveLaptopBattery")
	public Laptop saveLaptop(@RequestBody Laptop laptop ) {
		return batteryDao.saveLaptop(laptop);
	}
	@GetMapping(value = "/getById/{laptopId}")
	public List<Object> getLaptopById(@PathVariable int laptopId){
		return batteryDao.getLaptopById(laptopId);
		
	}
	
	@DeleteMapping(value = "deleteById/{laptopId}")
	public void deleteLaptopBatteryById(@PathVariable int laptopId) {
		batteryDao.deleteLaptopBatteryById(laptopId);
	}
	
	/*
	 * getAllLaptopBattery
	 */
	@GetMapping(value = "/getAllLaptopBattery")
	public List<Battery> getAllLaptopBattery(){
		return batteryDao.getAllLaptopBattery();
	}
	

}
