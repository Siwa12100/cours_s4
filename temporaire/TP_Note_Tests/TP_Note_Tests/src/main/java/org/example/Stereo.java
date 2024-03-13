package org.example;// package tetepremiere.commande.groupe;

public class Stereo {
	String localisation;

	int volume;


	boolean isOn;


	public Stereo(String location) {
		this.localisation = location;
	}


	public void marche() {
		System.out.println(localisation + ": stéréo allumée");
		isOn = true;
	}

	public void arret() {
		System.out.println(localisation + ": stéréo éteinte");
		isOn = false;
	}

	public void setCD() {
		System.out.println(localisation + ": stéréo réglée pour l'entrée CD");
	}

	public void setDVD() {
		System.out.println(localisation + ": stéréo réglée pour l'entrée DVD");
	}

	public void setRadio() {
		System.out.println(localisation + ": stéréo réglée pour la radio");
	}

	/**	méthodes non testables  **/

	public void setVolume(int volume) {

		if(volume < 1) {
			volume = 1;
		}
		else if(volume > 11) {
			volume = 11;
		}

		this.volume = volume;
		// code pour positionner le volume
		// plage valide: 1-11 (aprs tout, 11 c'est mieux que 10, non ?)
		System.out.println(localisation + ": le volume stéréo est " + volume);
	}

	public int getVolume() {
		return volume;
	}

	public String getLocalisation() {
		return localisation;
	}

	public boolean isOn() {
		return isOn;
	}
}
