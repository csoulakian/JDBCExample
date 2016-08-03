package com.training.domain;

public class Donor {

  /**
   * ID for donor
   */
  private int donorID;
  /**
   * name of donor
   */
  private String donorName;
  /**
   * email of donor
   */
  private String email;
  /**
   * selected project to donate to
   */
  private Project selectedProject;
  /**
   * amount to donate
   */
  private double amountDonated;

  /**
   * empty constructor
   */
  public Donor() {
    super();
  }

  /**
   * Constructor that specifies fields.
   * 
   * @param donorID
   *          ID of donor
   * @param donorName
   *          name of donor
   * @param email
   *          address of donor
   * @param selectedProject
   *          selected project to donate to
   * @param amountDonated
   *          total amount a donor has donated to specific project
   */
  public Donor(int donorID, String donorName, String email, Project selectedProject, double amountDonated) {
    super();
    this.donorID = donorID;
    this.donorName = donorName;
    this.email = email;
    this.selectedProject = selectedProject;
    donate(amountDonated);
    selectedProject.addDonor(this);
  }

  /**
   * Get the ID of the donor.
   * 
   * @return ID of donor
   */
  public int getDonorID() {
    return donorID;
  }

  /**
   * Set the numerical ID of the donor.
   * 
   * @param donorID
   *          ID of donor
   */
  public void setDonorID(int donorID) {
    this.donorID = donorID;
  }

  /**
   * Get the name of the donor.
   * 
   * @return name of donor
   */
  public String getDonorName() {
    return donorName;
  }

  /**
   * Set the name of the donor.
   * 
   * @param donorName
   *          name of donor
   */
  public void setDonorName(String donorName) {
    this.donorName = donorName;
  }

  /**
   * Get the email address of the donor.
   * 
   * @return email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email address of the donor.
   * 
   * @param email
   *          address of donor
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get the selected project the donor wants to donate to.
   * 
   * @return selected project
   */
  public Project getSelectedProject() {
    return selectedProject;
  }

  /**
   * Set the selected project and add donor to that project's donor list.
   * 
   * @param selectedProject
   *          project donor wants to donate to
   */
  public void setSelectedProject(Project selectedProject) {
    this.selectedProject = selectedProject;
    selectedProject.addDonor(this);
  }

  /**
   * Get the total amount a donor has donated.
   * 
   * @return amount donated
   */
  public double getAmountDonated() {
    return amountDonated;
  }

  /**
   * Donate a specific amount to the selected project.
   * 
   * @param amountToDonate
   */
  public void donate(double amountToDonate) {
    selectedProject.setAmountCollected(selectedProject.getAmountCollected() + amountToDonate);
    amountDonated += amountToDonate;
  }

  /**
   * Get the details of the donor including the ID, name, amount donated,
   * selected project, and email address.
   * 
   * @return StringBuilder with all project details
   */
  public StringBuilder getDonorDetails() {
    StringBuilder details = new StringBuilder();
    details.append(getDonorID() + "  " + getDonorName() + "  $" + getAmountDonated());
    details.append("\nProject: " + getSelectedProject().getName() + "\n" + getEmail() + "\n");
    return details;
  }

}
