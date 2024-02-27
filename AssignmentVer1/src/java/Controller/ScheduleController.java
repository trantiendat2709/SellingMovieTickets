/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
public class ScheduleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("movieId");
        String cinemaId = req.getParameter("branchId");
        HttpSession session = req.getSession();
        session.setAttribute("movieid", movieId);
        session.setAttribute("branchid", cinemaId);
        Schedule s = new Schedule();
        
      
        
        ArrayList<Schedule> list = s.getListSchedule(movieId, cinemaId);
        req.setAttribute("list", list);
        req.getRequestDispatcher("schedule.jsp").forward(req, resp);
    }

}
