package fr.istic.m1miage.nosql;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("address")
public class Address {
	
	@Id ObjectId id;
	String street;
	String city;
	String postCode;
	String country;

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return this.id.toString()+" / "+this.street + " " + this.city + " " + this.postCode + " " + this.country;
	}

}
