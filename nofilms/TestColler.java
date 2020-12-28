package nofilms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import montage.Montage;

class TestColler {

	@Test
	void test() {
		Film t = new LaDiagonaleDuFou();
		Film f = new Filmc();
		Montage.coller( t, f, "coller.txt");
	}
}
