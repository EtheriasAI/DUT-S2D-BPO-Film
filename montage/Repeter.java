package montage;

import film.Film;

/*
 * implementation de l'interface film
 * pour pouvoir repeter un nombre de fois donne
 * le film souhaiter
 */
public class Repeter implements Film{
	
	private Film myfilm;	//le film
	private int nbactu;		//nb de repetition actuelle
	private int nbtotal;	//nb de repetition demander
	
	/*
	 * @param Film f
	 * 			le film a repeter
	 * @param a
	 * 			le nombre de repetition
	 */
	public Repeter(Film f, int a) {
		this.myfilm = f;
		this.nbactu = 1;
		this.nbtotal = a;
		if(a<1)				//pour eviter les repetitions nulles
			this.nbtotal =1;
	}
	
	/*
	 * @return la hauteur du film
	 */
	@Override
	public int hauteur(){
		return myfilm.hauteur();
	}
	
	/*
	 * @return la largeur du film
	 */
	@Override
	public int largeur() {
		return myfilm.largeur();
	}

	/*
	 * @return true si le film n'est pas fini
	 * @return false si le film est fini
	 * change l'image du film ou rebobine si le film est fini
	 */
	@Override
	public boolean suivante(char[][] écran) {
		
		if(!myfilm.suivante(écran)) {
			this.nbactu++;
			myfilm.rembobiner();
			
			if(this.nbactu==this.nbtotal)
				return false;
			myfilm.suivante(écran);		//pour eviter une frame vide lors du rembobinage
			return true;
		}
		return true;
	}
	
	/*
	 * rembobine le film
	 * et le numero de l'image actuelle
	 */
	@Override
	public void rembobiner() {
		this.nbactu =0;
		myfilm.rembobiner();
	}
	
}