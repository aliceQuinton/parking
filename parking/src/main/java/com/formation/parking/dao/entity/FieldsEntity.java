package com.formation.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldsEntity {

	@JsonProperty( value ="idobj")
	private String idObj;
	
	@JsonProperty( value ="grp_nom")
	private String grpNom;
	
	@JsonProperty( value ="grp_exploitation")
	private String grpExploitation;
	
	@JsonProperty( value ="grp_disponible")
	private String grpDisponible;
	
	@JsonProperty( value ="grp_statut")
	private String grpStatut;
	
	@JsonProperty( value ="grp_horodatage")
	private String grpHorodatage;

	public String getIdObj() {
		return idObj;
	}

	public void setIdObj(String idObj) {
		this.idObj = idObj;
	}

	public String getGrpNom() {
		return grpNom;
	}

	public void setGrpNom(String grpNom) {
		this.grpNom = grpNom;
	}

	public String getGrpExploitation() {
		return grpExploitation;
	}

	public void setGrpExploitation(String grpExploitation) {
		this.grpExploitation = grpExploitation;
	}

	public String getGrpDisponible() {
		return grpDisponible;
	}

	public void setGrpDisponible(String grpDisponible) {
		this.grpDisponible = grpDisponible;
	}

	public String getGrpStatut() {
		return grpStatut;
	}

	public void setGrpStatut(String grpStatut) {
		this.grpStatut = grpStatut;
	}

	public String getGrpHorodatage() {
		return grpHorodatage;
	}

	public void setGrpHorodatage(String grpHorodatage) {
		this.grpHorodatage = grpHorodatage;
	}
	
	
	
}
