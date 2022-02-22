<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<%--<s:head />--%>
	<%--included part start--%>

	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<s:url value='/styles/Task4.css'/>" rel="stylesheet" type="text/css" media="all"/>
	<script src="<s:url value='/script/Task4.js'/>"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--	<script>--%>

<%--		function connectToDB() {--%>
<%--			$.ajax({--%>
<%--				type: "GET",--%>
<%--				url: "dbAccess",--%>
<%--				success:function (obj) {--%>

<%--					var opened = window.open("");--%>
<%--					opened.document.write(obj);--%>
<%--					//console.log(obj.typeName);--%>
<%--				}--%>
<%--			});--%>
<%--		}--%>

<%--	</script>--%>
	<%--included part end--%>
</head>
<body>
	<%--<s:form action="helloWorld">--%>
		<%--<s:textfield label="What is your name?" name="name" />--%>
		<%--<s:textfield label="What is the date?" name="dateNow" />--%>
		<%--<s:submit />--%>
	<%--</s:form>--%>


	<div id="inputform" style="display: none;">
		<!-- <form> -->
		<label id="Namee" >Name:</label>
		<input id="name" type="text"><br>

		<label for="Surname">Surname:</label>
		<input type="text" id="surname"><br>

		<label for="UserName">UserName:</label>
		<input type="text" id="username"><br>
		<label for="email">email:</label>
		<input type="email" id="email"><br>

		<label for="password">password:</label>
		<input type="password" id="password"><br>
		<label for="confirmpassword">confirm password:</label>
		<input type="password" id="confirmpassword"><br>



		<label>auth:</label>
		<input type="radio" id="radioauth1" name="xyz" value="local auth">
		<label >local auth</label>

		<input type="radio" id="radioauth2" name="xyz" value="radius auth">
		<label >radius auth</label><br>

		<label >status:</label>
		<input type="radio" id="status1" name="status" value="Enabled">
		<label >Enabled</label>
		<input type="radio" id="status2" name="status" value="Disabled">
		<label >Disabled</label><br>

		<label >Department:</label>
		<input type="text" id="department"><br>

		<label for="Name">Role Group:</label>
		<input type="text" id="role"><br>

		<label for="description">description:</label><br>
		<textarea name="description" id="description" cols="30" rows="10"></textarea>

		<%--<input type="button" class="headBtn" id="submit" value="action" onclick="addRow()">--%>
		<%--<s:submit action="dbAccess" onclick="addRow()" class="headBtn"/>--%>
		<button onclick="addRow()"  class="headBtn">
			submit
		</button>

		<!-- </form> -->
	</div>






	<table id="tab1" border="1" style="border-collapse: collapse;">
		<tr class="headRow">
			<th class="headUser" colspan="7">Users</th>
			<th rowspan>
				<!--<a href="Task4Form.html" target="_blank">-->
				<button class="headBtn" onclick="makeVisible()">
					new
				</button>
				<!--</a>-->
			</th>
		</tr>
		<tr class="info">
			<td>User Name</td>
			<td class="cellAuthType">Authentication Type</td>
			<td>Departments</td>
			<td>Status</td>
			<td>Role Group</td>
			<td>E-mail</td>
			<td>Description</td>
		</tr>
	</table>





</body>
</html>
	