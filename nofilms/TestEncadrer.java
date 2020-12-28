package nofilms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import montage.Montage;

class TestEncadrer {

	@Test
	void test() {
		Film t = new LaDiagonaleDuFou();
		Montage.encadrer(t, "encadrer.txt");
	}
}
