package montage;

import film.Film;
import film.Films;

/*
 * implementation de l'interface film
 * pour pouvoir incruster un film dans un film
 * a une position donnee
 */
public class Incruster implements Film{

	private Film firstfilm;		//premier film
	private Film secondfilm;	//deuxieme film
	private int a =0;			//abscisse de l'incrustation
	private int o =0;			//ordonnee de l'incrustation

	/*
	 * @param Film un
	 * 			premier film
	 * @param Film deux
	 * 			deuxieme film qui sera incruster dans le premier
	 * @param abscisse
	 * 			abscisse de l'incrustation
	 * @param ordonnee
	 * 			ordonnee de l'incrustation
	 */
	public Incruster(Film un,Film deux, int abscisse, int ordonnee) {
		this.firstfilm = un;
		this.secondfilm = deux;
		this.a = abscisse;
		this.o = ordonnee;
		if(abscisse < 0 )		//permet de verifier que le film deux soit dans le cadre
			this.a =0;
		if( ordonnee < 0 )		//permet de verifier que le film deux soit dans le cadre
			this.o =0;
		//permet de verifier que le film deux soit dans le cadre
		if(abscisse > firstfilm.largeur() )
			this.a = firstfilm.largeur();
		//permet de verifier que le film deux soit dans le cadre
		if( ordonnee > firstfilm.hauteur() )
			this.o =firstfilm.hauteur();
	}

	/*
	 * @return la hauteur du premier film
	 */
	@Override
	public int hauteur() {
		return firstfilm.hauteur();
	}

	/*
	 * @return la largeur du premier film
	 */
	@Override
	public int largeur() {
		return firstfilm.largeur();
	}

	/*
	 * @return true si le premier film n'est pas fini
	 * @return false si le premier film est fini
	 * incruste les images du deuxieme film sur le premier
	 */
	@Override
	public boolean suivante(char[][] écran) {
		//cree un tableau ou l'on stocke les images du film a incruster
		char ecran [][] = new char [firstfilm.hauteur()+secondfilm.hauteur()][firstfilm.largeur()+secondfilm.hauteur()];
		
		Films.effacer(ecran);
		
		if(!firstfilm.suivante(écran))
			return false;
		secondfilm.suivante(ecran);
		
		for (int i = 0; i < this.hauteur()-this.o;i++)
			for (int j = 0; j < this.largeur()-this.a;j++)
				if(ecran[i][j]!=' ')
					écran[i+this.o][j+this.a] = ecran[i][j];
		
		return true;
	}

	/*
	 * rembobine le film et le film qu'on incruste
	 */
	@Override
	public void rembobiner() {
		firstfilm.rembobiner();
		secondfilm.rembobiner();
	}
	
}
