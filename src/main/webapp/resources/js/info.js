let currentRecord=null;
function sendMessage(message){
	alert(message);
}
function infoPage(category){
	document.getElementById(category).click();
}
function regAcademy(){
	let data="userCode="+document.getElementsByName("userCode")[0].value
			+"&userId="+document.getElementsByName("userId")[0].value
			+"&acCode="+currentRecord.childNodes[0].innerHTML;
	getAjaxData("RegAcademy",data,"sendMessage","post");
}
function regAcForm(){
	const mainpage=document.getElementById("mainpage");
	mainpage.innerHTML="";
	let acbox=createDiv("acbox","acbox");
	acbox.innerHTML="<input type='text' class='box' name='selectedAcName' placeholder='학원검색' onClick='searchAcForm()' readOnly/>"
					+"<input type=button  class='regButton' value='등록' onClick='regAcademy()'>";
	mainpage.appendChild(acbox);
}
function searchAcForm(){
		const mainpage=document.getElementById("mainpage");
	mainpage.innerHTML+="<div class='container' id='container'>"
					+"<div class='mdialog'>"
						+"<div class='mcontent'>"
							+"<div class='mheader' style='font-size:200%'>"
								+"<h4 id='mheader' class='mtitle' >학원 검색</h4></div>"
							+"<input type='text' name='acName' placeholder='학원이름 입력' style=' height:35px; border-radius: 10px;'/>"
							+"<input type='button' value='검색' onClick='searchAc()' class='searchBtn'/>"
							+"<div class='mbody' id='mbody' value=''><div class='acCode'>등록번호</div><div class='acName'>이름</div><div class='acAddress'>주소</div></div>"
						
							+"<div class='mfooter'>"
								+"<input type='button' class='mbtn' value='선택'"
									+"onclick='selectList()'/>"				
							+"<input type='button' class='mbtn' value='닫기'"
									+"onclick='closeModal()' style='border-radius: 10px;background-color: #EAEAEA;width:50%; height:100%; border: 1px solid #EAEAEA;'/></div></div></div></div>";
}
function searchAc(){
	const acName=document.getElementsByName("acName")[0].value;
	const data="acName="+acName;
	getAjaxData("SearchAc",data,"displayAcList","post");
}
function displayAcList(pacList){
	const acList=JSON.parse(pacList);
	const mbody=document.getElementById("mbody");
	for(index=0;index<acList.length;index++){
		let record=createDiv("record","record");
		record.setAttribute("onClick","selectBotton(this)");
		for(colindex=0;colindex<3;colindex++){
			let item=createDiv((colindex==0)?"acCode":(colindex==1)?"acName":"acAddress","");
			item.innerHTML=(colindex==0)?acList[index].acCode:(colindex==1)?acList[index].acName:acList[index].acAddress;
			record.appendChild(item);
		}
		mbody.appendChild(record);	
	}
}
function selectBotton(obj){
	if(currentRecord!=null){
		currentRecord.style.color="black";
		currentRecord=null;
	}
	currentRecord=obj;
	obj.style.color="red";
}
function selectList(){
	if(currentRecord!=null){
		document.getElementsByName("selectedAcName")[0].value=currentRecord.childNodes[1].innerHTML;
		const mainpage=document.getElementById("mainpage");
		let container = document.getElementById("container");
		mainpage.removeChild(container);
	}else{
		alert("학원을 선택해주세요");
	}
	
}
function parentRegForm(){
	const mainpage=document.getElementById("mainpage");
	mainpage.innerHTML="";
	let prbox=createDiv("prbox","prbox");
	prbox.innerHTML="<input type='text' class='box' name='pEmail' placeholder='부모님 email 입력'/>"
					+"<input type=button  class='regButton' value='등록' onClick='checkParentEmail()'>";
	mainpage.appendChild(prbox);
}

function checkParentEmail(){
	const data="pEmail="+document.getElementsByName("pEmail")[0].value;
	getAjaxData("CheckParentEmail",data,"confirmPr","post");
}
function confirmPr(pPrInfo){
	const prInfo=JSON.parse(pPrInfo);
	const pEmail=document.getElementsByName("pEmail")[0].value;
	let check=confirm(prInfo.prName+"("+pEmail+")님을 부모님으로 등록하시겠습니까?");
	if(check==true){
		const data="userId="+document.getElementsByName("userId")[0].value
					+"pEmail="+pEmail
					+"prCode="+pPrInfo.prCode
					+"studentName"+document.getElementsByName("userName")[0].value
		getAjaxData("ParentRegEmail",data,"sendMessage","post");
	}
}
function closeModal(){
	const mainpage=document.getElementById("mainpage");
	let container = document.getElementById("container");
	mainpage.removeChild(container);
}
function createDiv(className,id,name){
	let div= document.createElement("div");
	div.setAttribute("class",className);
	div.setAttribute("id",id);
	div.setAttribute("name",name);
	return div;
}
