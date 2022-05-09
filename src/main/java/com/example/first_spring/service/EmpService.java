package com.example.first_spring.service;

import java.util.ArrayList;
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
	
	public List<EmpVO> SelectEmpSal(int sal){
		return empMapper.SelectEmpSal(sal);
	}
	
	public List<EmpVO> selectEmpMaxSal(String hiredate){
		return empMapper.selectEmpMaxSal(hiredate);
	}
	
	public List<EmpVO> selectEmpMax(String hiredate){
		int MaxSal=0;
		
		List<EmpVO> list = new ArrayList<EmpVO>();
		for(int i=0; i<list.size(); i++) {
			int sal = list.get(i).getSal();		
			if(MaxSal < sal) {
				MaxSal = sal;
				MaxSal = empMapper.selectEmpMax(hiredate).get(i).getSal();
			}
		}
		for(int i=0; i<list.size(); i++) {
			if(MaxSal == list.get(i).getSal()) {
				System.out.println(empMapper.selectEmpMax(hiredate));
				return list;
			}
		}
				return list;
	}
}
