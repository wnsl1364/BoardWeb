/**
 * 외부 JSON 파일을 읽어와서 HTML 테이블에 데이터를 출력하는 코드
 */

// XMLHttpRequest 객체를 생성해서 서버에 요청할 준비를 함
const xhtp = new XMLHttpRequest();

// 'data/MOCK_DATA.json' 파일을 GET 방식으로 요청함 (파일 경로는 상대경로임)
xhtp.open('get', 'data/MOCK_DATA.json');

// 실제로 요청을 서버에 보냄
xhtp.send();

let dataAry;

// 요청한 파일을 다 읽었을 때 실행되는 함수
xhtp.onload = function() {
	// 읽어온 JSON 문자열을 자바스크립트 객체로 바꿔줌
	let obj = JSON.parse(xhtp.responseText);
	dataAry = obj;
	
	// 콘솔에서 데이터 구조를 확인할 수 있도록 출력해봄 (개발자 도구에서 확인 가능)
	console.log(obj);

	// 받아온 데이터(obj)는 배열이므로, 배열의 각 요소(사람 정보)를 하나씩 처리함
	obj.forEach(function(item, idx, ary) {
		// 한 사람의 정보를 가지고 <tr> 요소(한 줄)를 만들어냄
		let tr = makeRow(item);

		// 만들어진 <tr>을 HTML 문서 안의 id가 target인 요소에 추가함
		document.querySelector('#target').appendChild(tr);
	});
}

// 한 사람의 정보를 받아서 <tr> 한 줄을 만들어주는 함수
function makeRow(emp = { id, first_name, last_name, email, gender, salary }) {
	// 테이블에 출력할 필드 목록만 골라서 배열로 저장함
	const fields = ['id', 'first_name', 'last_name', 'gender'];

	// <tr> 요소(한 줄)를 생성함
	let tr = document.createElement('tr');

	// input 생성
	let tdc = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox');

	//부모 자식
	tdc.appendChild(chk);
	tr.appendChild(tdc);
	
	// 필요한 필드만큼 반복하면서 <td> 요소(셀)를 만들어 <tr>에 추가함
	for (let i = 0; i < fields.length; i++) {
		let td = document.createElement('td');             // <td> 셀 하나 만들고
		td.innerHTML = emp[fields[i]];                     // emp 객체에서 해당 필드값을 꺼내서 넣음
		tr.appendChild(td);                                // <td>를 <tr>에 붙임
	}	
	
	// button 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click', deleteRow);

	//부모 자식
	td.appendChild(btn);
	tr.appendChild(td);

	// 완성된 <tr>을 함수 밖으로 반환해서 화면에 추가할 수 있도록 함
	return tr;
};

// btn의 이벤트 핸들러
function deleteRow(e){
	e.target.parentElement.parentElement.remove();
}

//체크박스
let hchk = document.querySelector('thead input[type="checkbox"]');
hchk.addEventListener('change', checkAll);

function checkAll(){
	let bchk = document.querySelectorAll('tbody input[type="checkbox"]');
	
	const isChecked = hchk.checked;
			
	if(isChecked){
		for(let i=0; i<bchk.length; i++){
			bchk[i].checked = true;
		}
	}else{
		for(let i=0; i<bchk.length; i++){
			bchk[i].checked = false;
		}
	}
}

//셀렉트
let sbox = document.querySelector('#searchGender');
sbox.addEventListener('change', changeRs);
// dataAry의 배열을 활용해서 출력
// dataAry의 gender 속성을 비교해서 출력하기(출력하기전에 목록을 초기화)
function changeRs(e){
	console.log(e.target.value);
	let genderValue = e.target.value;
	document.querySelector('#target').innerHTML = '';
	dataAry.forEach(function(item){
		console.log(item);
		// 같은값만 출력
		if(genderValue == 'all' || item.gender.toLowerCase() == genderValue){
			let tr = makeRow(item);
			document.querySelector('#target').appendChild(tr);
		}
	})
};