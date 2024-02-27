/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cart;
import Model.Seat;
import Model.Ticket;
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
public class BillCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Seat s = new Seat();
        Ticket t = new Ticket();
        Cart c = new Cart();
        HttpSession session = req.getSession();
        String movieName = req.getParameter("mName");
        String cinemaName = req.getParameter("cName");
        String time = req.getParameter("time");
        String date = req.getParameter("date");
        String roomName = req.getParameter("rName");
        String seatName = req.getParameter("sName");
        String timeBooking = req.getParameter("timeBooking").substring(13);
        String uId = (String) session.getAttribute("uId");
        String lcId = req.getParameter("lcId");
        String cId = req.getParameter("cId");
        String sId = req.getParameter("sId");

     

        boolean check = t.checkTicket(lcId, cId, sId, uId);
        if (check == true) {

            c.deleteCart(lcId, cId, sId, uId);
            ArrayList<Cart> dataCart = c.getListCart(uId);

            req.setAttribute("listCart", dataCart);
            req.setAttribute("errorMessage", "Có người đã đặt ghế này");
            req.getRequestDispatcher("Cart.jsp").forward(req, resp);

        } else {

            t.addTicket(lcId, cId, sId, uId, timeBooking);
            s.updateSeat(sId);

            req.setAttribute("mName", movieName);
            req.setAttribute("cName", cinemaName);
            req.setAttribute("time", time);
            req.setAttribute("date", date);
            req.setAttribute("rName", roomName);
            req.setAttribute("sName", seatName);
            req.setAttribute("timeBooking", timeBooking);
            req.getRequestDispatcher("listticketcart.jsp").forward(req, resp);
        }
    }

}
