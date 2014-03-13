package fr.istic.m1miage.nosql;

import java.net.UnknownHostException;
import java.util.Collection;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
@SuppressWarnings("deprecation")
public class App 
{

	public static void main( String[] args ) throws UnknownHostException
	{

		Morphia morphia = new Morphia();   

		Mongo mongo = new Mongo();

		morphia.map(Person.class).map(Address.class);
		morphia.map(Article.class).map(Person.class);

		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person p1 = new Person();
		p1.setName("Lecoq");
		
		Person p2 = new Person();
		p2.setName("Hafsi");
		
		Person p3 = new Person();
		p3.setName("Jean");

		Address a1 = new Address();
		a1.setStreet("32 rue Mirabeau");
		a1.setCity("Rennes");
		a1.setPostCode("35700");
		a1.setCountry("France");
		
		Address a2 = new Address();
		a2.setStreet("12 rue des Corsaires");
		a2.setCity("Damgan");
		a2.setPostCode("44700");
		a2.setCountry("France");
		
		Address a3 = new Address();
		a3.setStreet("10 rue des Martyres");
		a3.setCity("St Lunaire");
		a3.setPostCode("35892");
		a3.setCountry("France");
		
		Article ar1 = new Article();
		ar1.setName("TV Philips HD");
		ar1.setStars(5);
		
		Article ar2 = new Article();
		ar2.setName("Mug Lipton");
		ar2.setStars(4);
		
		Article ar3 = new Article();
		ar3.setName("Cafetiere Expresso");
		ar3.setStars(6);

		// Set address
		p1.addAddress(a1);
		p1.addAddress(a2);
		p2.addAddress(a3);
		p3.addAddress(a3);
		ar1.addAcheteur(p1);
		ar1.addAcheteur(p3);
		ar1.addAcheteur(p2);
		ar2.addAcheteur(p1);
		ar3.addAcheteur(p1);
		ar3.addAcheteur(p3);

		// Save the POJO
		ds.save(a1);
		ds.save(a2);
		ds.save(a3);
		ds.save(p1);
		ds.save(p2);
		ds.save(p3);
		ds.save(ar1);
		ds.save(ar2);
		ds.save(ar3);

		System.out.println("===============================");
		System.out.println("Personnes");
		System.out.println("===============================");

		for (Person e : ds.find(Person.class)) {
			System.out.println(e.toString());
		}
		
		System.out.println("===============================");
		System.out.println("Adresses");
		System.out.println("===============================");

		for (Address a : ds.find(Address.class)) {
			System.out.println(a.toString());
		}
		
		System.out.println("===============================");
		System.out.println("Articles");
		System.out.println("===============================");

		for (Article ar : ds.find(Article.class)) {
			System.out.println(ar.toString());
		}
	}
}
