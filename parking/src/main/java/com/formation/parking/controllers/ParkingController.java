package com.formation.parking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.parking.models.Parking;

//Ici on indique à Springboot que c'est un controller rest CQFD. On indique que cette classe est un composant qui doit
// être injecté et qu'on a une URI Parking qui pointe sur cette méthode Java
@RestController
public class ParkingController {
	
	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	// premier paramètre, chemin de l'URI ici /api/parkings, second ici on peut lui indiquer la méthode qu'on souhaite utiliser
	// sur cette URI . Si on fait un POST sur cette URL là le serveur ne répondra rien. donc uniquement du get ici.
	public List<Parking> getListeParkings(){
		Parking parkingTest = new Parking();
		parkingTest.setNom("parking de test");
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatut("OUVERT");
		parkingTest.setHeureMaj("20h15");
		ArrayList<Parking> liste = new ArrayList<Parking>();
		liste.add(parkingTest);
		return liste;
	}

}
