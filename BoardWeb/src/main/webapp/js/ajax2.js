/**
 * 
 */

// XMLHttpRequest 객체를 생성해서 서버에 요청할 준비를 함
const xhtp = new XMLHttpRequest();

// 'data/MOCK_DATA.json' 파일을 GET 방식으로 요청함 (파일 경로는 상대경로임)
xhtp.open('get', 'data/MOCK_DATA.json');

// 실제로 요청을 서버에 보냄
xhtp.send();

xhtp.onload = function(){
	
}