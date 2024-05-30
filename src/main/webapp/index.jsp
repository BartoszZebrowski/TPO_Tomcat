<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="/Tomcat_war_exploded/CarServlet" method="get">
        <label for="type">Typ samochodu:</label>
        <input type="text" id="type" name="type">
        <br><br>
        <input type="submit" value="Wyślij">
    </form>
</body>
</html>