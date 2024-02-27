/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Movie;
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
public class LogoutController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session = req.getSession();      
          session.setAttribute("jwtResponse", null);
          Movie p = new Movie();
            ArrayList<Movie> data = p.getListMovie();
            req.setAttribute("data", data);
          req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }
    
}
