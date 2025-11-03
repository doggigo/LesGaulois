package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	public void sePresenter() {
		String presentation = "\"Bonjour, je m'appelle \"" + nom + "\". ";
		if (this.equals(village.getChef())) {
			parler(presentation + ". Je suis le chef du village \"" + village + "\".");
		} else if (this.village != null) {
			parler(presentation + ". J'habite le village \"" + village + "\".");
		} else {
			parler(presentation + "Je voyage de villages en villages.");
		}
		parler(presentation);
	};

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la machoire de " + nomRomain);
		int forceCoup = force * effetPotion / 3;
		if (effetPotion > 1) {
			effetPotion--;
		}

		romain.recevoirCoup(forceCoup);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

}
