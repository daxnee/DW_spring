package com.example.first_spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	
	public List<EmpVO> selectEmpMaxSal(String hiredate){
		return empMapper.selectEmpMaxSal(hiredate);
	}
	
	public EmpVO getEmp(int empno) {
		return empMapper.getEmp(empno);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public List<EmpVO> selectEmpWhereJobAndSal(String job, int sal) {
		if(job.equals("SALESMAN")) {// 만약 job이 salesman이라면 return null;  
			return null;
		}
		List<EmpVO> list = empMapper.selectEmpWhereJobAndSal(job, sal);
		int comm = 500; //커미션
		int rows = 0;
		
		for(int i=0; i<list.size(); i++) {
			// 만약 기존에 있던 포인트에 합산을 원하는 로직을 구현한다면
//			int empComm = list.get(i).getComm();
//			int sum = empComm + comm;
//			list.get(i).setComm(sum);
			
			list.get(i).setComm(comm);
			EmpVO vo = list.get(i);
			vo.setComm(comm);
			rows += empMapper.updateEmp(vo);
		}
		if(rows>0) {
			return empMapper.selectEmpWhereJobAndSal(job, sal);
		}
		
		return null;
	}
	
	public List<EmpVO> selectEmpHowSal(int sal){
		return empMapper.selectEmpHowSal(sal);
	}

	
	//0509 문제1
	public List<EmpVO> selectEmpHiredate(String hiredate){
		List<EmpVO> list = empMapper.selectEmpHiredate(hiredate);
		int size = list.size();
		if(size <= 3) {
			String year = "1981";
			list = empMapper.selectEmpHiredate(year);
		}
		
		return list;
	} 
	
	//rollbackFor: 이전 commit으로 돌아감
	//Exception : 모든에러를 잡아준다.
	//insert
	//0510 문제1(2) 
	//emp에 없는 부서번호를 찾아서 해당 부서 번호로 insert하기
	@Transactional(rollbackFor = {Exception.class})
	public int setEmpInfo(EmpVO vo) {
		//1. 없는 부서번호(40)를 찾아주는 작업
		EmpVO empVO = empMapper.selectDeptNo();// deptno가 40인 애들을 쿼리로 필터링
		int deptNo = empVO.getDeptno(); //40인 데이터를 변수에 대입 (대입 안해도 되는데 디버깅이 힘듦)
		vo.setDeptno(deptNo); //40인 애들이 set됨 Q.deptNo 변수에 대입 안하고 메소드 자체를 파라미터에 넣어도 되는건가?
		// --- 부서 번호 40을 찾았고
		//2. insert 해야함
		int rows = empMapper.insertEmp(vo); // 몇 행 insert 되었는지 리턴 
		return rows;
	}
	
	//delete
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empno) {
		int rows = empMapper.deleteEmp(empno);
		return rows; // 몇 행 delete 되었는지 리턴
	}
	
	
	//update
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCount(EmpVO empVO) {
		int rows = empMapper.updateEmp(empVO); // 몇 행 update 되었는지 리턴
		return rows; 
		//return empMapper.updateEmp(vo); //이것도 가능
	}
	
	public EmpVO getEmpDeptNo() {
		return empMapper.selectDeptNo();
	}

	//0510 문제2
	
	//0511 if문
	public List<EmpVO> getEmpIsMgrList(String isMgr){
		return empMapper.selectEmpMgr(isMgr);
	}
	
	public int getUpdateEmpno(EmpVO vo) {
		int rows = empMapper.updateEmpno(vo);
		return rows;
	}
	
	// -------------------------------------
	
	//0511 문제1
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpJobAndSal(EmpVO vo) {
		int rows = empMapper.updateJobAndSal(vo);
		return rows;
	}
	
	
	//0511 문제2
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCommSal(int empno) {
		//comm이 0이거나 null이면 
		 EmpVO vo = empMapper.selectEmpCommSal(empno);
		 //select를 받아옴
		 int comm = vo.getComm();
		 //받아온 select의 comm을 int comm에 넣어줌
		 
		 if(comm == 0) {
			 int bonus = 500;
			 int sal = vo.getSal();
			 vo.setSal(sal + bonus); // 보너스 넣어줌
			//update 로직 추가
			 return empMapper.updateEmpSal(vo);
		 }
		return 0;
	}
	
	
	public List<Map<String, Object>> getEmpMapList(){
		return empMapper.selectEmpMapList();
	}
}
