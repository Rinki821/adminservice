package com.pt.as.service;

import java.util.List;

import com.pt.as.entity.Admin;

public interface AdminService {
	
	Admin saveAdmin(Admin a);
	Admin findById(long adminId);
	String deleteAdmin(long adminId);
	Admin updateAdmin(Admin a);
	List<Admin> getAll();
}
