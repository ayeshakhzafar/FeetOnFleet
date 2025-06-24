<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fuel Purchase Form</title>
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
        input[type="text"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #8FDDE7;
            color: #333;
            padding: 10px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #5a5a5a;
            color: #fff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Fuel Purchase Form</h2>
        <form action="${pageContext.request.contextPath}/addFuelPurchase" method="POST">
            <table>
                <tr>
                    <td>Vehicle ID:</td>
                    <td><input type="text" name="id" /></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="text" name="amount" /></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><input type="date" name="date" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
