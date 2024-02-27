/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Cart {

    String cartId, seatName, movieName, cinemaName, time, date, roomName, lcId, sId, cId;

    public Cart() {
        connect();
    }

    public Cart(String cartId, String seatName, String movieName, String cinemaName, String time, String date, String roomName) {
        this.cartId = cartId;
        this.seatName = seatName;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.time = time;
        this.date = date;
        this.roomName = roomName;
        connect();
    }

    public Cart(String seatName, String movieName, String cinemaName, String time, String date, String roomName) {
        this.seatName = seatName;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.time = time;
        this.date = date;
        this.roomName = roomName;
        connect();
    }

    public Cart(String seatName, String movieName, String cinemaName, String time, String date, String roomName, String lcId, String sId, String cId) {
        this.seatName = seatName;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.time = time;
        this.date = date;
        this.roomName = roomName;
        this.lcId = lcId;
        this.sId = sId;
        this.cId = cId;
        connect();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLcId() {
        return lcId;
    }

    public void setLcId(String lcId) {
        this.lcId = lcId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
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

    public void addCart(String lcId, String cId, String seat, String uId) {
        try {
            String strSelect = "Insert into Gio_Hang (Lich_Chieu_id,Ghe_id,Rap_Chieu_Id,Gia_Ve,Nguoi_dung_id)\n"
                    + "values(? ,? ,? ,? ,? );";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, lcId);
            pstm.setString(2, seat);
            pstm.setString(3, cId);
            pstm.setString(4, "70000");
            pstm.setString(5, uId);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("addCart" + e.getMessage());
        }

    }

    public ArrayList<Cart> getListCart(String uId) {
        ArrayList<Cart> data = new ArrayList<>();
        try {
            String strSelect = "SELECT t.Lich_Chieu_id, t.Ghe_id, t.Rap_Chieu_Id, t.Nguoi_dung_id, rc.Ten, d.Ten, f.Ten,  h.Gio_Bat_Dau , i.Ngay, pc.Ten\n"
                    + "FROM (select distinct a.Lich_Chieu_id,a.Ghe_id,a.Rap_Chieu_Id, a.Gia_Ve ,a.Nguoi_dung_id\n"
                    + "      from Gio_Hang a \n"
                    + "      left join Ve b on a.Nguoi_dung_id = b.Nguoi_dung_id\n"
                    + "                    and a.Lich_Chieu_id = b.Lich_Chieu_Id \n"
                    + "                    and a.Ghe_id = b.Ghe_Id \n"
                    + "                    and a.Rap_Chieu_Id = b.Rap_Chieu_Id\n"
                    + "      where a.Nguoi_dung_id =? and Ve_Id is null) t \n"
                    + "JOIN Rap_chieu rc on t.Rap_Chieu_Id = rc.Rap_Chieu_Id \n"
                    + "JOIN Lich_Chieu c on t.Lich_Chieu_Id = c.Lich_Chieu_Id \n"
                    + "JOIN Phong_Chieu pc on pc.Phong_Chieu_Id = c.Phong_Chieu_Id \n"
                    + "JOIN Ghe d on t.Ghe_Id = d.Ghe_Id \n"
                    + "JOIN Nguoi_dung e on t.Nguoi_dung_id = e.Nguoi_dung_id \n"
                    + "JOIN Phim f on f.Phim_id = c.Phim_Id \n"
                    + "JOIN Khung_Gio_Chieu_Trong_Ngay g on g.Khung_Gio_Chieu_Trong_Ngay_ID = c.Khung_Gio_Chieu_Trong_Ngay_ID \n"
                    + "JOIN Khung_Gio_Chieu h on h.Khung_Gio_Chieu_Id = g.Khung_Gio_Chieu_Id \n"
                    + "JOIN Ngay_chieu i on g.Ngay_Chieu_Id = i.Ngay_chieu_id;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, uId);
            rs = pstm.executeQuery();

            while (rs.next()) {

                String lcId = rs.getString(1);
                String sId = rs.getString(2);
                String cId = rs.getString(3);
                String movieName = rs.getString(7);
                String cinemaName = rs.getString(5);
                String time = rs.getString(8).substring(0, 8);
                String date = rs.getString(9);
                String roomName = rs.getString(10);
                String seatName = rs.getString(6);
                data.add(new Cart(seatName, movieName, cinemaName, time, date, roomName, lcId, sId, cId));
            }
        } catch (SQLException e) {
            System.out.println("getListCart: " + e.getMessage());

        }
        return data;
    }

    public void deleteCart(String lcId, String cId, String sId, String uId) {
        try {
            String strSelect = "DELETE FROM Gio_Hang\n"
                    + "WHERE Lich_Chieu_id =? and Ghe_id =? and Rap_Chieu_id =? and Nguoi_dung_id =? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, lcId);
            pstm.setString(2, sId);
            pstm.setString(3, cId);
            pstm.setString(4, uId);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("deleteCart" + e.getMessage());
        }
    }

}
