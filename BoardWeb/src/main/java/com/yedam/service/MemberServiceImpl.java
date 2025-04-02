package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

//업무(service 구현객체)
public class MemberServiceImpl implements MemberService{

	SqlSession sqlSession = DataSource.getInstance().openSession(); //DB랑 연결할 준비 완료!
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class); //SQL 문이 담긴 Mapper를 자바에서 쓸 수 있게 꺼내온 거
	
	
	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

}
