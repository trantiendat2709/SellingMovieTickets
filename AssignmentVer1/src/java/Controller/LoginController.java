/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Movie;
import Model.User;
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
public class LoginController extends HttpServlet{
    // uId user id
    // roomid là Room
    //branchid là rap
    //movieid là phim
    //time là gi? chi?u
    //startDate la gi? chi?u
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  // Nhan thong tin
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User u = new User(email, password);
        String error;
        User check = u.checkUser();
        HttpSession session = req.getSession();
        String uId = u.getIdByEmail(email);
        session.setAttribute("uId", uId);
        
        if (check != null) {
            req.setAttribute("name", check.getName());
            req.setAttribute("email", check.getEmail());
            req.setAttribute("pw", check.getPassword());
            
            session.setAttribute("jwtResponse", check);
            
             Movie p = new Movie();
            ArrayList<Movie> data = p.getListMovie();
            req.setAttribute("data", data);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        } else {

            error = "Email hoặc mật khẩu chưa đúng";
            req.setAttribute("error", error);
            req.setAttribute("email", email);
            req.setAttribute("pw", password);
            req.setAttribute("hasLoginErrors", error);
            Movie p = new Movie();
            ArrayList<Movie> data = p.getListMovie();
            req.setAttribute("data", data);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        }
    }
}
