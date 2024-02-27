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
public class BillController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] seats = req.getParameterValues("seats");
        if (seats == null || seats.length == 0) {
            Seat seat = new Seat();
            HttpSession session = req.getSession();
            String roomId = (String) session.getAttribute("roomid");
            ArrayList<Seat> listA = seat.getListSeat(roomId, "A");
            ArrayList<Seat> listB = seat.getListSeat(roomId, "B");
            ArrayList<Seat> listC = seat.getListSeat(roomId, "C");
            ArrayList<Seat> listD = seat.getListSeat(roomId, "D");
            ArrayList<Seat> listE = seat.getListSeat(roomId, "E");
            req.setAttribute("listA", listA);
            req.setAttribute("listB", listB);
            req.setAttribute("listC", listC);
            req.setAttribute("listD", listD);
            req.setAttribute("listE", listE);
            // Nếu mảng seats rỗng hoặc null, chuyển hướng trở lại trang JSP cũ.
            req.setAttribute("errorMessage", "Bạn chưa chọn ghế");
            req.getRequestDispatcher("seat.jsp").forward(req, resp);
        } else {
            Seat s = new Seat();
            Ticket t = new Ticket();
            HttpSession session = req.getSession();
            String uId = (String) session.getAttribute("uId");
            String rId = (String) session.getAttribute("roomid");
            String cId = (String) session.getAttribute("branchid");
            String mId = (String) session.getAttribute("movieid");
            String time = (String) session.getAttribute("time");
            String date = (String) session.getAttribute("startDate");
            String kgcId = t.getKTG(time, date);
            String lcId = t.getLC(kgcId, mId, rId);
            
            
            
            
            Cart c = new Cart();
            for (int i = 0; i < seats.length; i++) {
                c.addCart(lcId,cId,seats[i],uId);
            }
            
            session.setAttribute("seatChoose", seats);
            String numberSeats = String.valueOf(seats.length);
            String price = String.valueOf(seats.length * 70000);
            req.setAttribute("numberSeats", numberSeats);
            req.setAttribute("price", price);
            req.getRequestDispatcher("bill.jsp").forward(req, resp);

        }
    }
}
