package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	// id, pw 받아서 하나조회
	// 반환되는 타입 MemberVO
	// 메소드 이름 selectMember
	// @param: MyBatis에서 SQL Mapper에 파라미터를 전달할 때 사용하는 어노테이션, 이름으로 파라미터에 접근할 수 있게 도와줌
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
}
