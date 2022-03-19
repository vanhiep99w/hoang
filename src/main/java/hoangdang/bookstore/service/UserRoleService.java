/**
 * @(#)UserRoleService.java 2021/08/24.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/08/24.
 * Version 1.00.
 */
package hoangdang.bookstore.service;

import java.util.List;

import hoangdang.bookstore.entity.UserRole;

/**
 * Class cung cap cac dich vu thao tac voi table User_Role trong database
 * 

 * @version 1.00
 */
public interface UserRoleService{
	
	/**
	 * Luu user role vao database
	 * 
	 * @param userRole
	 */
	void save(UserRole userRole);

	List<UserRole> findAll();

	List<UserRole> findAllAdminOrDirector();

	void delete(Integer id);
	
}
