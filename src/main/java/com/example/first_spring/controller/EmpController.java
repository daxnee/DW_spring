package com.example.first_spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	//0513 모든 emp사원 구하기 
	@CrossOrigin(origins = {"*"}) // 보안 허용 : 내 자원을 가져다 쓸 수 있게 설정
	@GetMapping("/emp")
	public List<EmpVO> callAllEmp() {
		return empService.getAllEmp();
	}
	
	
	// (empno)인 사원 조회
	// 파라미터 넣어보기 
	// @PathVariable : {}로 들어온 값을 파라미터에 대입
	@CrossOrigin(origins = {"*"})
	@GetMapping("/emp/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empno) {
		return empService.getEmpEmpno(empno);
	}
	

	@GetMapping("/emp/hiredate/sal/{sal}") 
	public List<EmpVO> callEmpHowSal(@PathVariable("sal") int sal){
		return empService.selectEmpHowSal(sal);
	}

	
	@GetMapping("/emp/job/{job}/sal/{sal}") // url 입력할 때 {}안에 해당 파라미터 값을 넣어주면 된다. -ex) MANAGER
	public List<EmpVO> callEmpList(@PathVariable("job")String job, @PathVariable("sal")int sal){
	return empService.selectEmpWhereJobAndSal(job, sal);
	}
	
	
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callEmpHiredate(@PathVariable("year") String hireYear){
		return empService.selectEmpHiredate(hireYear);
	}
	
	//emp테이블에 insert해보기 
	//PostMapping : 중요한 정보를 보내거나, 데이터를 보낼 때 post 사용 ex) 회원가입
	//RequestBody가 파라미터로 넘어오는 EmpVO를 대신 new해줌 
	@CrossOrigin(origins = {"*"})
	@PostMapping("/emp") // 위에 같은 url 주소가 있지만 http 메소드 종류가 다르기 때문에 오류가 안 난다.
	//삽입
	public int callEmpSet(@RequestBody EmpVO empVO) { // 데이터를 EmpVO에 맞춰서 보내겠다
		 //  postman으로 전송시 필드변수 이름에 오타가 나면 데이터가 null뜬다.
		 return empService.setEmpInfo(empVO); 
	}
	

	//0513
	@CrossOrigin(origins = {"*"})
	@DeleteMapping("/emp/empno/{empNo}") 
	//삭제
	public int callEmpRemove(@PathVariable("empNo") int empno) {
		return empService.getEmpRemoveCount(empno);
	}
	
	@PatchMapping("/emp")
	//수정
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return empService.getEmpUpdateCount(empVO);
	}
	
	// ------------0510------------
	
//	0510 쿼리스트링으로 getmapping
	// tier?region=kr : region이라는 변수에 kr을 대입하겠다.
	// 검색할때 많이 사용
	// 검색시 : http://localhost:8080/tier?region=kr&name=다은
	@GetMapping("/tier")
	public String callTier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region+", "+name;
	}
	
	
	//board?page=1&pageSize=10&writer=양다은
	//현재페이지 10개, 페이지 row 수 10줄, 작성자 양다은
	@GetMapping("/board")
	public int callBoard(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("writer") String writer) {
		System.out.println("현재 페이지는 : " + page);
		System.out.println("한 페이지에 보여주는 row 수 : "+ pageSize );
		System.out.println("작성자는 : " + writer);
		return 0;
	}//
	
//	@DeleteMapping("/emp/sal/{sal}") 
//	public int callEmpRemoveSal(@PathVariable("sal") int sal) {
//		return empService.getEmpRemoveSal(sal);
//	}
	
	// 0511 if문
	@GetMapping("/emp/mgr/{isMgr}")
		public List<EmpVO> callEmpIsMgrList(@PathVariable("isMgr") String isMgr){
		return empService.getEmpIsMgrList(isMgr);
		}
	

	@PatchMapping("/emp/empno")
	public int callEmpSalJobUpdate(EmpVO vo) {
		return empService.getEmpJobAndSal(vo);
	}

	//0511 문제1
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/emp/{empno}")
	public int callEmpSalUpdate(@PathVariable("empno") int empno) {
		return empService.getEmpUpdateCommSal(empno);
	}
	
	// List에 Map 담기
	@GetMapping("/emp/map/list")
	public List<Map<String, Object>> callEmpMapList(){
		return empService.getEmpMapList();
	}
	
	//0513
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/api/v1/emp/{empno}")
	public int callApi(@PathVariable("empno") int empno, @RequestBody EmpVO empVO) {
		return empService.getApi(empno, empVO);
	} 
	
	
}
	
	
	

