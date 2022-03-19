/**
 * @(#)RoleServiceImpl.java 2021/09/09.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/09.
 * Version 1.00.
 */
package hoangdang.bookstore.service.impl;

import java.util.List;

import hoangdang.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoangdang.bookstore.dao.RoleDao;
import hoangdang.bookstore.entity.Role;

/**
 * Class trien khai theo interface RoleService, Thao tac voi Class RoleDao de
 * thuc hien cac tac vu tuong ung
 * 

 * @version 1.00
 */
@Service
public class RoleServiceImpl implements RoleService {
	// Thong tin role dao
	@Autowired
	RoleDao roleDao;

	/**
	 * Tim kiem role theo id cua role
	 * 
	 * @param thong tin id cua role
	 * @return Role tim duoc
	 */
	@Override
	public Role findRoleById(int roleId) {
		return roleDao.findById(roleId).get();
	}
	
	/**
	 * Tim ten vai tro dua vao user id
	 * 
	 * @param thong tin user id
	 * @return danh sach ten vai tro tim duoc
	 */
	@Override
	public List<String> getRoleNames(int userId) {
		return roleDao.getRoleNames(userId);
	}

}
