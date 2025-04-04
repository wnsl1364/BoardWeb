/**
 * json.js
 */

const jsonStr=`[{"id":1,"first_name":"Donnie","last_name":"Heinle","email":"dheinle0@blogs.com","gender":"Female","salary":4575},
{"id":2,"first_name":"Timmi","last_name":"Acarson","email":"tacarson1@lulu.com","gender":"Female","salary":6553},
{"id":3,"first_name":"Floyd","last_name":"Corbishley","email":"fcorbishley2@cisco.com","gender":"Male","salary":1758},
{"id":4,"first_name":"Donny","last_name":"Popple","email":"dpopple3@php.net","gender":"Male","salary":7889},
{"id":5,"first_name":"Albrecht","last_name":"Fleet","email":"afleet4@usatoday.com","gender":"Male","salary":8313},
{"id":6,"first_name":"Tatiana","last_name":"Rushforth","email":"trushforth5@artisteer.com","gender":"Female","salary":8286},
{"id":7,"first_name":"Gardener","last_name":"Iacovucci","email":"giacovucci6@elegantthemes.com","gender":"Male","salary":5764},
{"id":8,"first_name":"Arny","last_name":"Aronow","email":"aaronow7@oakley.com","gender":"Male","salary":9971},
{"id":9,"first_name":"Chancey","last_name":"Shillinglaw","email":"cshillinglaw8@weather.com","gender":"Male","salary":9553},
{"id":10,"first_name":"Catlaina","last_name":"Losselyong","email":"closselyong9@gov.uk","gender":"Female","salary":1695},
{"id":11,"first_name":"Cyrill","last_name":"Patten","email":"cpattena@hao123.com","gender":"Male","salary":7895},
{"id":12,"first_name":"Larina","last_name":"Larrington","email":"llarringtonb@unc.edu","gender":"Female","salary":3227},
{"id":13,"first_name":"Lizabeth","last_name":"Reisk","email":"lreiskc@who.int","gender":"Female","salary":9462},
{"id":14,"first_name":"Erena","last_name":"Barge","email":"ebarged@t.co","gender":"Female","salary":3636},
{"id":15,"first_name":"Gay","last_name":"Deackes","email":"gdeackese@rambler.ru","gender":"Female","salary":1172}]`;

let obj = JSON.parse(jsonStr); // json 문자열 -> object 변경
let str = JSON.stringify(obj); // object -> json 문자열 변경
console.log(obj[2].last_name);

//한건 데이터를 매개값으로 tr을 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}){
	const fields = ['id', 'first_name', 'last_name', 'email'];
	let tr = document.createElement('tr');
	for(let i=0; i<fields.length; i++){
		let td = document.createElement('td');
		td.innerHTML = emp[fields[i]];
		tr.appendChild(td);
	}
	return tr;
};

//화면출력
obj.forEach(function(item, idx, ary){
	let tr = makeRow(item);
	document.querySelector('#target').appendChild(tr);
});
