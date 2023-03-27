<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/25/2023
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.lab_assignment3.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab_assignment3.ShoppingCart" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <%
        String myString = "Hello, World!";
        out.println(myString);

        String url = "jdbc:mysql://localhost:3306/anime";
        String username = "root";
        String password = "Rubaiyat26";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        ArrayList<Map<String, Integer>> list = new ArrayList<>();

        String query = "SELECT * FROM product";
        ResultSet resultSet = statement.executeQuery(query);

        out.println("<h1>View Users</h1>");
        out.println("<table>");
        out.println("<tr><th>Name</th><th>Password</th></tr>");
        while (resultSet.next()) {

            Map<String, Integer> item1 = new HashMap<>();
            out.println("<tr>");

                out.println("<td>" + resultSet.getString("productid") + "</td>");
                out.println("<td>" + resultSet.getString("productname") + "</td>");
                out.println("<td>" + resultSet.getInt("productprice") + "</td>");
                out.println("<td><img src=" + resultSet.getInt("productprice") + "></td>");
                out.println("<td><form action=\"Additem\"  method=\"post\">");
                    out.println("<input type=\"hidden\" name=\"productId\" value=\"resultSet.getString(\"productid\")\">");
                    out.println("<input type=\"hidden\" name=\"name\" value=\"resultSet.getString(\"productname\")\">");
                    out.println("<input type=\"hidden\" name=\"price\" value="+ resultSet.getInt("productprice") +">");
                    out.println("<input type=\"hidden\" name=\"quantity\" value="+ resultSet.getInt("productquantity") +">");

                    out.println("<input type=\"submit\" name=\"action\" value=\"Add to Cart\">");
                    out.println("<input type=\"submit\" name=\"action\" value=\"Update Cart\">");
                    out.println("<input type=\"submit\" name=\"action\" value=\"Remove from Cart\">");
//                    out.println("<button type=\"submit\" name=cart value=resultSet.getString(\"animename\") >Add to cart</button>");
                out.println("</form></td>");
            out.println("</tr></br>");
        }
        out.println("</table>");

        resultSet.close();
        statement.close();
        connection.close();


    %>

    <%
        //List<Product> cartItems = (List<Product>) session.getAttribute("cart");
        //if (cartItems != null && !cartItems.isEmpty()) {
        //if (cartItems != null){
            //for (Product cartItem : cartItems) {

        ShoppingCart cartItemss = (ShoppingCart) session.getAttribute("cart");
        if (cartItemss != null) {
        List<Product> cartItems = ((ShoppingCart)cartItemss).getCartItems();
            for (Product cartItem : cartItems) {
    %>
    <div>
        <p>product items:</p>
        <p>Item Name: <%= cartItem.getName() %></p>
        <p>Item Price: <%= cartItem.getPrice() %></p>
        <p>Quantity: <%= cartItem.getQuantity() %></p>
    </div>
    <%
        }
    } else {
    %>
    <p>The cart is empty</p>
    <%
        }
    %>


</body>
</html>
