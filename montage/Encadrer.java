package montage;

import film.Film;

/*
 * implementation de l'interface film
 * pour pouvoir encardrer un film
 */
public class Encadrer implements Film{

	private Film firstfilm;		//le film a encadrer
	//nombre d'etoiles de lencadrement
	private static final int NB_ETOILES = 1;
	
	/*
	 * @param Film a
	 * 			le film a encadrer
	 */
	public Encadrer(Film a) {
		this.firstfilm = a;
		
	}

	/*
	 * @return la hauteur du film encadrer
	 */
	@Override
	public int hauteur() {
		return firstfilm.hauteur()+NB_ETOILES*2;
	}

	/*
	 * @return la largeur du film encadrer
	 */
	@Override
	public int largeur() {
		return firstfilm.largeur()+NB_ETOILES*2;
	}

	/*
	 * @return true si le film n'est pas fini
	 * @return false si le film est fini
	 * encadre le film
	 */
	@Override
	public boolean suivante(char[][] écran) {
		if(!firstfilm.suivante(écran))
			return false;
		//on utilise un autre tableau
		char ecran [][] = new char [this.hauteur()][this.largeur()];
		for (int i =0; i < this.hauteur();i++)
			for (int j =0; j < this.largeur();j++)
				ecran[i][j]='*';
			
		for (int i =0; i < firstfilm.hauteur();i++)
			for (int j =0; j < firstfilm.largeur();j++)
				ecran[i+NB_ETOILES][j+NB_ETOILES] = écran[i][j];
		
		
		for (int i =0; i < this.hauteur();i++)
			for (int j =0; j < this.largeur();j++)
				écran[i][j] = ecran[i][j];
		
		return true;
	}

	/*
	 * rembobiner le film
	 */
	@Override
	public void rembobiner() {
		firstfilm.rembobiner();
	}
	
}
