package com.pt.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pt.as.entity.Admin;
import com.pt.as.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping(value = "/admin/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin saveAdmin(@RequestBody Admin a) {
		a = adminService.saveAdmin(a);
		return a;
	}

	@GetMapping(value = "/admin/findById/{adminId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin findById(@PathVariable long adminId) {
		Admin a = adminService.findById(adminId);
		System.out.println("###" + a);
		return a;
	}

	@DeleteMapping(value = "/admin/delete/{adminId}")
	public String deleteAdmin(@PathVariable long adminId) {
		String msg = adminService.deleteAdmin(adminId);
		return msg;

	}
	
	@PutMapping(value = "/admin/updateAdmin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin updateAdmin(@RequestBody Admin a) {
		return adminService.updateAdmin(a);	
	}
	
	@GetMapping(value="/admin/getAll" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Admin> getAll()
	{
		return adminService.getAll();
	}

}
