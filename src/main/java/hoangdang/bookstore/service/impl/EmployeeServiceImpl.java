/**
 * @(#)RoleServiceImpl.java 2021/09/10.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/10.
 * Version 1.00.
 */
package hoangdang.bookstore.service.impl;

import java.util.List;

import hoangdang.bookstore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoangdang.bookstore.dao.EmployeeDao;
import hoangdang.bookstore.entity.Employee;
import hoangdang.bookstore.model.EmployeeModel;

/**
 * Class trien khai theo interface EmployeeService, Thao tac voi Class EmployeeDao de
 * thuc hien cac tac vu tuong ung
 * 

 * @version 1.00
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<EmployeeModel> getListEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getListEmployee();
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

}
