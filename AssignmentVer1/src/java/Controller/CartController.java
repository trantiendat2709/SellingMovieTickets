/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart c = new Cart();
        HttpSession session = req.getSession();
        String uId = (String) session.getAttribute("uId");
        ArrayList<Cart> dataCart = c.getListCart(uId);
        if (dataCart.isEmpty()) {
            req.getRequestDispatcher("CartEmpty.jsp").forward(req, resp);
        } else {
            req.setAttribute("listCart", dataCart);
            req.getRequestDispatcher("Cart.jsp").forward(req, resp);
        }
    }

}
