 function isEmpty(obj){
	 let check= true;
	 if(obj.value==""){
		 check=false;
	 }
	 return check;
}
function makeForm(fname, faction, fmethod){
	const form = document.createElement("form");
	if(fname != ""){form.setAttribute("name", fname);}
	form.setAttribute("action", faction);
	form.setAttribute("method", fmethod);
	return form;
}

function makeInputElement(type, name, value, placeholder){
	const input = document.createElement("input");
	input.setAttribute("type", type);
	input.setAttribute("name", name);
	if(value != ""){input.setAttribute("value", value);}
	if(placeholder != ""){input.setAttribute("placeholder", placeholder);}
	
	return input;
}
function getAjaxData(action,data,fn,method){
	const ajax = new XMLHttpRequest();
		ajax.onreadystatechange = function() {
			if ( ajax.readyState== 4 && ajax.status == 200) {		
				window[fn](JSON.parse(ajax.responseText));
						
			}
		};
		if(method=="get"){
			action=(data!="")?(action+"?"+data):action;
			ajax.open("get", action, true);	
			ajax.send();
		}else{
			ajax.open("post", action, true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");	
			ajax.send(data);
		}
		
}
function sendMessage(message){
	/* 저는 이렇게 제어했습니다.
	if(message!=""){
	alert(message);
	} */
	/*원본 */
	alert(message);
	
}

function accessOut(){
		const form = makeForm("", "/Logout", "post");
		const uId = document.getElementsByName("userId")[0].value;
		const uc = document.getElementsByName("userCode")[0].value;
		
		const userId = makeInputElement("hidden", "userId", uId, "");
		const userCode = makeInputElement("hidden", "userCode", uc, "");
		
		form.appendChild(userId);
		form.appendChild(userCode);
		
		document.body.appendChild(form);
	    form.submit();

	   
}
function accessAdminOut(){
		const form = makeForm("", "/Logout", "post");
		const uId = document.getElementsByName("userId")[0].value;
		const uc = document.getElementsByName("userCode")[0].value;
		const ac = document.getElementsByName("acCode")[0].value;
		const userId = makeInputElement("hidden", "userId", uId, "");
		const userCode = makeInputElement("hidden", "userCode", uc, "");
		const acCode = makeInputElement("hidden", "acCode", ac, "");	
		form.appendChild(userId);
		form.appendChild(userCode);
		form.appendChild(acCode);
		document.body.appendChild(form);
	    form.submit();

	   
}
function getPage(action){
	const form = makeForm("", action, "post");
	const userId=document.getElementsByName("userId")[0].value;
	const userName=document.getElementsByName("userName")[0].value;
	const userCode=document.getElementsByName("userCode")[0].value;
	const acCode=document.getElementsByName("acCode")[0].value;
	const studentId=document.getElementsByName("studentId")[0].value;
	const tier=document.getElementsByName("tier")[0].value;
	
	const clientData = [makeInputElement("hidden", "userId", userId, ""),
					    makeInputElement("hidden", "userName", userName, ""),
					    makeInputElement("hidden", "userCode", userCode, ""),
					    makeInputElement("hidden", "acCode", acCode, ""),
					    makeInputElement("hidden", "studentId", studentId, ""),
					    makeInputElement("hidden", "tier", tier, "")];
	
	for(idx=0; idx<clientData.length;idx++){
		form.appendChild(clientData[idx]);
	}		

	document.body.appendChild(form);
	form.submit();
}
