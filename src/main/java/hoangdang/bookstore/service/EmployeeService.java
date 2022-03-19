/**
 * @(#)RoleService.java 2021/09/10.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/10.
 * Version 1.00.
 */
package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.Employee;
import hoangdang.bookstore.model.EmployeeModel;

/**
 * Class cung cap cac dich vu thao tac voi table Employee trong database
 * 

 * @version 1.00
 */
public interface EmployeeService {

	List<EmployeeModel> getListEmployee();

	void save(Employee employee);
	
}
