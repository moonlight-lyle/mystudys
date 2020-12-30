<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">查询所有的账户</a><br/>
<form  action="account/save" method="post">
    账户名称: <input type="text" name="name"/><br/>
    账户金额: <input type="text" name="money"/><br/>
    <input type="submit" value="保存账户"/>
</form>
</body>
</html>
