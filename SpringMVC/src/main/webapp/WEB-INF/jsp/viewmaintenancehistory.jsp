<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Maintenance History</title>
    <style>
        body {
            background-image: url('${pageContext.request.contextPath}/resources/images/background.jpg');
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #333;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            margin: 50px auto;
            width: 70%;
            border-radius: 15px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }
        th {
            background-color: #add8e6;
            color: #333;
        }
        td {
            background-color: #f9f9f9;
        }
        a {
            color: #333;
            text-decoration: none;
            background-color: #add8e6;
            padding: 5px 10px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #5a5a5a;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Maintenance History</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Maintenance Date</th>
                <th>Details</th>
            </tr>
            <c:forEach var="history" items="${list}">
                <tr>
                    <td>${history.id}</td>
                    <td>${history.maintenanceDate}</td>
                    <td>${history.details}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </div>
</body>
</html>
