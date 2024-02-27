/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cinema;
import Model.Movie;
import Model.Schedule;
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
public class ShowTimeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String movieId = (String) session.getAttribute("movieid");
        String cinemaId = (String) session.getAttribute("branchid");
        String startDateFormat = req.getParameter("startDate");

        if (startDateFormat == null || startDateFormat.equals("0")) {
            Schedule s = new Schedule();
            ArrayList<Schedule> list = s.getListSchedule(movieId, cinemaId);
            req.setAttribute("list", list);
            req.setAttribute("error", "( Bạn chưa chọn ngày xem phim )");
            req.getRequestDispatcher("schedule.jsp").forward(req, resp);
        } else {
            String startDate = startDateFormat.subSequence(6, 10) + "-" + startDateFormat.substring(3, 5) + "-" + startDateFormat.substring(0, 2);
            Movie m = new Movie();
            ArrayList<Movie> dataPhim = m.getInfoMovie(movieId);
            Cinema c = new Cinema();
            ArrayList<Cinema> dataRap = c.getInfoCinema(cinemaId);
            session.setAttribute("movieName", dataPhim.get(0).getTen());
            session.setAttribute("moviePicture", dataPhim.get(0).getImage());
            session.setAttribute("cinemaName", dataRap.get(0).getName());
            session.setAttribute("cinemaPicture", dataRap.get(0).getImage());
            session.setAttribute("startDate", startDate);
            session.setAttribute("startDateFormat", startDateFormat);
            Schedule s = new Schedule(startDate, movieId, Integer.parseInt(cinemaId));
            session.setAttribute("dateShowtime", s);

            ArrayList<Schedule> listTime = s.getListTime(movieId, cinemaId, startDate);
            req.setAttribute("listTime", listTime);
            req.getRequestDispatcher("showtime.jsp").forward(req, resp);
        }
    }

}
