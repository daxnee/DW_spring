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
	
	
	public List<EmpVO> getEmpName() {
		return empMapper.getEmpName();
	}
	
	public List<EmpVO> getEmpComm(){
		return empMapper.getEmpComm();
	}
	
	public List<EmpVO> getEmpHireDate(){
		return empMapper.getEmpHireDate();
	}
	
	public EmpVO getEmp(int empno) {
		return empMapper.getEmp(empno);
	}
	
	public List<EmpVO> selectEmpWhereJobAndSal(String job, int sal) {
		if(job.equals("SALESMAN")) {// 만약 job이 salesman이라면 return null;  
			return null;
		}
		return empMapper.selectEmpWhereJobAndSal(job, sal);
	}
	
	public List<EmpVO> selectEmpHowSal(int sal){
		return empMapper.selectEmpHowSal(sal);
	}
	
	public List<EmpVO> selectEmpMgr(){
		return empMapper.selectEmpMgr();
	}
	
	public List<EmpVO> selectEmpHiredate(String hiredate){
		List<EmpVO> list = empMapper.selectEmpHiredate(hiredate);
		int size = list.size();
		if(size <= 3) {
			String year = "1981";
			list = empMapper.selectEmpHiredate(year);
		}
		
		return list;
	} 
		
}
