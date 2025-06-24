<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Fuel Purchases</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap');

        body {
            background-image: url('${pageContext.request.contextPath}/resources/images/thisOne.webp');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            margin: 50px auto;
            width: 70%;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-family: 'Poppins', sans-serif;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }
        th {
            background-color: #8FDDE7;
            color: #333;
        }
        td {
            background-color: #f9f9f9;
        }
        a {
            display: inline-block;
            margin: 20px 0;
            padding: 10px 20px;
            background-color: #8FDDE7;
            color: #333;
            text-decoration: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        a:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
        p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Fuel Purchases</h2>
        <c:if test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>
        <table>
            <tr>
                <th>ID</th>
                <th>Vehicle ID</th>
                <th>Date of Purchase</th>
                <th>Amount</th>
                <th>Price Per Unit</th>
            </tr>
            <c:forEach var="purchase" items="${list}">
                <tr>
                    <td>${purchase.id}</td>
                    <td>${purchase.vehicleId}</td>
                    <td>${purchase.dateOfPurchase}</td>
                    <td>${purchase.amount}</td>
                    <td>${purchase.pricePerUnit}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/">Back</a>
    </div>
</body>
</html>
