package fr.mns.java.rest.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serilisa {
	public static void serialise(Person p) {

		FileOutputStream f = null;
		ObjectOutputStream s = null;
		try {
			f = new FileOutputStream("person.obj");
			s = new ObjectOutputStream(f);
			s.writeObject(p);
			s.flush();
		} catch (IOException e) {
			System.out.println(" Probleme IO");
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Person deserialise() {

		Person p = null;
		try {
			FileInputStream f = new FileInputStream("Fichier.obj");
			ObjectInputStream s = new ObjectInputStream(f);
			p = (Person) s.readObject();
		} catch (IOException e) {
			System.out.println("Nouveau Fichier");
		} catch (ClassNotFoundException e) {
			System.out.println("probleme");
		}finally {
			//closes s and f
		}

		return p;
	}

}
