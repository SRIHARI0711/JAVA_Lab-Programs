<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Shirt Purchase</title>
</head>
<body>
    <h2>Shirt Shop</h2>
    <table border="1">
        <tr><th>Shirt Type</th><th>Cost (INR)</th></tr>
        <tr><td>Formal</td><td>500</td></tr>
        <tr><td>Casual</td><td>400</td></tr>
        <tr><td>Sports</td><td>300</td></tr>
    </table>

    <form method="post">
        <p>
            <label for="shirtType">Select Shirt Type:</label>
            <select name="shirtType" id="shirtType">
                <option value="Formal">Formal</option>
                <option value="Casual">Casual</option>
                <option value="Sports">Sports</option>
            </select>
        </p>

        <p>Select Neck Type:</p>
        <input type="radio" name="neckType" value="Round Neck" checked>Round Neck<br>
        <input type="radio" name="neckType" value="V Neck">V Neck<br>
        <input type="radio" name="neckType" value="Collar">Collar<br>

        <p>
            <label for="quantity">Enter Quantity:</label>
            <input type="number" name="quantity" min="1" required>
        </p>

        <input type="submit" value="Compute">
    </form>
    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String shirtType = request.getParameter("shirtType");
            String neckType = request.getParameter("neckType");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int costPerShirt = 0;
            switch (shirtType) {
                case "Formal": costPerShirt = 500; break;
                case "Casual": costPerShirt = 400; break;
                case "Sports": costPerShirt = 300; break;
            }
            int totalCost = costPerShirt * quantity;
    %>
    <h2>Purchase Summary</h2>
    <p><strong>Shirt Type:</strong> <%= shirtType %></p>
    <p><strong>Neck Type:</strong> <%= neckType %></p>
    <p><strong>Quantity:</strong> <%= quantity %></p>
    <p><strong>Cost per Shirt:</strong> <%= costPerShirt %></p>
    <p><strong>Total Cost:</strong> <%= totalCost %></p>
    <%
        }
    %>
</body>
</html>