package com.training.domain;

import java.util.ArrayList;

/**
 * A class called Project contains all the functionality of any type of project.
 * Concrete classes that extend Project are CancerCure, PrimaryEducation, and
 * OldAgeHome.
 * 
 * @author csoulakian
 *
 */
public class Project {

  /**
   * name of project
   */
  public String name;
  /**
   * description of project
   */
  public String description;
  /**
   * status of project - "funded" or "not funded"
   */
  public String status;
  /**
   * array of image URLs
   */
  public String[] images = new String[0];
  /**
   * cost of project
   */
  public double cost;
  /**
   * amount collected in donations for a project
   */
  public double amountCollected;
  /**
   * amount left to be collected
   */
  public double pendingAmount;
  /**
   * array list of donors that have contributed towards a project
   */
  public ArrayList<Donor> listOfDonors = new ArrayList<Donor>();

  /**
   * Constructor with no arguments.
   */
  public Project() {
    super();
    setAmountCollected(0);
    calcStatus();
  }

  /**
   * Constructor with field arguments.
   * 
   * @param name
   *          of project
   * @param description
   *          of project
   * @param cost
   *          total cost of project
   */
  public Project(String name, String description, double cost) {
    super();
    this.name = name;
    this.description = description;
    this.cost = cost;
    setAmountCollected(0);
    calcStatus();
  }

  /**
   * Get the name of the project.
   * 
   * @return name of project
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set the name of the project.
   * 
   * @param name
   *          of project
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the description of the project.
   * 
   * @return description of project
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the project.
   * 
   * @param description
   *          of project
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get the status of project - "funded" or "not funded"
   * 
   * @return status of project
   */
  public String getStatus() {
    return status;
  }

  /**
   * Calculate the status of the project. If the pending amount is 0 and the
   * cost of the project has already been set (ensuring an accurate pending
   * amount), set the status to "funded". Otherwise, the project is
   * "not funded."
   */
  public void calcStatus() {
    if (getPendingAmount() == 0 && cost > 0) {
      status = "funded";
    } else {
      status = "not funded";
    }
  }

  /**
   * Get the string array of image URLs.
   * 
   * @return string array of images
   */
  public String[] getImages() {
    return images;
  }

  /**
   * Set the string array of images.
   * 
   * @param images
   *          array of image URLs
   */
  public void setImages(String[] images) {
    this.images = images;
  }

  /**
   * Get the cost of the project.
   * 
   * @return cost of project
   */
  public double getCost() {
    return cost;
  }

  /**
   * Set the cost of the project.
   * 
   * @param cost
   *          of project
   */
  public void setCost(double cost) {
    this.cost = cost;
  }

  /**
   * Get the total amount collected for a project.
   * 
   * @return amount collected
   */
  public double getAmountCollected() {
    return amountCollected;
  }

  /**
   * Set the amount collected by taking in a single donation.
   * 
   * @param amountCollected
   *          from a donation
   */
  public void setAmountCollected(double amountCollected) {
    this.amountCollected = amountCollected;
    calcStatus();
  }

  /**
   * Get the pending amount, the amount waiting to be collected.
   * 
   * @return pending amount
   */
  public double getPendingAmount() {
    calcPendingAmount();
    return pendingAmount;
  }

  /**
   * Calculate the pending amount, which is the cost minus the total amount
   * collected for a project.
   */
  public void calcPendingAmount() {
    pendingAmount = cost - amountCollected;
  }

  /**
   * Get the array list of donors for a project.
   * 
   * @return array list of donors
   */
  private ArrayList<Donor> getListOfDonors() {
    return listOfDonors;
  }

  /**
   * Add a donor to the array list of donors.
   * 
   * @param donor
   *          to be added
   */
  public void addDonor(Donor donor) {
    listOfDonors.add(donor);
  }

  /**
   * Return the project details as a StringBuilder.
   * 
   * @return StringBuilder of project details
   */
  public StringBuilder getProjectDetails() {
    StringBuilder details = new StringBuilder();
    details.append("Project: " + getName() + "\nDescription: " + getDescription() + "\nCost: $" + getCost());
    details.append("  Amount Collected: $" + getAmountCollected() + "\nPending Amount: $" + getPendingAmount());
    details.append("  Status: " + getStatus() + "\nImages: ");
    if (getImages().length > 0) {
      for (String image : getImages()) {
        details.append(image + "\n");
      }
    } else {
      details.append("none");
    }
    details.append("\n");
    return details;
  }

}
