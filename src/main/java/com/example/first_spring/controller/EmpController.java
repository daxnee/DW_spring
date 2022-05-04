package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.DeptService;
import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		return empService.getAllempList();
	}
	
	@GetMapping("/empName")
	public EmpVO callEmp() {
		return empService.getEmp();
	}
}

