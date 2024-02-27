/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Room;
import Model.Schedule;
import Model.Seat;
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
public class SeatController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Seat seat = new Seat();
        String startTime = req.getParameter("startTime");
        String startDate = (String) session.getAttribute("startDate");
        String movieId = (String) session.getAttribute("movieid");
        String cinemaId = (String) session.getAttribute("branchid");

        if (startTime == null || startTime.equals("0")) {

            Schedule s = new Schedule(startDate, movieId, Integer.parseInt(cinemaId));
            ArrayList<Schedule> listTime = s.getListTime(movieId, cinemaId, startDate);
            req.setAttribute("listTime", listTime);
            req.setAttribute("error", "( Bạn chưa chọn giờ xem phim )");
            req.getRequestDispatcher("showtime.jsp").forward(req, resp);

        } else {
            Room r = new Room();
            ArrayList<Room> dataRoom = r.getInfoRoom(startDate, startTime, movieId, cinemaId);
            String roomName = dataRoom.get(0).getRoomName();
            String roomId = dataRoom.get(0).getRoomId();

            session.setAttribute("time", startTime);
            session.setAttribute("roomname", roomName);
            session.setAttribute("roomid", roomId);

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
            req.getRequestDispatcher("seat.jsp").forward(req, resp);

        }

    }

}
