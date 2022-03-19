/**
 * @(#)CategoryRestController.java 2021/09/21.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/21.
 * Version 1.00.
 */
package hoangdang.bookstore.rest.controller;

import java.util.List;

import hoangdang.bookstore.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoangdang.bookstore.entity.Manufacturer;
import hoangdang.bookstore.model.ManufacturerModel;

/**
 * Class cung cap cac dich vu rest api cho bang employee
 * 

 * @version 1.00
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manufactures")
public class ManufacturerRestController {
	@Autowired
    ManufacturerService manufacturerService;
	
	@PostMapping("/form")
	public ManufacturerModel create(@RequestBody ManufacturerModel manufacturerModel) {
		return manufacturerService.createManufacturer(manufacturerModel);
	}
	
	@GetMapping()
	public List<Manufacturer> getAll(){
		return manufacturerService.findAll();
	}
	
	@GetMapping("/form/{id}")
	public ManufacturerModel getOneUserById(@PathVariable("id") Integer id) {
		return manufacturerService.getOneManufacturerById(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		manufacturerService.delete(id);
	}
	
	@PutMapping("/form/{id}")
	public ManufacturerModel update(@PathVariable("id") Integer id, @RequestBody ManufacturerModel manufacturerModel) {
		return manufacturerService.updateManufacturer(manufacturerModel);
	}
}
