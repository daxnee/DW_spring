package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.EmpVO;

@Mapper 
public interface EmpMapper {
	
//	emp의 사원데이터를 전부 다 가져오기
	/**
	 * @return
	 * comment : emp테이블 전체사원 조회
	 */
	public List<EmpVO> getEmpList();
	
	public EmpVO getEmp();
	
	public List<EmpVO> SelectEmpSal(int sal);

	public List<EmpVO> selectEmpMaxSal(String hiredate);
	
	public List<EmpVO> selectEmpMax(String hiredate);
}
