<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TAMain</title>
 <script src="resources/js/common.js"></script>
<script src=""></script>
<script>
	function test() {
		let form = document.getElementById("damnnn");
		let damn = document.getElementById("damn");
		form.appendChild(damn);
		form.submit();
	}
	
	function ajax() {
		
	}
</script>
<style>
#basic {
	position: fixed;
	width: 99%;
	height: 100%;
	
}

#body {
	width: 100%;
	height: 99%;
	
	background-color: #FFFFFF;
}

#logo {
	width: 30%;
	height: 13%;
	
	position: absolute;
	top: 6%;
	left: 8%;
	background-image:url('학생학부모로고.png');  background-size:100%  100%;  background-repeat : no-repeat; background-position:right center;
}

#arm {
	width: 85%;
	height: 53%;
	
	position: absolute;
	top: 250px;
	left: 8%;
}

#loginMom {
	width: 30%;
	height: 100px;
	position: absolute;
	top: 75px;
	left: 63.2%;
	
	
}

#loginMom div {
	display: inline-block;
}

#sLoginB {
	width: 40%;
	height:85%;
	margin-left: 19%;
	background-color: #FFBB00;
	cursor: pointer;
	border-radius: 15px ;
	box-shadow: 5px 5px 5px #969696;
	font-size: 20px;
	border: 0;
	outline: 0;
}

#sLoginB:active {
	background-color: #EA7B03;
	color: #FFFFFF;
	width: 40%;
	height: 85%;
	box-shadow: none;
}

#pLoginB {
	width: 40%;
	height:85%;
	margin-left: -1%;
	background-color: #99E000;
	cursor: pointer;
	border-radius: 15px ;
	box-shadow: 5px 5px 5px #969696;
	font-size: 20px;
	color: #000000;
	border: 0;
	outline: 0;
}

#pLoginB:active {
	background-color: #63AA00;
	color: #FFFFFF;
	width: 40%;
	height: 85%;
	box-shadow: none;
}


.box {
	text-align: center;
	line-height: 100px;
	font-size: 100px;
	color: #fff;
	font-weight: bold;
	
}

.slider {
	width: 25%;
	height: 13%;
	margin-top: 1%;
	

}
#banner{ position:absolute; left:38%; top:40%;
	width:100%; height:100%;}
#slider2{margin-top:16%;}
#slider1{position:fixed; top:83.5%; width:24.8%}

#arm	{float:left; background-image:url(resources/images/'.png');  background-size:100%  100%;  background-repeat : no-repeat; background-position:right center; border-radius: 15px ; }

#subphoto { width:40%; height:40%;}
</style>

</head>
<body onLoad="">
	<form name="" action="/" method="get">
		<div id="basic">
			<div id="body">
				<div id="logo"></div>
			
				<div id="arm">
				<div id="subphoto"></div>
			    </div>
				<div id="loginMom">
					<input type="button" id="sLoginB" value="학생로그인" onClick="" /> 
					<input type="button" id="pLoginB" value="학부모로그인" onClick="" />
				</div>

			<div id="banner">
				<section id="slider1" class="slider">
					<div class="box" style="background-color: #000;">
						<img src="resources/images/과학배너.jpg" width="100%" height="100%"  />
					</div>
					<div class="box" style="background-color: #000;">
						<img src="resources/images/과학배너2.jpg" width="100%" height="100%"  />
					</div>
					<div class="box" style="background-color: #000;">
						<img src="resources/images/학생배너.jpg" width="100%" height="100%" />
					</div>
					<div class="box" style="background-color: #000;">
						<img src="resources/images/새학기배너.jpg" width="100%" height="100%"  />
					</div>
					<div class="box" style="background-color: #000;">
						<img src="resources/images/새학기배너1.jpg" width="100%" height="100%"  />
					</div>
				</section>

				<section id="slider2" class="slider">
					<div class="box" style="background-color: #ff0000;">
						<img src="resources/images/수상배너1.jpg" width="100%" height="100%" />
					</div>
					<div class="box" style="background-color: #ff0000;">
						<img src="resources/images/수상배너2.jpg" width="100%" height="100%" />
					</div>
					<div class="box" style="background-color: #ff0000;">
						<img src="resources/images/수상배너3.jpg" width="100%" height="100%" />
					</div>
					<div class="box" style="background-color: #ff0000;">
						<img src="resources/images/수상배너4.jpg" width="100%" height="100%" />
					</div>
					<div class="box" style="background-color: #ff0000;">
						<img src="resources/images/수상배너5.jpg" width="100%" height="100%" />
					</div>
				</section>
			</div>
			</div>
		</div>
	</form>
</body>
<script>
function Slider(target, type) {
	  // 상태
	  let index = 1;
	  let isMoved = true;
	  const speed = 1000; // ms

	  // 방향
	  const transform = "transform " + speed / 1000 + "s";
	  let translate = (i) => "translateX(-" + 100 * i + "%)";
	  if (type === "V") {
	    translate = (i) => "translateY(-" + 100 * i + "%)";
	  }

	  // 슬라이더
	  const slider = document.querySelector(target);
	  const sliderRects = slider.getClientRects()[0];
	  slider.style["overflow"] = "hidden";

	  // 슬라이더 화면 컨테이너
	  const container = document.createElement("div");
	  container.style["display"] = "flex";
	  container.style["flex-direction"] = type === "V" ? "column" : "row";
	  container.style["width"] = sliderRects.width + "px";
	  container.style["height"] = sliderRects.height + "px";
	  container.style["transform"] = translate(index);

	  // 슬라이더 화면 목록
	  let boxes = [].slice.call(slider.children);
	  boxes = [].concat(boxes[boxes.length - 1], boxes, boxes[0]);

	  // 슬라이더 화면 스타일
	  const size = boxes.length;
	  for (let i = 0; i < size; i++) {
	    const box = boxes[i];
	    box.style["flex"] = "none";
	    box.style["flex-wrap"] = "wrap";
	    box.style["height"] = "100%";
	    box.style["width"] = "100%";
	    container.appendChild(box.cloneNode(true));
	  }

	  // 처음/마지막 화면 눈속임 이벤트
	  container.addEventListener("transitionstart", function () {
	    isMoved = false;
	    setTimeout(() => {
	      isMoved = true;
	    }, speed);
	  });
	  container.addEventListener("transitionend", function () {
	    // 처음으로 순간이동
	    if (index === size - 1) {
	      index = 1;
	      container.style["transition"] = "none";
	      container.style["transform"] = translate(index);
	    }
	    // 끝으로 순간이동
	    if (index === 0) {
	      index = size - 2;
	      container.style["transition"] = "none";
	      container.style["transform"] = translate(index);
	    }
	  });

	  // 슬라이더 붙이기
	  slider.innerHTML = "";
	  slider.appendChild(container);

	  return {
	    move: function (i) {
	      if (isMoved === true) {
	        index = i;
	        container.style["transition"] = transform;
	        container.style["transform"] = translate(index);
	      }
	    },
	    next: function () {
	      if (isMoved === true) {
	        index = (index + 1) % size;
	        container.style["transition"] = transform;
	        container.style["transform"] = translate(index);
	      }
	    },
	    prev: function () {
	      if (isMoved === true) {
	        index = index === 0 ? index + size : index;
	        index = (index - 1) % size;
	        container.style["transition"] = transform;
	        container.style["transform"] = translate(index);
	      }
	    }
	  };
	}

	const s1 = new Slider("#slider1", "H");
	const s2 = new Slider("#slider2", "V");

	setInterval(() => {
	  s1.next();
	  s2.next();
	}, 1000)
</script>
</html>