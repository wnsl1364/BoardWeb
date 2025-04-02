package com.yedam.service;

import com.yedam.vo.MemberVO;

// 업무 프로세스
// MemberService는 규칙을 정해넣고 하위 기능을 구현하기 위한 목적으로 만듦
public interface MemberService {
	//로그인
	MemberVO login(String id, String pw);
}
