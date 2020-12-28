package nofilms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import montage.Montage;

class TestIncruster {

	@Test
	void test() {
		Film t = new LaDiagonaleDuFou();
		Film f = new Filmc();
		Montage.incruster(f, t, 2, 2, "incruster.txt");
	}
}
