/**
 * 
 */
package com.cg.obs.model;

/**
 * @author sohel
 *
 */
public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String contactNo;
	private String adhaarNo;
	private String panNo;
	private String occupation;
	private String email;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String firstName, String lastName, String addressLine1, String addressLine2, String city,
			String contactNo, String adhaarNo, String panNo, String occupation, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.contactNo = contactNo;
		this.adhaarNo = adhaarNo;
		this.panNo = panNo;
		this.occupation = occupation;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", contactNo=" + contactNo
				+ ", adhaarNo=" + adhaarNo + ", panNo=" + panNo + ", occupation=" + occupation + ", email=" + email
				+ "]";
	}

}
