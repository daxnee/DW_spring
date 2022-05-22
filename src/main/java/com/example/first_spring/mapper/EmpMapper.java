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

	// (12월 입사자) 중 sal가 가장 높은 사원 조회
	public List<EmpVO> selectEmpMaxSal(String hiredate);
	
	
	// (12월 입사자) 중 sal가 가장 높은 사원 조회2
	public List<EmpVO> selectEmpMax(String hiredate);
	
	
	// (empno)인 사원 조회
	public EmpVO getEmpEmpno(int empno);
	
	
	//0509 문제. job이 manager이고 sal이 2500이상받는 사원comm을 500으로 업데이트 후
	// 사원이름,직업,커미션 조회
	public List<EmpVO> selectEmpWhereJobAndSal(
		@Param("job") String job,
		@Param("sal") int sal); 
	// 파라미터가 2개 이상일때는 @Param 사용!

	// 특정 empno 사원 delete
	public List<EmpVO> getEmpRemoveCount(int empno);
	
	// 부서 번호가 10,30 이고 급여가 (파라미터값) 이상인 사람을 조회
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
	//Map안에 Object를 넣어준 이유는 key(Mybatis 컬럼명)의 value 값 타입이 어떻게 올지 몰라서 
	// 타입 모두를 포함하는 부모인 Object를 사용
	
	//0513 
	public int updateJobSal(EmpVO vo);
	

} 


