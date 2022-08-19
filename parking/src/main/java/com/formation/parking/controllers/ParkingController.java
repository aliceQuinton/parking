package com.formation.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

//Ici on indique à Springboot que c'est un controller rest CQFD. On indique que cette classe est un composant qui doit
// être injecté et qu'on a une URI Parking qui pointe sur cette méthode Java
@RestController
public class ParkingController {
	
	// Ici on appelle la couche service 
	// donc on injecte un parkingService dans le controller 
	// On créée donc une variable parkingService en privée pour la bonne pratique de sécurité 
	// Autowired laisse spring gérer l'injection de dépendances : lorsque spring va initialiser la classe controller
	// il va rechercher un bean de type parking service et en instancier un s'il n'y a pas de bean et le mettre en bas
	// ça evite les NPE pour la méthode getListeParkings
	@Autowired
	private ParkingService parkingService;
	
	//annotation qui autorise la communication avec localhost 4200
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	// premier paramètre, chemin de l'URI ici /api/parkings, second ici on peut lui indiquer la méthode qu'on souhaite utiliser
	// sur cette URI . Si on fait un POST sur cette URL là le serveur ne répondra rien. donc uniquement du get ici.
	public List<Parking> getListeParkings(){
		return parkingService.getListeParkings();
		//on appelle la variable créée au dessus ici dans la méthode getListeParkings() ici
	}

}
