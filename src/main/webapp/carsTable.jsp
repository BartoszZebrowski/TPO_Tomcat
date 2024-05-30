
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Samochody wedlog typu</title>
</head>
<body>
<table border="1">
  <h1>Samochody typu ${type}</h1>
  <thead>
  <tr>
    <th>Id</th>
    <th>Marka</th>
    <th>Rok Produkcji</th>
    <th>Spalanie l/100km</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach var="car" items="${cars}">
      <tr>
        <td>${car.Id}</td>
        <td>${car.Type}</td>
        <td>${car.ProductionYear}</td>
        <td>${car.LitersPerHundredKms}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>