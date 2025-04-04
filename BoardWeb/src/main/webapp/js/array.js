/**
 * array.js
 */

const ary = [];
// 추가: push, unshift
ary.push('한주연'); //제일 마지막위치에 추가 됨
ary.push('주만성'); 
ary.unshift('고깜디'); // 제일 앞쪽에 추가됨

// 제거: pop, shift
//ary.pop(); // 제일 마지막위치 삭제
//ary.shift(); //제일 앞쪽 삭제

// 추가, 수정, 삭제 : splice
//ary.splice(0, 1, '한주동'); // 첫번째 매개값: 위치값(인덱스), 두번째 매개값: 삭제할 요소의 개수, 세번째 매개값: 추가할 요소

// 반복문 for, forEach
ary.forEach (function(item, idx, ary){ //forEach는 매개값을 함수로 가짐
	console.log(`item => ${item}, index => ${idx}, array => ${ary}`);
}); 

// 함수
function addElement(ele = "noEle"){
	ary.push(ele);
};

// 화면 요소 제거
function deleteElement(e){
	//alert('삭제하셈');
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
};

// 추가버튼 클릭이벤트
document.querySelector('#addBtn').addEventListener('click', function(){
	// input의 값
	let val = document.querySelector('#userInput').value;
	addElement(val); // ary배열에 추가
	// 화면에 출력
	let html = '';
	ary.forEach(function(item, idx, ary){
		html += '<li>' + item + ' <button onclick="deleteElement(event)">삭제</button></li>';
	});
	// ul태그의 영역
	document.querySelector('#list').innerHTML = html;
});
