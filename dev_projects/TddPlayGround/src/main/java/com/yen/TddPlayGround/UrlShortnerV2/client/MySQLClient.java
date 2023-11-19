//package com.yen.TddPlayGround.UrlShortnerV2.client;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class MySQLClient {
//
//    // attr
//    Connection connection;
//    private String JDBC_URL = "";
//    private String USER = "";
//    private String PASSWORD = "";
//
//    private int PORT = 3306;
//
//    // constructor
//    public MySQLClient(){
//
//        getConn();
//    }
//
//    // method
//    private void getConn(){
//        Connection _connection = null;
//        try{
//            _connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//            connection = _connection;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public ResultSet runQuery(String query){
//        try{
//            Statement statement = this.connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            return resultSet;
//        }
//        catch (SQLException e){
//            return null;
//        }
//    }
//
//}
//
