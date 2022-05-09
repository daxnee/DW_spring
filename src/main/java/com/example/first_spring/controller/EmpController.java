package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.UserVO;

@RestController
public class EmpController {
	
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
	
	@GetMapping("emp/sal/{sal}")
	public List<EmpVO> callEmpSal(@PathVariable("sal")int sal){
		return empService.selectEmpHowSal(sal);
	}
	
//	@GetMapping("/emp/job/{job}/sal/{sal}") // url 입력할 때 {}안에 해당 파라미터 값을 넣어주면 된다.  ex) MANAGER
//	public List<EmpVO> callEmpList(@PathVariable("job")String job,@PathVariable("sal")int sal){
//	return empService.selectEmpWhereJobAndSal(job, sal);
//	}
	
	@GetMapping("/emp/job/{job}/sal/{sal}") // url 입력할 때 {}안에 해당 파라미터 값을 넣어주면 된다.  ex) MANAGER
	public List<EmpVO> callEmpList(@PathVariable("job")String job,@PathVariable("sal")int sal){
	return empService.selectEmpWhereJobAndSal(job, sal);
	}
	
	
	@GetMapping("/emp/mgr")
	public List<EmpVO> callEmpSal(){
		return empService.selectEmpMgr();
	}
	
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callEmpHiredate(@PathVariable("year") String hireYear){
		return empService.selectEmpHiredate(hireYear);
	}
	
	//emp테이블에 insert해보기 
	//PostMapping : 중요한 정보를 보내거나, 데이터를 보낼 때 post 사용 ex) 회원가입
	//RequestBody가 파라미터로 넘어오는 VO 대신 new해줌 
	@PostMapping("/emp") // 위에 같은 url 주소가 있지만 http 메소드 종류가 다르기 때문에 오류가 안 난다.
	//삽입
	public int callEmpSet(@RequestBody EmpVO empVO) { // 데이터를 EmpVO에 맞춰서 보내겠다
		 System.out.println("사원이름은 : "+ empVO.getEname());
		 System.out.println("사원번호는 : "+ empVO.getEmpno());
		 System.out.println("사원직책은 : " + empVO.getJob());
		 System.out.println("사원급여는 : " +  empVO.getSal());
		 System.out.println("사원입사일은 : " + empVO.getHiredate());
		 System.out.println("사원부서번호는 : " + empVO.getDeptno());
		 //  postman으로 전송시 필드변수 이름에 오타가 나면 데이터가 null뜬다.
		 return empService.setEmpInfo(empVO); 
	}
	
	// : 자원 삭제할 때 사용
	@DeleteMapping("/emp/empno/{empno}") 
	//저장
	public int callEmpRemove(@PathVariable("empno") int empno) {
		return empService.getEmpRemoveCount(empno);
	}
	
	@PatchMapping("/emp")
	//수정
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return empService.getEmpUpdateCount(empVO);
	}
	
	
	
	
	
	
}
