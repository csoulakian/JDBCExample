package com.training.apps;

import java.util.List;

import com.training.daos.DonorDAO;
import com.training.domain.Donor;
import com.training.domain.Project;
import com.training.utils.MySQLConnection;

public class Application {

  public static void main(String[] args) {

    System.out.println(MySQLConnection.getMyOracleConnection());

    DonorDAO dao = new DonorDAO();
    int key = 5;
    switch (key) {
    case 1:
      int rowAdded = dao.add(new Donor(101, "Rajesh", "raj@abc.com", 
          new Project("CancerCure", "desc", 50000), 175));
      rowAdded += dao.add(new Donor(102, "Ramesh", "ram@abc.com", 
          new Project("CancerCure", "desc", 10000), 8900));
      rowAdded += dao.add(new Donor(103, "Rakesh", "rak@abc.com", 
          new Project("PrimaryEducation", "desc", 10000), 8900));
      rowAdded += dao.add(new Donor(104, "Chrissy", "Chrissy@abc.com", 
          new Project("OldAgeHome", "desc", 6000), 500));
      System.out.println("Row[s] Added :=" + rowAdded);
      break;
    case 2:
      int rowDeleted = dao.delete(103);
      System.out.println("Row[s] Deleted :=" + rowDeleted);
      break;
    case 3:
      Donor foundDonor = dao.find(101);
      System.out.println(foundDonor.getDonorDetails());
      break;
    case 4:
      int rowUpdated = dao.update(101, 80);
      System.out.println("Row[s] Updated :=" + rowUpdated);
      break;
    case 5:
      List<Donor> listOfAllDonors = dao.findAll();
      for (Donor donor : listOfAllDonors) {
        System.out.println(donor.getDonorDetails());
      }
      break;
    default:
      break;
    }

  }

}
