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
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SearchController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String movieName = req.getParameter("movie-name");
        Movie u = new Movie();
        ArrayList<Movie> list = u.getListMovie();
        ArrayList<Movie> data = u.searchMovie(list, movieName);
        
        if(data.isEmpty()){
             req.getRequestDispatcher("detailNotFound.jsp").forward(req, resp);
        }else{
            req.setAttribute("data", data);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        } 

    }
}