package org.example;// package tetepremiere.commande.groupe;

public class CommandeVentilateurRapide implements Commande {
	Ventilateur ventilateur;
	int derniereVitesse;

	public CommandeVentilateurRapide(Ventilateur ventilateur) {
		this.ventilateur = ventilateur;
	}
	public void executer() {
		derniereVitesse = ventilateur.getVitesse();
		ventilateur.rapide();
	}
	public void annuler() {
		switch (derniereVitesse) {
			case Ventilateur.RAPIDE: 	ventilateur.rapide(); break;
			case Ventilateur.MOYEN: ventilateur.moyen(); break;
			case Ventilateur.LENT: 	ventilateur.lent(); break;
			default: 				ventilateur.arreter(); break;
		}
	}

	public int getDerniereVitesse() {
		return derniereVitesse;
	}

	public void setDerniereVitesse(int vitesse) {
		if(vitesse < 0 || vitesse > 3) {
			throw new IllegalArgumentException("La vitesse doit être comprise entre 0 et 3");
		}

		this.derniereVitesse = vitesse;
	}
}
