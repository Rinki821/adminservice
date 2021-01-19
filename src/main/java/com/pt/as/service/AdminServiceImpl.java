package com.pt.as.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.pt.as.entity.Admin;
import com.pt.as.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin a) {
		a = adminRepository.save(a);
		return a;
	}

	@Override
	public Admin findById(long adminId) {
		return adminRepository.findById(adminId).get();
	}

	@Override
	public String deleteAdmin(long adminId) {
		Admin a = adminRepository.findById(adminId).get();
		adminRepository.delete(a);
		return "admin is deleted";
	}

	@Override
	public Admin updateAdmin(Admin a) {
		Admin existingAdmin = this.findById(a.getId());
		if (existingAdmin == null) {
			return null;
		}

		else {
			existingAdmin.setName(a.getName());
			existingAdmin.setPannum(a.getPannum());
			adminRepository.save(existingAdmin);
			return existingAdmin;
		}

	}
	
	public List<Admin> getAll(){
		return adminRepository.findAll();
		
		
	}

}
