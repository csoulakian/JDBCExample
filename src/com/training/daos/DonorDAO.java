package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.domain.Donor;
import com.training.domain.Project;
import com.training.ifaces.MyDAO;
import com.training.utils.MySQLConnection;

public class DonorDAO implements MyDAO<Donor> {

  private Connection con = null;

  /**
   * 
   */
  public DonorDAO() {
    super();
    con = MySQLConnection.getMyOracleConnection();
  }

  /**
   * @param con
   */
  public DonorDAO(Connection con) {
    super();
    this.con = con;
  }

  @Override
  public int add(Donor object) {

    int rowAdded = 0;

    String sqlAdd = "insert into donor values(?, ?, ?, ?, ?)";

    try {

      PreparedStatement pstmt = con.prepareStatement(sqlAdd);

      pstmt.setInt(1, object.getDonorID());
      pstmt.setString(2, object.getDonorName());
      pstmt.setString(3, object.getEmail());
      pstmt.setString(4, object.getSelectedProject().getName());
      pstmt.setDouble(5, object.getAmountDonated());

      rowAdded = pstmt.executeUpdate();
      // con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return rowAdded;
  }

  @Override
  public int delete(int donorID) {

    int rowDeleted = 0;
    try {

      PreparedStatement ps = con.prepareStatement("Delete from donor where donorid = ?");
      ps.setInt(1, donorID);
      rowDeleted = ps.executeUpdate();
      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rowDeleted;
  }

  @Override
  public Donor find(int donorID) {

    Donor donor = new Donor();
    Project selectedProject = new Project();

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor where donorid = " + donorID);

      while (rs.next()) {
        donor.setDonorID(rs.getInt("donorid"));
        donor.setDonorName(rs.getString("donorname"));
        donor.setEmail(rs.getString("email"));
        selectedProject.setName(rs.getString("selectedproject"));
        donor.setSelectedProject(selectedProject);
        donor.donate(rs.getInt("amountdonated"));
      }

      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return donor;
  }

  @Override
  public int update(int donorID, int newAmountDonated) {

    int rowUpdated = 0;

    try {

      Statement s = (Statement) con.createStatement();

      rowUpdated = s.executeUpdate("update donor set amountdonated = " + 
          newAmountDonated + " where donorid = " + donorID);
      System.out.println("updated");

      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return rowUpdated;
  }

  @Override
  public List<Donor> findAll() {

    List<Donor> allDonors = new ArrayList<Donor>();

    try {

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from donor");

      while (rs.next()) {
        Donor donor = new Donor();
        Project selectedProject = new Project();

        donor.setDonorID(rs.getInt("donorid"));
        donor.setDonorName(rs.getString("donorname"));
        donor.setEmail(rs.getString("email"));
        selectedProject.setName(rs.getString("selectedproject"));
        donor.setSelectedProject(selectedProject);
        donor.donate(rs.getInt("amountdonated"));

        allDonors.add(donor);
      }

      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return allDonors;
  }

}
