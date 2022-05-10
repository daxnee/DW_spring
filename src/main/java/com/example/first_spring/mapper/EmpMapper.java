package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.EmpVO;

@Mapper 
public interface EmpMapper {
	
//	emp의 사원데이터를 전부 다 가져오기
	/**
	 * @return
	 * comment : emp테이블 전체사원 조회
	 */
	
	
	public List<EmpVO> SelectEmpSal(int sal);

	public List<EmpVO> selectEmpMaxSal(String hiredate);
	
	public List<EmpVO> selectEmpMax(String hiredate);
	
	public List<EmpVO> getEmpComm();//
	
	public List<EmpVO> getEmpHireDate();
	
	
	public EmpVO getEmp(int empno);
	
	//0509문제1
	public List<EmpVO> selectEmpWhereJobAndSal(
		@Param("job") String job,
		@Param("sal") int sal); 
	// 파라미터가 2개 이상일때는 @Param 사용!

	public List<EmpVO> selectEmpHowSal(int sal);

	public List<EmpVO> selectEmpMgr();
	
	public List<EmpVO> selectEmpHiredate(String hiredate);

	//insert 
	//0510 문제1(2)
	public int insertEmp(EmpVO empVO);

	//delete 
	public int deleteEmp(int empno);
	
	//update
	public int updateEmp(EmpVO empVO);
	//d
	//0510 문제1() 
	// 1. emp에 없는 부서번호(40)를 찾아서 @postMapping으로 해당 부서번호로 insert하기 
	public EmpVO selectDeptNo();
}



