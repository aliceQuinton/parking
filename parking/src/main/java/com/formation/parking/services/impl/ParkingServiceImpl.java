package com.formation.parking.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

//On déclare un composant de type service ici
// Ca permet de dire que la classe ParkingServiceImpl est un composant injectable dans une autre classe 
// en l'occurence on va vouloir l'injecter dans la classe controller 
@Service
public class ParkingServiceImpl implements ParkingService {

	@Override
	public List<Parking> getListeParkings() {
		Parking parkingTest = new Parking(); 
		parkingTest.setNom("parking de test");
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatut("FERME");
		parkingTest.setHeureMaj("20h15");
		ArrayList<Parking> liste = new ArrayList<Parking>();
		liste.add(parkingTest);
		return liste;
	}

}
