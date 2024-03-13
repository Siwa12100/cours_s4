package org.example;// package tetepremiere.commande.groupe;

public class TV {
	String localisation;
	int canal;

	boolean on;

	public TV(String location) {
		this.localisation = location;
		on = true;
	}

	public void marche() {
		System.out.println(localisation + ": la télé est allumée");
		on = true;
	}

	public void arret() {

		System.out.println(localisation + ": la télé est éteinte");
		on = false;
	}

	public void selectionnerCanal() {
		this.canal = 3;
		System.out.println(localisation + ": le canal est positionné sur VCR");
	}


	public int getCanal() {
		return canal;
	}

	public String getLocalisation() {
		return localisation;
	}

	public boolean isOn() {
		return on;
	}
}
