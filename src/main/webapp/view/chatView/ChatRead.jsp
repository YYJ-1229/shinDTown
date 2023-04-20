<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="chat.css" rel="stylesheet" />
<script src="../../jq/jquery-3.6.4.min.js"></script>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="body">
		<div class="chats">
			<div class="chatlist">

				<fieldset class="chat_field">
					<legend>채팅방 목록</legend>
					<ul>
						<li class="chat" value="1">{post title} {user_1_name}
							{user_2_name}</li>
						<li class="chat" value="2">[밥같이 먹을 사람] [전은정]</li>
						<li class="chat" value="3">[스터디 같이 할사람] [유지만]</li>
						<li class="chat" value="4">[집에 같이갈 사람] [이진경]</li>
					</ul>
				</fieldset>

			</div>

			<div class="chatroom" id="chatroom">

				<div class="text">
		
					<div class="me_1">
						<p>안녕하게요!</p>
					</div>
					<div class="other_1">
						<p>안녕하숑숑~</p>
					</div>

					<div class="me_2">
						<p>배고파요~</p>
					</div>

					<div class="other_2">
						<p>머먹고 싶으세요?</p>
					</div>
					<div class="other_3">
						<p>머먹고 싶으세요?</p>
					</div>
					<div class="other_4">
						<p>머먹고 싶으세요?</p>
					</div>
				</div>
				
				<div class="typing">
				<textarea class="type_area">
				</textarea>
				<button class="send">전송</button>
				</div>

			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			$("li").click(function() {
				console.log($(this).val());
				$("#chatroom").css("visibility", "visible");

			});
		});
	</script>

</body>
</html>