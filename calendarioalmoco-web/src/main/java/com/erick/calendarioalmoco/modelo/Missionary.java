package com.erick.calendarioalmoco.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "missionary")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@DiscriminatorValue(value = "Missionary")
public class Missionary extends User {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "double_missionary_id", referencedColumnName = "double_missionary_id")
	private DoubleMissionary doubleMissionary;
	
	public Missionary(){
		super();
		super.userType = UserType.MISSIONARY;
	}
}
