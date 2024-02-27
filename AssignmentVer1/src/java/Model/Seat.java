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
public class Seat {

    String seatId, roomId, name, isOccupied;

    public Seat(String seatId, String roomId, String name, String isOccupied) {
        this.seatId = seatId;
        this.roomId = roomId;
        this.name = name;
        this.isOccupied = isOccupied;
        connect();
    }

    public Seat() {
        connect();
    }

    public Seat(String seatId, String name) {
        this.seatId = seatId;
        this.name = name;
        connect();
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(String isOccupied) {
        this.isOccupied = isOccupied;
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

    public ArrayList<Seat> getListSeat(String roomId, String a) {
        ArrayList<Seat> data = new ArrayList<>();
        try {

            String strQuery = "select * from Ghe \n"
                    + "Where Phong_Chieu_Id =? and Ten like ? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, roomId);
            pstm.setString(2, a + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String seatId = rs.getString(1);
                String name = rs.getString(3);
                String room = rs.getString(2);
                String isOccupied = rs.getString(4);
                data.add(new Seat(seatId, room, name, isOccupied));
            }

        } catch (Exception e) {
            System.out.println("listSeat:" + e.getMessage());
        }
        return data;

    }

    public Seat getInfoSeat(String seat) {
        Seat s = new Seat();
        try {

            String strQuery = "select * from Ghe  Where Ghe_Id =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, seat);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String seatId = rs.getString(1);
                String seatName = rs.getString(3);
                s = new Seat(seatId, seatName);
            }

        } catch (Exception e) {
            System.out.println("getSeatInfo:" + e.getMessage());
        }
        return s;
    }

    public void updateSeat(String seat) {
        Seat s = new Seat();
        try {

            String strQuery = "UPDATE Ghe\n"
                    + "SET Da_dat = 1\n"
                    + "WHERE Ghe_Id =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, seat);
            rs = pstm.executeQuery();

        } catch (Exception e) {
            System.out.println("getSeatInfo:" + e.getMessage());
        }
    }
}
