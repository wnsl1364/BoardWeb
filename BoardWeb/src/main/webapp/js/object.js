/**
 * object.js
 */

// 자바스크립트는 실행 중에 변수 타입이 정해지고 바뀔 수 있는 동적 타이핑 언어
// 자바는 처음부터 타입을 명확히 정해줘야 하는 정적 타이핑 언어

console.log("start");


// DOM 제어 (웹 문서의 요소를 자바스크립트로 직접 만들거나 수정하는 것)
let li = document.createElement('li');  // 새로운 <li> 요소(리스트 항목)를 하나 생성함
li.innerText = 'cherry';  // 생성한 <li> 요소 안에 글자를 넣음
document.querySelector('ul#list').appendChild(li); // 자식요소 추가
document.querySelector('ul#list').style.display = 'none';




//자바스크립트 기본 복습
let name = "Han"; //값이 할당되는 시점에 type이 정해짐(자바와의 차이점)
console.log(typeof name);

const obj = {
	name: "한주연",
	age: 28,
	friends: ['주만성', '한동원', '한찬우'],
	pets: [{ name: '고깜디', age: 4, mbti: 'ENFP' }, { name: '고순', age: 4, mbti: 'ISTP' }]
};

obj.height = 165.8;
console.log(typeof obj);
console.log(obj.name, obj["age"], obj.age);
console.log('친구', obj.friends[0]);
console.log('동물', obj.pets[0].name, obj.pets[0].mbti);

//친구 추가
obj.friends[3] = '이유진';

//친구목록 출력
for (let i = 0; i < obj.friends.length; i++) {
	console.log('친구 이름: ', obj.friends[i]);
}

// 동물 추가
obj.pets.push({ name: '몽실이', age: 10, mbti: 'ENFP' });

////<table><thead><tr><th></th></tr></thead></table>
let tblHtml = '<table class="table">';
tblHtml += '<thead><tr><th>이름</th><th>나이</th><th>MBTI</th></tr></thead>';
tblHtml += '<tbody>';

//동물 목록 추가
for (let pet of obj.pets) {
	console.log(`나의 이름은 ${pet.name}, 나이는 ${pet.age}살이고, MBTI는 ${pet.mbti}이야`);
	//document에 출력
	document.write(`나의 이름은 ${pet.name}, 나이는 ${pet.age}살이고, MBTI는 ${pet.mbti}이야 <br>`);	
	tblHtml += '<tr><td>'+pet.name+'</td><td>'+pet.age+'</td><td>'+pet.mbti+'</td></tr>';
}
tblHtml += '</tbody></table>';

document.querySelector('nav+div.container-fluid:nth-child(2)').innerHTML += tblHtml;