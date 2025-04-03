package com.yedam.common;

import lombok.Getter;
import lombok.Setter;

// 게시글 검색의 파라미터
@Getter
@Setter
public class SearchDTO {
	private int page; // 페이지번호
	private String searchCondition;
	private String keyword; // 검색어
}
