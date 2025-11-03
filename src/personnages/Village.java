package personnages;

public class Village {
	private static final int NB_VILLAGEOIS_MAX = 30;
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	private int nbVillageois = 0;

	public Village(String nom, Gaulois chef) {
		this.nom = nom;
		this.chef = chef;

	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois++] = gaulois;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= nbVillageois) {
			return villageois[numVillageois - 1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \" " + nom + "\" du chef " + chef + " vivent les légendaires Gaulois :");
		for (Gaulois habitantDuVillage : villageois) {
			if (habitantDuVillage != null) {
				System.out.println("- " + habitantDuVillage);
			}
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();

		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		obelix.sePresenter();
		doublePolemix.sePresenter();

	}
}
