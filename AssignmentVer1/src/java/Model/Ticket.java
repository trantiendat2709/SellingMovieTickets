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
public class Ticket {

    String ticketId, seatName, createTime,
            movieName, cinemaName, time, date, roomName;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public Ticket(String movieName, String cinemaName, String time, String date, String roomName, String seatName, String createTime) {
        this.seatName = seatName;
        this.createTime = createTime;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.time = time;
        this.date = date;
        this.roomName = roomName;
        connect();
    }
    

  
    

    public Ticket(String ticketId, String seatName, String createTime) {
        this.ticketId = ticketId;
        this.seatName = seatName;
        this.createTime = createTime;
        connect();
    }

    public Ticket() {
        connect();
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

    public String getKTG(String time, String date) {
        String ktgId = null;
        try {
            String strSelect = "select * from Khung_Gio_Chieu_Trong_Ngay a join Khung_Gio_Chieu b\n"
                    + "on a.Khung_Gio_Chieu_Id = b.Khung_Gio_Chieu_Id\n"
                    + "join Ngay_chieu c on a.Ngay_Chieu_Id = c.Ngay_chieu_id\n"
                    + "Where Ngay =? and Gio_Bat_Dau =? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, date);
            pstm.setString(2, time);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ktgId = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getIdEmail" + e.getMessage());
        }
        return ktgId;
    }

    public String getLC(String kgcId, String mId, String rId) {
        String lcId = null;
        try {
            String strSelect = "select * from Lich_Chieu Where Khung_Gio_Chieu_Trong_Ngay_ID =? and Phong_Chieu_Id =? and Phim_Id =? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, kgcId);
            pstm.setString(2, rId);
            pstm.setString(3, mId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                lcId = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getIdEmail" + e.getMessage());
        }
        return lcId;
    }

    public void addTicket(String lcId, String cId, String seat, String uId, String timeBooking) {
        try {
            String strSelect = "INSERT INTO Ve (Lich_Chieu_Id, Rap_Chieu_Id, Ghe_Id, Gia_Ve, Nguoi_dung_id,Thoi_gian_dat)\n"
                    + "VALUES (? ,? ,? ,? ,? ,? );";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, lcId);
            pstm.setString(2, cId);
            pstm.setString(3, seat);
            pstm.setString(4, "70000");
            pstm.setString(5, uId);
            pstm.setString(6, timeBooking);
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.out.println("addTicket" + e.getMessage());
        }
    }

    public ArrayList<Ticket> getListTicketBooking(String uId) {
        ArrayList<Ticket> data = new ArrayList<>();
        try {
            String strSelect = "select f.Ten,  b.Ten,  h.Gio_Bat_Dau , i.Ngay, pc.Ten, d.Ten, a.Thoi_Gian_Dat  \n"
                    + "from Ve a join Rap_chieu b on a.Rap_Chieu_Id = b.Rap_Chieu_Id\n"
                    + "join Lich_Chieu c on a.Lich_Chieu_Id = c.Lich_Chieu_Id \n"
                    + "join Phong_Chieu pc on pc.Phong_Chieu_Id = c.Phong_Chieu_Id\n"
                    + "join Ghe d on a.Ghe_Id = d.Ghe_Id \n"
                    + "join Nguoi_dung e on a.Nguoi_dung_id = e.Nguoi_dung_id \n"
                    + "join Phim f on f.Phim_id = c.Phim_Id\n"
                    + "join Khung_Gio_Chieu_Trong_Ngay g on g.Khung_Gio_Chieu_Trong_Ngay_ID = c.Khung_Gio_Chieu_Trong_Ngay_ID\n"
                    + "join Khung_Gio_Chieu h on h.Khung_Gio_Chieu_Id = g.Khung_Gio_Chieu_Id\n"
                    + "join Ngay_chieu i on g.Ngay_Chieu_Id = i.Ngay_chieu_id\n"
                    + "where e.Nguoi_dung_id =? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, uId);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String movieName = rs.getString(1);
                String cinemaName = rs.getString(2);
                String time = rs.getString(3).substring(0, 8);
                String date = rs.getString(4);
                String roomName = rs.getString(5);
                String seatName = rs.getString(6);
                String timeBooking = rs.getString(7);

                data.add(new Ticket(movieName, cinemaName, time, date, roomName, seatName, timeBooking));
            }
        } catch (SQLException e) {
            System.out.println("getListTicketBooking: " + e.getMessage());

        }
        return data;

    }

    public boolean checkTicket(String lcId, String cId, String seat, String uId) {
      try {
            String strSelect = "select * from Ve Where Lich_Chieu_Id =? and Rap_Chieu_Id =? and Ghe_Id =? ";
            pstm = cnn.prepareStatement(strSelect);
            // 2 dau hoi thi co 2 cai set
            pstm.setString(1, lcId);
            pstm.setString(2, cId);
            pstm.setString(3, seat);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkTicket" + e.getMessage());
        }
        return false;
    }

    
}
