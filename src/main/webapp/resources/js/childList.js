/**
 * 
 */

/*리스트를 ajax로 가져옴*/
	function getChildList(uId){
		const data = "userId="+ encodeURIComponent(uId)
		getAjaxData("/GetChildList", data, "childListBox","post" );
		
		
	} 
let cc;
/*가져온 리스트를 셀렉트 박스에 출력*/
	function childListBox(cList){
		cc=cList;
		let sc =  document.getElementById("sCode").value
		if(sc==""){sc=cc[0].userId;}//학사일정 불러오기위한자녀코드
		let cb = document.getElementById("childBox");
		let idx = 0;
		let cbData = '<select name="childSelect" id="childSelect" onchange="childName(this)">';
		    cbData += '<option value="자녀선택">자녀선택';
		    cbData += '</option>';
		for(idx;idx<cList.length;idx++){
			cbData += '<option value="'+cList[idx].sname+'">'+cList[idx].sname;
		    cbData += '</option>';
		}
		cbData += '</select>';
		cb.innerHTML = cbData; 
		getPlanList();
	}
	/*셀렉트박스에서 자녀 선택할경우  
	이름과 같이 가져온 이메일,학생코드를
	  히든속성의 input테그에 삽입*/
	function childName(cName){
		let idx1 =0;
	
		alert(document.getElementById("sCode").value);
		const value = cName.value;
		
		var cn = document.getElementById("childName");
	
		for(idx1;idx1<cc.length;idx1++){
			
			let name1 = cc[idx1].sname;

			if(name1 == value){
			document.getElementById("sEmail").value=cc[idx1].semail;
			document.getElementById("sCode").value=cc[idx1].userId;
			
			}
		}
		
		cn.innerText = value;
		
	}
	

