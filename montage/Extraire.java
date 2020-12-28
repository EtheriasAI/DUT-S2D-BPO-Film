package montage;

import film.Film;
import film.Films;

/*
 * implementation de l'interface film
 * pour extraire un morceau d'un film
 * avec les images souhaitees
 */
public class Extraire implements Film{
	
	private int factu;		//compteur de la frame actuelle
	private int imgd;		//images de debut de l'extrait
	private int imgf;		//images de fin de l'extrait
	private Film myfilm;	//le film a encadrer
	
	/*
	 * @param Film f
	 * 			le film
	 * @param int d
	 * 			image de debut de l'extrait
	 * @param int e
	 * 			image de fin de l'extrait
	 */
	public Extraire(Film f, int d, int e) {
		this.myfilm = f;
		this.imgd = d+1;
		this.imgf = e+1;
		this.factu =0;
		if(d<1)				//verifie que l'extrait commence a la premiere image
			this.imgd = 1;
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
	 * @return true si le film n'est pas arriver a la fin de l'extrait
	 * @return false quand le film est pas arriver a la fin de l'extrait
	 * extrait le film
	 */
	@Override
	public boolean suivante(char[][] écran) {
		factu++;
		while(imgd>factu) {
			if(!myfilm.suivante(écran))
				return false;
			Films.effacer(écran);
			factu++;
		}
		if(factu > this.imgf)
			return false;
		
		if(!myfilm.suivante(écran))
			return false;
		
		return true;
	}

	/*
	 * initialise la frame actuelle a 0
	 * rembobine le film
	 */
	@Override
	public void rembobiner() {
		this.factu =0;
		myfilm.rembobiner();
	}
	
}