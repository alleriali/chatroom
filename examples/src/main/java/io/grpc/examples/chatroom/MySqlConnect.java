package io.grpc.examples.chatroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import java.util.*;


public class MySqlConnect{
    Connection conn;

    public MySqlConnect(final Logger logger){
        try{
            logger.info("class for com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println(e);
        }
        conn = null;
        try {
            logger.info("Connect to mysql");
            String url = "jdbc:mysql://localhost:3306/chatroom";
            conn = DriverManager.getConnection(url,"demo_java","Java123!");
            logger.info("Successfully connected to mysql");

            System.out.println("Connected to MYSQL DB");

        } catch (SQLException e) {
            System.out.println("Problem! failed to connect to MYSQL DB!");
            throw new Error("Problem", e);
        }
    }

    public boolean findUsername(String username){
        String query = "select * from Users where username = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insertToDB(String username, String password){
        String sql = "insert into Users (username,password)  values(?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            int rowCount = statement.executeUpdate();
            if (rowCount == 1) {
                System.out.println("One record successfully added into database!");
            } else {
                System.out.println("failed adding into database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addUsername(String username){
        String sql = "insert into Users (username) values(?)";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            int rowCount = statement.executeUpdate();
            if (rowCount == 1) {
                System.out.println("One username successfully added into database!");
            } else {
                System.out.println("failed adding the username into database!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    public boolean findUser(String username, String password){
        String query = "select * from Users where username =? and password =?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void storeMessage(int id, String message, String username, String date_time){
        String sql = "insert into Log(id,username,date_time,message) values(?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, date_time);
            statement.setString(4, message);
            int rowCount = statement.executeUpdate();
            if (rowCount == 1) {
                System.out.println("One record successfully added into database!");
            } else {
                System.out.println("failed adding into database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getId(){
        String sql = "select max(id) from Log";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
