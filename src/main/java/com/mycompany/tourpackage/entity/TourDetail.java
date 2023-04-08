package com.mycompany.tourpackage.entity;



import javax.persistence.*;


	@Entity
	@Table(name = "tour_detail")
	public class TourDetail
	{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "tour_detail_id")
	    private Long id;

	    private String description;
	    private int price;

	    public TourDetail()
	    {
	    }

	    public TourDetail(String description, int price)
	    {
	        this.description = description;
	        this.price = price;
	    }

	    public Long getId()
	    {
	        return id;
	    }

	    public void setId(Long id)
	    {
	        this.id = id;
	    }

	    public String getDescription()
	    {
	        return description;
	    }

	    public void setDescription(String description)
	    {
	        this.description = description;
	    }

	    public int getPrice()
	    {
	        return price;
	    }

	    public void setPrice(int price)
	    {
	        this.price = price;
	    }
	}
