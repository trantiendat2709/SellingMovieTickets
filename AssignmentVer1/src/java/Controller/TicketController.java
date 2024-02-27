/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
public class TicketController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Seat s = new Seat();
        Ticket t = new Ticket();
        HttpSession session = req.getSession();
        String timeBooking = req.getParameter("timeBooking");
        String[] seats = (String[]) session.getAttribute("seatChoose");
        String uId = (String) session.getAttribute("uId");
        String rId = (String) session.getAttribute("roomid");
        String cId = (String) session.getAttribute("branchid");
        String mId = (String) session.getAttribute("movieid");
        String time = (String) session.getAttribute("time");
        String date = (String) session.getAttribute("startDate");
        String kgcId = t.getKTG(time, date);
        String lcId = t.getLC(kgcId, mId, rId);
        boolean check = false;

        for (int i = 0; i < seats.length; i++) {
            check = t.checkTicket(lcId, cId, seats[i],uId);
            if (check == true) {
                break;
            }
        }

        if (check == true) {
            Seat seat = new Seat();
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
            req.setAttribute("errorMessage", "Có người đã đặt ghế trước bạn . Hãy chọn lại ghế");
            req.getRequestDispatcher("seat.jsp").forward(req, resp);

        } else {

            ArrayList<Seat> dataSeat = new ArrayList<>();
            for (int i = 0; i < seats.length; i++) {
                dataSeat.add(s.getInfoSeat(seats[i]));
                t.addTicket(lcId, cId, seats[i], uId, timeBooking);
                s.updateSeat(seats[i]);
            }
            req.setAttribute("listTickets", dataSeat);
            req.setAttribute("timeBooking", timeBooking);
            req.getRequestDispatcher("listticket.jsp").forward(req, resp);
        }
    }

}
