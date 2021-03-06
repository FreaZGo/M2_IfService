package fr.uge.sw.banque;

public class Compte {
	private int solde = 0;

	public void depotDe(int depot) {
		if (depot < 0) {
			throw new IllegalArgumentException("Depot doit être > 0.");
		}

		this.solde = this.solde + depot;
	}

	public boolean retraitDe(int retrait) {
		if (retrait < 0) {
			throw new IllegalArgumentException("Retrait doit être > 0.");
		}

		if (retrait > solde) {
			return false;
		}

		this.solde = this.solde - retrait;

		return true;
	}
	
	public int valeurDuSolde() {
		return this.solde;
	}
}
