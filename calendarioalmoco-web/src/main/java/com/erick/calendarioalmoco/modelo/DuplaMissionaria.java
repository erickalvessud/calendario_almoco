package com.erick.calendarioalmoco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "dupla_missionaria")
@DiscriminatorValue(value = "D")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class DuplaMissionaria extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
}
