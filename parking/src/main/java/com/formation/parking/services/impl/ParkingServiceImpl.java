package com.formation.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ReponseParkingAPIEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

//On déclare un composant de type service ici
// Ca permet de dire que la classe ParkingServiceImpl est un composant injectable dans une autre classe 
// en l'occurence on va vouloir l'injecter dans la classe controller 
@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	public ParkingAPIDAO parkingAPIDAO; 

	@Override
	public List<Parking> getListeParkings() {
		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
		return transformEntityToModel(reponse);
	}

	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		//pour chaque record on va récupérer les fields et pour chaque record on va créer un nouvel objet Parking
		// à la fin on ajoute le parking dans le résultat mais avant on fait le mappage
		for(RecordEntity record : reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatut(getLibelleStatut(record));
			parking.setNbPlacesDispo(record.getFields().getGrpDisponible());
			parking.setNbPlacesTotal(record.getFields().getGrpExploitation());
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		return resultat;
	}

	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
	}

	private String getLibelleStatut(RecordEntity record) {
		switch(record.getFields().getGrpStatut()) {
		case "1" : {
			return "Le parking est fermé";
		}
		case "2": {
			return "Le parking est réservé aux abonné.e.s.";
		}
		case "5": {
			return "Le parking est ouvert";
		}
		}
		return "Données non disponibles";
	}

}
