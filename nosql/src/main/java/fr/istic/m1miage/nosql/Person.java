package fr.istic.m1miage.nosql;
import java.util.ArrayList;
import java.util.Collection;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("person")
public class Person {

	@Id ObjectId id;
	String name;
	@Reference Collection<Address> addresses = new ArrayList<Address>();

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public String toString() {
		String result = this.name+" habite :\n";
		for(Address a : this.addresses) {
			result += "- "+a.toString()+"\n"; 
		}
		return result;
	}

}
