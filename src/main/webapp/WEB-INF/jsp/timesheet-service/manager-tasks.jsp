<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="manager" type="org.lnk.timesheet.domain.Manager"--%>
<%--@elvariable id="tasks" type="java.util.List<org.lnk.timesheet.domain.Task>"--%>

<html>
<head>
    <title>Tasks for manager</title>
    <link rel="stylesheet" href="/timesheet/resources/style.css" type="text/css">
</head>
<body>
    <h3>
        Current manager: <a href="/timesheet/managers/${manager.id}">${manager.name}</a>
    </h3>
    <div id="list">
        <c:forEach items="${tasks}" var="task">
            <li>
                <a href="/timesheet/tasks/${task.id}">${task.description}</a>
            </li>
        </c:forEach>
    </div>

    <br /><br />
    <a href="../">Go Back</a>
</body>
</html>