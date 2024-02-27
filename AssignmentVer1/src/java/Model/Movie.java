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
public class Movie {

    String phimId, ten, thoiLuong, gioiHanTuoi, ngayCongChieu, dienVien, theLoai, tomTat, daoDien, image, imageTimeLine, video;

    public Movie() {
        connect();
    }

    public Movie(String phimId, String ten, String thoiLuong, String gioiHanTuoi, String ngayCongChieu, String dienVien, String theLoai, String tomTat, String daoDien, String image, String imageTimeLine, String video) {
        this.phimId = phimId;
        this.ten = ten;
        this.thoiLuong = thoiLuong;
        this.gioiHanTuoi = gioiHanTuoi;
        this.ngayCongChieu = ngayCongChieu;
        this.dienVien = dienVien;
        this.theLoai = theLoai;
        this.tomTat = tomTat;
        this.daoDien = daoDien;
        this.image = image;
        this.imageTimeLine = imageTimeLine;
        this.video = video;
        connect();
    }

    public String getPhimId() {
        return phimId;
    }

    public void setPhimId(String phimId) {
        this.phimId = phimId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getGioiHanTuoi() {
        return gioiHanTuoi;
    }

    public void setGioiHanTuoi(String gioiHanTuoi) {
        this.gioiHanTuoi = gioiHanTuoi;
    }

    public String getNgayCongChieu() {
        return ngayCongChieu;
    }

    public void setNgayCongChieu(String ngayCongChieu) {
        this.ngayCongChieu = ngayCongChieu;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageTimeLine() {
        return imageTimeLine;
    }

    public void setImageTimeLine(String imageTimeLine) {
        this.imageTimeLine = imageTimeLine;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Movie(String ten, String image) {
        this.ten = ten;
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

    public ArrayList<Movie> getListMovie() {
        ArrayList<Movie> data = new ArrayList<>();
        try {
            String strSelect = "select * from Phim";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String phimId = rs.getString(1);
                String ten = rs.getString(2);
                String thoiLuong = rs.getString(3);
                String gioiHanTuoi = rs.getString(4);

                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

                String ngayCongChieu = "";
                if (rs.getDate(5) != null) {
                    ngayCongChieu = f.format(rs.getDate(5));
                }
                String dienVien = rs.getString(6);
                String theLoai = rs.getString(7);
                String tomTat = rs.getString(8);
                String daoDien = rs.getString(9);
                String image = rs.getString(10);
                String imageTimeline = rs.getString(12);
                String video = rs.getString(11);
                data.add(new Movie(phimId, ten, thoiLuong, gioiHanTuoi, ngayCongChieu, dienVien, theLoai, tomTat, daoDien, image, imageTimeline, video));
            }
        } catch (Exception e) {
            System.out.println("getListMovie: " + e.getMessage());

        }
        return data;
    }

    public ArrayList<Movie> searchMovie(ArrayList<Movie> list, String movieName) {
        ArrayList<Movie> data = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().contains(movieName.toUpperCase())) {
                System.out.println(list.get(i).getTen().contains(movieName.toUpperCase()));
                data.add(list.get(i));
            }

        }
        return data;
    }


    public ArrayList<Movie> getInfoMovie(String movieId) {
        ArrayList<Movie> data = new ArrayList<>();
        try {

            String strQuery = "select * from Phim Where Phim_id =? ";
            pstm = cnn.prepareStatement(strQuery);
            pstm.setString(1, movieId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(2);
                String anh = rs.getString(10);

                data.add(new Movie(ten, anh));
            }

        } catch (Exception e) {
            System.out.println("listSeat:" + e.getMessage());
        }
        return data;
    }

}
