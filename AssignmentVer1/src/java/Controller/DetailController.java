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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DetailController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String movieId = (String) req.getParameter("movieId");
            Movie u = new Movie();
            ArrayList<Movie> data = u.getListMovie();
            for (Movie v : data) {
                if (v.getPhimId().trim().equalsIgnoreCase(movieId.trim())) {
                    req.setAttribute("u", v);
                    req.getRequestDispatcher("detail.jsp").forward(req, resp);
                }
            }
        
    }

}
