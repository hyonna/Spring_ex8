<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function() {
	
	var count=0;
	var f=0;
	
	$('#add').click(function() {
		f++;
		$('.ff').append("<input type='file' name='f1' id='f"+f+"' style='width:200px; margin: 10px 0;'>");
		count++;
		if(count>4) {
			alert('파일은 5개까지만 생성 가능');
			$('#add').remove();
		}
	});
	
	
	/* $('#write_btn').on('click', function() {
		var form = new FormData($('#frm'));
		$.ajax({
			url: "./${board}Write",
			type: "POST",
			data: form,
			contentType: false,
			processData: false,
			success:  function() {
				alert('ok');
			},
			error: function() {
				alert('fail');
			}
		});
		
	});  */
	
});

</script>
</head>
<body>
	<div class="container">
	<h1>${board}Write</h1>
	<br>
	<form action="./${board}Write" method="post" enctype="multipart/form-data" id="frm">
		<div class="form-group">
		  <label for="title">Title:</label>
 		 <input class="form-control" type="text" id="title" name="title">
		</div>
		<div class="form-group">
		  <label for="writer">Writer:</label>
 		 <input class="form-control" type="text" id="writer" name="writer">
		</div>
		<div class="form-group">
		  <label for="contents">Contents:</label>
 		 <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
		</div>
		<div id="file_box" style="margin: 20px 0;">
			<div class="ff" style="display: inline-block;"></div><span class="btn btn-primary" id="add">+ 추가</span>
		</div>
		<div style="text-align: center;">
			<button class="btn btn-primary" id="write_btn" style="padding: 2% 5%; margin-top: 50px;">Write</button>
		</div>
	</form>
</div>
</body>
</html>