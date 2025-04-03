package com.yedam.service;

import com.yedam.vo.MemberVO;

// MemberService(인터페이스) - 규칙을 정해넣고 하위 기능을 구현하기 위해 만듦
// MemberServiceDAO - jdbc 기능구현
// MemberServiceImpl - mybatis 기능구현

public class MemberServiceDAO implements MemberService{

	@Override
	public MemberVO login(String id, String pw) {
		return null;
	}

	@Override
	public boolean addMember(MemberVO member) {
		return false;
	}
}
