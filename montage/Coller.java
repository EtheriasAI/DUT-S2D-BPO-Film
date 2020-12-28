package montage;

import film.Film;

/*
 * implementation de l'interface film
 * pour pouvoir coller un film a la suite d'un film
 */
public class Coller implements Film{

	private Film firstfilm;		//premier film
	private Film secondfilm;	//deuxieme film qui sera apres le premier
	private int i =0;
	
	/*
	 * @param Film a le premier film
	 * @param Film b le deuxieme film
	 */
	public Coller(Film a,Film b) {
		this.firstfilm = a;
		this.secondfilm = b;
	}

	/*
	 * @return la hauteur du film le plus haut
	 * pour prendre en compte la hauteur des 2 films
	 */
	@Override
	public int hauteur() {
		if(firstfilm.hauteur()>secondfilm.hauteur())
			return firstfilm.hauteur();
		else
			return secondfilm.hauteur();
	}

	/*
	 * @return la largeur du film le plus large
	 * pour prendre en compte la largeur des 2 films
	 */
	@Override
	public int largeur() {
		if(firstfilm.largeur()>secondfilm.largeur())
			return firstfilm.largeur();
		else
			return secondfilm.largeur();
	}

	/*
	 * @return true si le deuxieme film n'est pas fini
	 * @return false si le deuxieme film est fini
	 * colle les deux films
	 */
	@Override
	public boolean suivante(char[][] écran) {
		
		if(!firstfilm.suivante(écran)) {
			if(i<1) {
				i=1;
				secondfilm.rembobiner();
			}
			if(!secondfilm.suivante(écran))
				return false;
		}
			
		return true;
	}

	/*
	 * rembobine les deux films
	 */
	@Override
	public void rembobiner() {
		firstfilm.rembobiner();
		secondfilm.rembobiner();
	}
	
}
