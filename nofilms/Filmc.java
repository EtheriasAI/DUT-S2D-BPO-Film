package nofilms;

import java.io.FileNotFoundException;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;

public class Filmc implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 20;

	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return 10; // ce sera un carré
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		for(int i=0; i<hauteur();i++)
			for(int j=0; j < largeur() ; j++)
			écran[i][j] = 'c'; // un 'a' se balade sur
														// la diagonale
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

	public static void main(String[] args) {
		Film film = new Filmc();
		Films.projeter(film);
		
	}
	
}

