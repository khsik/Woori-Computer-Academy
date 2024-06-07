package com.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.data.MyTestDTO;
import com.ex.data.MyTestUpdateDTO;
import com.ex.repository.TestMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	private final TestMapper testMapper;

	public int mytestInsert(MyTestDTO dto) {
		return testMapper.mytestInsert(dto);
	}

	public int loginCheck(String username, String password) {
		return testMapper.loginCheck(username, password);
	}

	public List<MyTestDTO> userInfo() {
		return testMapper.userInfo();
	}

	public MyTestDTO myInfo(String username) {
		return testMapper.myInfo(username);
	}

	public int mytestDelete(String username) {
		return testMapper.mytestDelete(username);
	}

	public void updateInfo(MyTestUpdateDTO dto) {
		MyTestDTO myTestDTO = testMapper.myInfo(dto.getUsername());
		if(!dto.getNewPassword1().equals("")) {
			myTestDTO.setPassword(dto.getNewPassword1());
		}
		myTestDTO.setBirth(dto.getBirth());
		myTestDTO.setAge(dto.getAge());
		testMapper.myInfoUpdate(myTestDTO);
	}
}
