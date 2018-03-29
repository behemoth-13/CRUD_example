<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <%@include file="../fragments/header.jspf"  %>
        Car Parameters
        <form action="crud" method="post">

            Model <input type="text" maxlength="15" name="model" id="modelForm"">
            <p id="model" style="color: #2BC6A4">model var</p>
            <br>

            Maximal speed <input type="text" maxlength="15" name="maxSpeed" id="maxSpeedForm" onKeyUp="check('maxSpeed')">
            <p id="maxSpeed" style="color: #2BC6A4">${val_capacity}<sup>3</sup></p>
            <br>

            Consumption per 100 km <input type="text" maxlength="15" name="cons" id="consForm" onKeyUp="check('cons')">
            <p id="cons" style="color: #FF3D3D">${val_distance}</p>
            <br>

            Volume tank <input type="text" maxlength="4" name="volTank" id="volTankForm" onKeyUp="check('volTank')">
            <p id="volTank" style="color: #FF3D3D">${val_distance}</p>
            <br>

            <button class="button" type="submit">Add</button>
        </form>
    <%@include file="../fragments/footer.jspf"  %>
  </body>
</html>
