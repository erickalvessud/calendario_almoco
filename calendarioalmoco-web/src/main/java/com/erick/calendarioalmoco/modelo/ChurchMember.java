package com.erick.calendarioalmoco.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "church_member")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@DiscriminatorValue(value = "ChurchMember")
public class ChurchMember extends User {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "family_id", referencedColumnName = "family_id")
	private Family family;
	
	public ChurchMember(){
		super();
		super.userType = UserType.CHURCH_MEMBER;
	}
}
