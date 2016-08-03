package com.training.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLConnection {

  public static Connection getMyOracleConnection() {

    Connection con = null;

    try {

      Properties props = new Properties();

      FileInputStream inStream = new FileInputStream(new File("DbConnection.properties"));

      props.load(inStream);

      Class.forName(props.getProperty("db.driverClass"));

      con = DriverManager.getConnection(props.getProperty("db.driverURL"), props.getProperty("db.userName"),
          props.getProperty("db.password"));

    } catch (Exception e) {
      e.printStackTrace();
    }

    return con;
  }

  public static void main(String[] args) {

    getMyOracleConnection();

  }

}
