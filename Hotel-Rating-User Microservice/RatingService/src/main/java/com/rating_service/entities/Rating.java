package com.rating_service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedBack;
	
	//private Hotel hotel;

}
