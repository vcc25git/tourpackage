package com.mycompany.tourpackage.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tour_package")
public class TourPackage implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tour_id")
	private Long id;
	
	@Size(min=4)
	@Column(name = "tourname")
	private String tourname;
	
	  @OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name = "tour_detail_id")
	  //  @Transient
	    private TourDetail tourDetail;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTourname() {
		return tourname;
	}

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	@Column(name= "cat_Id",nullable=false)
	private int catId;

}
