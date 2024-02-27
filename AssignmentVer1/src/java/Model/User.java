/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class User {

    String id, name, phoneNumber, email, address, password;

    public User() {
        connect();
    }

    public User(String id, String name, String phoneNumber, String email, String address, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        connect();
    }

    public User(String email, String password) {

        this.email = email;
        this.password = password;
        connect();
    }

    public User(String name, String phoneNumber, String email, String address, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        connect();
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Connection cnn; // Ket noi
    Statement stm; // thuc thi cac cau lenh sql
    ResultSet rs; // Luu tru va xu ly du lieu
    PreparedStatement pstm; // la nang cap cua stmde sua nhung loi gap phai

    private void connect() {

        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception e) {
        }
    }

    public User checkUser() {
        User user = null;
        try {
            String strSelect = "select * from Nguoi_dung where Email =? and Mat_khau =? ";
            pstm = cnn.prepareStatement(strSelect);
            // 2 dau hoi thi co 2 cai set
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User( rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("checkUser" + e.getMessage());
        }
        return user;

    }

    public boolean checkEmail(String email) {
        try {
            String strSelect = "select Email from Nguoi_dung";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(email)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("checkEmail" + e.getMessage());
        }
        return true;
    }

    public void addUser(String fullname, String email, String phonenumber, String address, String password) {
        try {

            String strAdd = "INSERT INTO Nguoi_dung (Ho_ten, So_dien_thoai, Email, Dia_chi, Mat_khau)\n"
                    + "VALUES (?, ? ,? ,? ,? )";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, fullname);
            pstm.setString(2, phonenumber);
            pstm.setString(3, email);
            pstm.setString(4, address);
            pstm.setString(5, password);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public String getIdByEmail(String email) {
        String uId = null;
        try {
            String strSelect = "select * from Nguoi_dung where Email =? ";
            pstm = cnn.prepareStatement(strSelect);
             pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
               uId = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getIdEmail" + e.getMessage());
        }
        return uId;
    }


}
