/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
public class HistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket t = new Ticket();
        HttpSession session = req.getSession();
        String uId = (String) session.getAttribute("uId");
        ArrayList<Ticket> data = t.getListTicketBooking(uId);
        if (data.isEmpty()) {
            req.getRequestDispatcher("historyNotBooking.jsp").forward(req, resp);
        } else {
            req.setAttribute("data", data);
            req.getRequestDispatcher("history.jsp").forward(req, resp);
        }
    }

}
