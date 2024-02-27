/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Schedule {

    String startDate;
    String startTime;
    String Movie_id;
    int Cinema_id;

    public Schedule(String startDate, String startTime, String Movie_id, int Cinema_id) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.Movie_id = Movie_id;
        this.Cinema_id = Cinema_id;
        connect();
    }

    public Schedule() {
        connect();
    }

    public Schedule(String startDate, String Movie_id, int Cinema_id) {
        this.startDate = startDate;
        this.Movie_id = Movie_id;
        this.Cinema_id = Cinema_id;
        connect();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getMovie_id() {
        return Movie_id;
    }

    public void setMovie_id(String Movie_id) {
        this.Movie_id = Movie_id;
    }

    public int getCinema_id() {
        return Cinema_id;
    }

    public void setCinema_id(int Cinema_id) {
        this.Cinema_id = Cinema_id;
    }

    public Schedule(String startDate) {
        this.startDate = startDate;
        connect();
    }

    public Schedule(String startDate, String startTime) {
        this.startDate = startDate;
        this.startTime = startTime;
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

    public ArrayList<Schedule> getListSchedule(String movieId, String cinemaId) {
        ArrayList<Schedule> data = new ArrayList<>();
        try {

            String strQuery = "select  distinct e.Ngay from Lich_Chieu a join Khung_Gio_Chieu_Trong_Ngay  b\n"
                    + "                    on a.Khung_Gio_Chieu_Trong_Ngay_ID = b.Khung_Gio_Chieu_Trong_Ngay_ID\n"
                    + "                    join Phong_Chieu c on a.Phong_Chieu_Id = c.Phong_Chieu_Id\n"
                    + "                    join Khung_Gio_Chieu d on d.Khung_Gio_Chieu_Id = b.Khung_Gio_Chieu_Id\n"
                    + "                    join Ngay_chieu e on e.Ngay_chieu_id = b.Ngay_Chieu_Id\n"
                    + "			   Where e.Ngay > getDate() and Phim_Id =? and Rap_Chieu_id =?";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, movieId);
            pstm.setString(2, cinemaId);
            rs = pstm.executeQuery();

            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

            while (rs.next()) {
                String stdate = "";
                if (rs.getDate(1) != null) {
                    stdate = f.format(rs.getDate(1));
                }
                data.add(new Schedule(stdate));
            }

        } catch (Exception e) {
            System.out.println("listSchedule:" + e.getMessage());
        }
        return data;

    }

    public ArrayList<Schedule> getListTime(String movieId, String cinemaId, String date) {
        ArrayList<Schedule> data = new ArrayList<>();
        try {

            String strQuery = "select  distinct e.Ngay , d.Gio_Bat_Dau from Lich_Chieu a join Khung_Gio_Chieu_Trong_Ngay b\n"
                    + "on a.Khung_Gio_Chieu_Trong_Ngay_ID = b.Khung_Gio_Chieu_Trong_Ngay_ID\n"
                    + " join Phong_Chieu c on a.Phong_Chieu_Id = c.Phong_Chieu_Id\n"
                    + " join Khung_Gio_Chieu d on d.Khung_Gio_Chieu_Id = b.Khung_Gio_Chieu_Id\n"
                    + " join Ngay_chieu e on e.Ngay_chieu_id = b.Ngay_Chieu_Id\n"
                    + "Where Phim_Id =? AND Rap_Chieu_id =? AND Ngay =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, movieId);
            pstm.setString(2, cinemaId);
            pstm.setString(3, date);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String startDate = rs.getString(1);
                String starTime = rs.getString(2).substring(0, 8);
                data.add(new Schedule(startDate, starTime));
            }

        } catch (Exception e) {
            System.out.println("listSchedule:" + e.getMessage());
        }
        return data;
    }

    public static void main(String[] args) {
        Schedule s = new Schedule();
        ArrayList<Schedule> list = s.getListTime("P003", "1", "2023-03-16");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStartTime());
        }
    }

}
