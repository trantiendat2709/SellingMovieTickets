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
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String EMAIL_PATTERN
                = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        String PHONE_PATTERN = "^(03|05|07|08|09)+([0-9]{8})\\b";

        String FULLNAME_PATTERN = "^[^\\d]*$";
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("username");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String repass = req.getParameter("repassword");

        String errorFullName = null;
        String errorEmail = null;
        String errorPhoneNumber = null;
        String errorAddress = null;
        String errorPassword = null;
        String errorRePassword = null;

        boolean check = false;
        User u = new User();
        boolean checkEmail = u.checkEmail(email);

        if (req.getParameter("fullname").isEmpty()) {
            errorFullName = "Chưa điền họ tên";
            check = true;
        } else if (Pattern.matches(FULLNAME_PATTERN, fullname) == false) {
            errorFullName = "Họ tên không hợp lệ";
            check = true;
        }

        if (req.getParameter("username").isEmpty()) {
            errorEmail = "Chưa điền email";
            check = true;
        } else if (Pattern.matches(EMAIL_PATTERN, email) == false) {
            errorEmail = "Email không hợp lệ";
            check = true;
        }

        if (req.getParameter("phonenumber").isEmpty()) {
            errorPhoneNumber = "Chưa điền số điện thoại";
            check = true;
        } else if (Pattern.matches(PHONE_PATTERN, phonenumber) == false) {
            errorPhoneNumber = "Số điện thoại không hợp lệ";
            check = true;
        }

        if (req.getParameter("address").isEmpty()) {
            errorAddress = "Chưa điền địa chỉ";
            check = true;
        }

        if (req.getParameter("repassword").isEmpty()) {
            errorRePassword = "Chưa điền re-password";
            check = true;
        } else if (!req.getParameter("password").equals(req.getParameter("repassword"))) {
            errorRePassword = "Re-password không đúng";
            check = true;
        }

        if (req.getParameter("password").isEmpty()) {
            errorPassword = "Chưa điền mật khẩu";
            check = true;
        } else if (req.getParameter("password").length() < 6 || req.getParameter("password").length() > 10) {
            errorPassword = "Mật khẩu phải từ 6 đến 10 kí tự";
            check = true;
        }

        if (checkEmail == false) {
            errorEmail = "Email này đã được đăng ký";
            check = true;
        }

        String error;

        if (check == true) {
            error = "Co loi";
        } else {
            error = null;
            fullname = req.getParameter("fullname");
            email = req.getParameter("username");
            phonenumber = req.getParameter("phonenumber");
            address = req.getParameter("address");
            password = req.getParameter("password");
            u.addUser(fullname, email, phonenumber, address, password);

           
        }

        Movie p = new Movie();
        ArrayList<Movie> data = p.getListMovie();
        req.setAttribute("data", data);
        req.setAttribute("errorfn", errorFullName);
        req.setAttribute("fn", fullname);
        req.setAttribute("errorun", errorEmail);
        req.setAttribute("un", email);
        req.setAttribute("errorpn", errorPhoneNumber);
        req.setAttribute("pn", phonenumber);
        req.setAttribute("errorar", errorAddress);
        req.setAttribute("ar", address);
        req.setAttribute("errorpw", errorPassword);
        req.setAttribute("pw", password);
        req.setAttribute("errorrepw", errorRePassword);
        req.setAttribute("repw", repass);
        req.setAttribute("hasErrors", error);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);

    }

//    
//     User checkUser = new User(fullname, phonenumber, email, address, password);
//            HttpSession session = req.getSession();
//            String uId = u.getIdByEmail(email);
//            session.setAttribute("uId", uId);
//            session.setAttribute("jwtResponse", checkUser);
//
//            Movie p = new Movie();
//            ArrayList<Movie> data = p.getListMovie();
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("Home.jsp").forward(req, resp);
}
