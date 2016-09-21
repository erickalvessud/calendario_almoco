package com.erick.calendarioalmoco.modelo;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "church_member")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@DiscriminatorValue(value = "ChurchMember")
public class ChurchMember extends User {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = true)
	private Family family;
	
	public ChurchMember(){
		super();
		super.userType = UserType.CHURCH_MEMBER;
	}

	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}
}
