package com.example.first_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;

@RestController // 1번순서
public class ActorController {
	@Autowired // 2번순서
	private EmpService service; //2번순서
	
//	@GetMapping("/actor/list")
//	public List<UserVO> callUserList(){
//		return service.getUserList();
//	}
	
//	@GetMapping("/actor/age")
//	public int callUserAgeMax(HttpServletRequest request){
//		String ip = request.getHeader("x-forwarded-For"); // 클라이언트의 ip를 수집할 수 있다.
//		if(ip == null) {
//			ip = request.getRemoteAddr();
//		}
//		System.out.println("IP ====> " + ip);
//		return service();
//	}
//	
//	@GetMapping("/actor")
//	public UserVO callUserName(){
//		return service.getUser();
//	}
//	
//	@GetMapping("/actor/count")
//	public int callUserCount(){
//		return service.getUserCount();
//	}
}
