package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.DeptMapper;
import com.example.first_spring.vo.DeptVO;


@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;

	public List<DeptVO> getDept() {
		return deptMapper.getDept();
	}
}
