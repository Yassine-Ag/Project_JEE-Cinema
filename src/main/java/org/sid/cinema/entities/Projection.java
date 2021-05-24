package org.sid.cinema.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
@ToString

public class Projection {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Date dateProjection;
	private double prix;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Salle salle;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Film film;

	@OneToMany(mappedBy = "projection")
	private Collection<Ticket> tickets;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Seance seance;
	
	

}
