package com.example.lab_assignment3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Additem", value = "/Additem")
public class Additem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("Add to Cart")) {
            String productId = request.getParameter("productId");
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Product product = new Product(productId, name, price, quantity);

            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            if (cart == null ) {
                cart = new ShoppingCart();
            }

            session.setAttribute("cart", cart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
        else if (action.equals("Update Cart")) {
            String productId = request.getParameter("productId");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Product product = new Product(productId, "", 0, quantity);

            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            cart.updateItem(product, quantity);
            session.setAttribute("cart", cart);
        }
        else if (action.equals("Remove from Cart")) {
            String productId = request.getParameter("productId");

            Product product = new Product(productId, "", 0, 0);

            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            cart.removeItem(product);
            session.setAttribute("cart", cart);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
    }
}
