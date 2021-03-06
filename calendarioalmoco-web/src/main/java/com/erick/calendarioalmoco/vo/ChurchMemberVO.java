package com.erick.calendarioalmoco.vo;

public class ChurchMemberVO {

	private Long userId;

	private String name;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;

	private String phone;
	
	private String phone2;
	
	private FamilyVO familyVO;
	
	public ChurchMemberVO(){
		this.familyVO = new FamilyVO();
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}	

	/**
	 * @return the familyVO
	 */
	public FamilyVO getFamilyVO() {
		return familyVO;
	}

	/**
	 * @param familyVO the familyVO to set
	 */
	public void setFamilyVO(FamilyVO familyVO) {
		this.familyVO = familyVO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChurchMemberVO [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", phone=" + phone + ", phone2=" + phone2 + "]";
	}
}
