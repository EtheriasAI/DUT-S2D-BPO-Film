package montage;

import film.Film;
import film.Films;

public class Montage{
	
	/*
	 * repeter le film	Film a
	 *@param Film a
	 *        Le film devant etre repete
	 *@param int b
	 *		  Le nombre de repetition
	 */
	public static void repeter(Film f, int n, String name) {
		
		Film t = new Repeter (f,n);
		t.rembobiner();
		Films.projeter(t);
		t.rembobiner();
		try {
			Films.sauvegarder(t, name);
		} catch (Exception e) {
			System.err.println("Le fichier '"+name+"' n'a pas pu être créé.");
		}
	}
	
	/*
	 * @param Film a
	 *		  le film a extraire
	 * @param int imgd
	 *		  image debut de l'extrait
	 * @param int imgf
	 *		  image de fin de l'extrait
	 */
	public static void extraire(Film f,int imgd, int imgf, String name) {
		
		Film t = new Extraire(f, imgd, imgf);
		t.rembobiner();
		Films.projeter(t);
		t.rembobiner();
		try {Films.sauvegarder(t, name);}
		catch (Exception e) {
			System.err.println("Le fichier '"+name+"' n'a pas pu être créé.");
		}
	}
	
	/*
	 * encadre de 4 * le Film a
	 * @param Film a
	 * 		  le film a encadrer
	 */
	public static void encadrer(Film f, String name) {

		Film t = new Encadrer(f);
		t.rembobiner();
		Films.projeter(t);
		t.rembobiner();
		try {Films.sauvegarder(t, name);}
		catch (Exception e) {
			System.err.println("Le fichier '"+name+"' n'a pas pu être créé.");
		}
	}
	
	/*
	 * coller un film a la suite de l'autre
	 * dans l'ordre:
	 * @param Film a
	 * 		  le premier film
	 * @param Film b
	 * 		  le deuxieme film
	 */
	public static void coller(Film a, Film b, String name) {
		Film t = new Coller(a, b);
		t.rembobiner();
		Films.projeter(t);
		t.rembobiner();
		try {Films.sauvegarder(t, name);}
		catch (Exception e) {
			System.err.println("Le fichier '"+name+"' n'a pas pu être créé.");
		}
	}
	
	/*
	 * superposer 2 films  a un endroit donne en prenant
	 * le premier film comme taille de film
	 * @param fa
	 * 		  le premier film
	 * @param fb
	 * 		  le deuxieme film
	 * @param int a
	 * 		  l'abscisse de l'endroit d'incrustation
	 * @param int o
	 * 		  l'ordonnee de l'endroit d'incrustation
	 */
	public static void incruster(Film fa, Film fb, int a , int o, String name) {
		Film t = new Incruster(fa, fb, a ,o);
		t.rembobiner();
		Films.projeter(t);
		t.rembobiner();
		try {Films.sauvegarder(t, name);}
		catch (Exception e) {
			System.err.println("Le fichier '"+name+"' n'a pas pu être créé.");
		}
	}
	
}
