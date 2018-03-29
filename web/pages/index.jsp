<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome page</title>
  </head>
  <body>
    <%@include file="../fragments/header.jspf"  %>
        <a href="car">add car</a>
        <br>
        <form action="crud" method="get">
            <button class="button" name="act" value="list" type="submit">List of car</button>
        </form>
    <%@include file="../fragments/footer.jspf"  %>
  </body>
</html>