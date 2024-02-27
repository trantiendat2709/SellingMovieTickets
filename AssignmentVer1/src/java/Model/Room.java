/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Room {

    String roomId, roomName;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room() {
        connect();
    }

    public Room(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
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

    public ArrayList<Room> getInfoRoom(String startDate, String startTime, String movieId, String cinemaId) {
        ArrayList<Room> data = new ArrayList<>();
        try {

            String strQuery = "Select top 1 c.Phong_Chieu_Id , c.Ten from Lich_Chieu a join Phim b on a.Phim_Id = b.Phim_id \n"
                    + "join Phong_Chieu c on a.Phong_Chieu_Id = c.Phong_Chieu_Id\n"
                    + "join Rap_chieu d on c.Rap_Chieu_id = d.Rap_Chieu_Id\n"
                    + "join Khung_Gio_Chieu_Trong_Ngay e on a.Khung_Gio_Chieu_Trong_Ngay_ID = e.Khung_Gio_Chieu_Trong_Ngay_ID\n"
                    + "join Khung_Gio_Chieu f on e.Khung_Gio_Chieu_Id = f.Khung_Gio_Chieu_Id\n"
                    + "join Ngay_chieu g on e.Ngay_Chieu_Id = g.Ngay_chieu_id\n"
                    + "Where a.Phim_Id =? and g.Ngay =? and d.Rap_Chieu_Id =? and f.Gio_Bat_Dau =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, movieId);
            pstm.setString(2, startDate);
            pstm.setString(3, cinemaId);
            pstm.setString(4, startTime);

            rs = pstm.executeQuery();

            while (rs.next()) {
                String roomid = rs.getString(1);
                String name = rs.getString(2);
                data.add(new Room(roomid, name));
            }

        } catch (Exception e) {
            System.out.println("listSeat:" + e.getMessage());
        }
        return data;

    }
}

