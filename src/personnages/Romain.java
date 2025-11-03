package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	private boolean forcePositive() {
		return force >= 0;
	}
	
	

	private boolean isInvariantVerified() {
		return forcePositive();
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	@Override
	public String toString() {
		return nom;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private void assertForceCoupPositif(int forceCoup) {
		assert forceCoup > 0;
	}
	
	private void assertForceDiminuee(int forceAvant, int forceActuelle) {
		assert forceAvant >= forceActuelle;
	}
	
	public void recevoirCoup(int forceCoup) {
		
		assertForceCoupPositif(forceCoup);

		int forceAvant = force;
		force -= forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		} else {
			parler("Aïe.");
		}

		assertForceDiminuee(forceAvant, force);
	}

	private void ajouterEquipement(Equipement objet) {
		equipement[nbEquipement++] = objet;
	}

	public void sEquiper(Equipement objet) {
		String presentation = "Le soldat " + nom;
		switch (nbEquipement) {
		case 2:
			System.out.println(presentation + " est déjà bien protégé !");
			break;
		case 1:
			if (equipement[0].equals(objet)) {
				System.out.println(presentation + " possède déjà un " + objet + " !");
			} else {
				ajouterEquipementVerbeux(objet, presentation);
			}
			break;
		case 0:
			ajouterEquipementVerbeux(objet, presentation);
			break;

		default:
			break;
		}
	}

	private void ajouterEquipementVerbeux(Equipement objet, String presentation) {
		System.out.println(presentation + " s'équipe avec un " + objet + ".");
		ajouterEquipement(objet);
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
