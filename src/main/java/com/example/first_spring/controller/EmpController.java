package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
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
	
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callEmpSal(@PathVariable("sal") int sal){
		return empService.SelectEmpSal(sal);
	}
	
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callEmpMaxSal(@PathVariable("year")String hiredate){
		return empService.selectEmpMaxSal(hiredate);
	}
	
	@GetMapping("/emp/hiredate/{hire}")
	public List<EmpVO> callEmpMax(@PathVariable("hire")String hiredate){
		return empService.selectEmpMax(hiredate);
	}
}

