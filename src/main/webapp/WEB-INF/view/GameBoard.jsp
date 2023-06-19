<%--
  Created by IntelliJ IDEA.
  User: léo
  Date: 16/06/2023
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>5 premiere lignes joueur 1 / 5 derniere lignes joueur 2</h2>
<br>
<span style="font-size: 20px;">tours du joueur : ${turn}</span>
<c:if test="${winner != null}">
    <h1>Winner : player ${winner}</h1>
    <a href="?type=restart">Restart</a>
</c:if>
<div style="display: flex;flex-direction: row">
    <div style="display: grid;grid-template-rows: 1fr 0.1fr 1fr">
        <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">player1</div>
        <div><hr></div>
        <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">player2</div>

    </div>
    <div style="display: grid; grid-template-columns: repeat(10,1fr);gap: 3px " >
        <c:if test="${plateau.size() != 0}">
            <c:forEach items="${plateau}" var="cas">
                <c:if test="${cas.getX() == 6 && cas.getY() == 1}">
                    <div style="grid-column: 1/11">
                        <hr>
                    </div>
                </c:if>
                <form action="" method="post" style="width: 100%;height: 100%">
                    <input type="number" hidden="hidden" name="x" value="${cas.getX()}">
                    <input type="number" hidden="hidden" name="y" value="${cas.getY()}">
                    <c:if test="${cas.isDiscover()}">
                        <c:if test="${cas.isSink()}">
                            <button disabled style="width: 100%;height: 100%;background-color: darkred ;border: none">XXX</button>
                        </c:if>
                        <c:if test="${!cas.isSink()}">
                            <button disabled style="width: 100%;height: 100%;background-color: green;border: none">~~~~~~</button>
                        </c:if>
                    </c:if>
                    <c:if test="${!cas.isDiscover()}">
                        <button style="width: 100%;height: 100%;background-color: dodgerblue;border: none">~~~~~~</button>
                    </c:if>
                </form>
            </c:forEach>
        </c:if>
    </div>
</div>






<%--<c:if test="${plateau.size() != 0}">
    <c:forEach items="${plateau}" var="case">
        <c:if test="${plateau.getY() == 10}">
            <form action="">
                <c:if test="${case.isDiscover()}">
                    <c:if test="${case.isSink()}">
                        <button disabled>sink</button>
                    </c:if>
                    <c:if test="${!case.isSink()}">
                        <button disabled>discoverd</button>
                    </c:if>
                </c:if>
                <c:if test="${!case.isDiscover()}">
                    <button>undiscoverd</button>
                </c:if>
            </form>
            <br>
        </c:if>
        <c:if test="${plateau.getY() != 10}">
            <form action="">
                <input type="number" hidden="hidden" name="x" value="${case.getX()}">
                <input type="number" hidden="hidden" name="y" value="${case.getY()}">
                <c:if test="${case.isDiscover()}">
                    <c:if test="${case.isSink()}">
                        <button disabled>sink</button>
                    </c:if>
                    <c:if test="${!case.isSink()}">
                        <button disabled>discoverd</button>
                    </c:if>
                </c:if>
                <c:if test="${!case.isDiscover()}">
                    <button>undiscoverd</button>
                </c:if>
            </form>
        </c:if>

    </c:forEach>
</c:if>--%>

</body>
</html>
