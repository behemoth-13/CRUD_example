<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>List of Cars</title>
  </head>
  <body>
    <%@include file="../fragments/header.jspf" %>
        <h2>Cars</h2>
        <table class="table">
            <tr>
                <th>model</th>
                <th>max speed</th>
                <th>consumption</th>
                <th>volume tank</th>
                <th>delete</th>
            </tr>
            <c:forEach items="${requestScope.cars}" var = "car" >
            <tr>
                <td>${car.model}</td>
                <td>${car.maxSpeed}</td>
                <td>${car.consumptionPer100Km}</td>
                <td>${car.volTank}</td>
                <td>
                    <form action="crud" method="get">
                        <button class="button" name="id" value="${car.id}" type="submit">delete</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
    <%@include file="../fragments/footer.jspf" %>
  </body>
</html>
