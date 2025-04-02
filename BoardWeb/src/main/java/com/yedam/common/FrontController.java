package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.LoginControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;

public class FrontController extends HttpServlet {

	// Map: 요청 url => 실행할 컨트롤 매핑
	Map<String, Control> map;

	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>(); //HashMap: 순서없이 키를 이용해 값을 빠르게 꺼낼 수 있음
	}

	//init() 메서드: 맵핑 설정
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl()); // 메인화면
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 글목록
		map.put("/addBoard.do", new AddBoardControl());// 글등록
		map.put("/modifyForm.do", new ModifyFormControl());// 글 수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl());// 수정처리
		map.put("/deleteForm.do", new DeleteFormControl());// 삭제 화면
		map.put("/deleteBoard.do", new DeleteBoardControl());// 삭제 처리
		map.put("/loginForm.do", new LoginFormControl());// 로그인화면	
		map.put("/login.do", new LoginControl());// 로그인 처리
		map.put("/logout.do", new LogoutControl());// 로그아웃 처리
	}

	//service() 메서드: 요청처리 핵심
	@Override
	// HttpServlet이 받는 모든 요청을 처리하는 메서드
	// 브라우저에서 .do로 끝나는 요청이 들어오면 이 메서드가 호출됨
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
	    // 1. 전체 요청 URI를 가져옴 (예: /BoardWeb/boardList.do)
	    String uri = req.getRequestURI(); 
	    System.out.println("uri: " + uri); 

	    // 2. 프로젝트 컨텍스트 경로를 가져옴 (예: /BoardWeb)
	    String context = req.getContextPath(); 
	    System.out.println("context: " + context); 

	    // 3. context 길이 이후의 경로만 잘라서 가져옴 (예: /boardList.do)
	    //    이게 map의 key 값으로 사용됨
	    String page = uri.substring(context.length()); 
	    System.out.println("page: " + page); 

	    // 4. 요청한 경로(page)를 기준으로 Control 객체를 찾음
	    //    예: "/boardList.do" => new BoardListControl()
	    Control sub = map.get(page); 

	    // 5. 해당 Control 객체의 exec() 메서드를 실행해서
	    //    실제 비즈니스 로직(DB 처리 등)을 수행하게 함
	    sub.exec(req, resp); 
	}
}
