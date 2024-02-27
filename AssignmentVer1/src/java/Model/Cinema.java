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
public class Cinema {

    String id, name, address, phone, image;

    public Cinema(String name, String image) {
        this.name = name;
        this.image = image;
        connect();
    }

  

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Cinema() {
        connect();
    }

    public Cinema(String id, String name, String address, String phone, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
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

    public ArrayList<Cinema> getListCinema(String movieId) {
        ArrayList<Cinema> data = new ArrayList<>();
        try {
            String strSelect = "SELECT Distinct  a.Rap_Chieu_Id, a.Ten, a.Dia_chi,a.So_Dien_Thoai, a.Anh \n"
                    + "                    from Rap_chieu a join Phong_Chieu b on a.Rap_Chieu_Id = b.Rap_Chieu_id\n"
                    + "               join Lich_Chieu c on b.Phong_Chieu_Id =c.Phong_Chieu_Id Where Phim_Id =?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, movieId);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                String phone = rs.getString(4);
                String image = rs.getString(5);

                data.add(new Cinema(id, name, address, phone, image));
            }
        } catch (SQLException e) {
            System.out.println("getListCinema: " + e.getMessage());

        }
        return data;

    }

   public ArrayList<Cinema> getInfoCinema(String cinemaId) {
        ArrayList<Cinema> data = new ArrayList<>();
        try {

            String strQuery = "select * from Rap_chieu where Rap_Chieu_Id =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, cinemaId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(2);
                String anh = rs.getString(4);

                data.add(new Cinema(ten,anh));
            }

        } catch (Exception e) {
            System.out.println("infoCinema:" + e.getMessage());
        }
        return data;
    }

  
}
