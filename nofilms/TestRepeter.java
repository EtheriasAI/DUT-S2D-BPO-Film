package nofilms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exemple.LaDiagonaleDuFou;
import film.Film;
import montage.Montage;

class TestRepeter {

	@Test
	void test() {
		Film t = new LaDiagonaleDuFou();
		Montage.repeter( t, 2, "repeter1.txt");
		Montage.repeter( t, 0, "repeter2.txt");
		Montage.repeter( t, -1, "repeter3.txt");
	}
}
