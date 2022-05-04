package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<EmpVO> getAllempList(){
		return empMapper.getEmpList();	
	}
	
	public EmpVO getEmp() {
		return empMapper.getEmp();
	}
	

}
