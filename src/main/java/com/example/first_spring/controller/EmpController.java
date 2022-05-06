package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.UserVO;

@RestController
public class EmpController {
	
	private static final UserVO UserVO = null;
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		return empService.getAllempList();
	}
	
	
	@GetMapping("/empNameL")
	public List<EmpVO> callEmpName() {
		return empService.getEmpName();
	}
	
	@GetMapping("/empComm")
	public List<EmpVO> callEmpComm(){
		return empService.getEmpComm();
	}
	
	@GetMapping("/empHireDate")
	public List<EmpVO> callEmpHireDate(){
		return empService.getEmpHireDate();
	}
	
	// 파라미터 넣어보기 
	// @PathVariable : {}로 들어온 값을 파라미터에 대입
	@GetMapping("/emp/no/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empno) {
		return empService.getEmp(empno);
	}
	
	
	@GetMapping("/emp/job/{job}/sal/{sal}") // url 입력할 때 {}안에 해당 파라미터 값을 넣어주면 된다.  ex) MANAGER
	public List<EmpVO> callEmpList(@PathVariable("job")String job,@PathVariable("sal")int sal){
	return empService.selectEmpWhereJobAndSal(job, sal);
	}
	
	@GetMapping("emp/sal/{sal}")
	public List<EmpVO> callEmpSal(@PathVariable("sal")int sal){
		return empService.selectEmpHowSal(sal);
	}
	
	@GetMapping("/emp/mgr")
	public List<EmpVO> callEmpSal(){
		return empService.selectEmpMgr();
	}
	
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callEmpHiredate(@PathVariable("year") String hireYear){
		return empService.selectEmpHiredate(hireYear);
	}
	
	
	
	
	
}

