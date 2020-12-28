package nofilms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import montage.Montage;

class TestExtraire {

	@Test
	void test() {
		Film t = new LaDiagonaleDuFou();
		Montage.extraire(t, 2, 15, "extraire1.txt");
		Montage.extraire(t, -1, 25, "extraire2.txt");
		Montage.extraire(t, 10, 5, "extraire3.txt");
	}
}
