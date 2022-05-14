package com.example.first_spring.mapper;

import java.util.List;
import java.util.Map;

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
	
	//0513 모든 emp사원 구하기 
	public List<EmpVO> selectAllEmp();
	
	//job이 SALESMAN이면서 sal이 파라미터값인 사원 조회
	public List<EmpVO> SelectEmpSal(int sal);

	public List<EmpVO> selectEmpMaxSal(String hiredate);
	
	public List<EmpVO> selectEmpMax(String hiredate);
	
	public List<EmpVO> getEmpComm();//
	
	public List<EmpVO> getEmpHireDate();
	
	public List<EmpVO> getEmpRemoveCount(int empno);
	
	
	public EmpVO getEmp(int empno);
	
	//0509문제1
	public List<EmpVO> selectEmpWhereJobAndSal(
		@Param("job") String job,
		@Param("sal") int sal); 
	// 파라미터가 2개 이상일때는 @Param 사용!

	public List<EmpVO> selectEmpHowSal(int sal);

	
	public List<EmpVO> selectEmpHiredate(String hiredate);

	//insert 
	//0510 문제1(2)
	public int insertEmp(EmpVO empVO);

	//delete 
	public int deleteEmp(int empno);
	
	//update
	public int updateEmp(EmpVO empVO);
	
	
	
	//0510 문제1() 
	// 1. emp에 없는 부서번호(40)를 찾아서 @postMapping으로 해당 부서번호로 insert하기 
	//public EmpVO selectDeptNo();
	public EmpVO selectDeptNo();

	//0511 if문
	public List<EmpVO> selectEmpMgr(@Param("isMgr") String isMgr);
	//MyBatis에는 boolean 형이 없기 때문에 파라미터로 String을 받는다.
	
	public int updateEmpno(EmpVO vo); 
	

	
	//----------------------0512
	//문제1. 사원번호가 7902번인 사원 job을 SALESMAN, SAL을 3500으로 수정
	public int updateJobAndSal(EmpVO vo);
	

	//-------------문제 2 ---------------
	public int updateEmpSal(EmpVO vo);
	//들어온 vo를 통해 update 실행
	
	public EmpVO selectEmpCommSal(@Param("empno") int empno);
	//empno 조회하는거라 EmpVO (pk이니까)
	// {empno}로 조회
	
	
	public List<Map<String, Object>> selectEmpMapList();
	
	//0513 
	public int updateJobSal(EmpVO vo);
} 


