package fr.istic.m1miage.nosql;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("article")
public class Article {

	@Id ObjectId id;
	String name;
	int stars;
	@Reference Collection<Person> acheteurs = new ArrayList<Person>();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public void addAcheteur(Person acheteur) {
		this.acheteurs.add(acheteur);
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String result = this.id.toString()+" / "+this.name + " " + this.stars + " étoiles a été acheté par :";
		for(Person p : this.acheteurs) {
			result += "\n- "+p.toString(); 
		}
		return result;
	}
	
	

}
