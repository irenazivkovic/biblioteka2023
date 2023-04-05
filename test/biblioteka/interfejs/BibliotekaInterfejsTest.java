package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {

	protected BibliotekaInterfejs biblioteka;
	
	@Test
	void testDodajKnjiguSveOk() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(999);
		
		biblioteka.dodajKnjigu(k);
		List<Knjiga> knjige = biblioteka.VratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue(knjige.contains(k));
		
	}

	@Test
	void testDodajKnjiguSveOk2() {
		Knjiga k = new Knjiga();
		k.setIsbn(999);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k.setIsbn(123);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige = biblioteka.VratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k));
		assertTrue(knjige.contains(k2));
		
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(NullPointerException.class, 
				() -> biblioteka.dodajKnjigu(null));
		
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(2937);
		
		biblioteka.dodajKnjigu(k);

		assertThrows(IllegalArgumentException.class, 
				() -> biblioteka.dodajKnjigu(k));
	}
	
	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn(12435);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(29173);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.obrisiKnjigu(k);
		List<Knjiga> knjige = biblioteka.VratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue(knjige.contains(k2));
	}
	
	@Test 
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn(12435);
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(54321);
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		k3.setIsbn(999);

		biblioteka.obrisiKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.VratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k));
		assertTrue(knjige.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class ,
				() -> biblioteka.pronadjiKnjigu(null, -1, null, null));
	}
	
	@Test
	void testPronadjiKnjiguNaslovNull() {
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, 0, null, "Laguna");
		assertTrue(rezultat.isEmpty());
	}
	@Test
	@Timeout(value = 3, unit = TimeUnit.MILLISECONDS)
	void testPronadjiKnjiguNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		k.setNaziv("Prohujalo sa vihorom");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		k2.setNaziv("Gospodar prstenova");
		
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, -1, "PRST", null);
		
		assertEquals(1, rezultat.size());
		assertTrue( rezultat.contains(k2) );
	}
	
	@Test
	@Timeout(3)
	void testPronadjiViseKnjigaNaslov() {
		Knjiga k = new Knjiga();
		
		k.setIsbn(12435);
		k.setNaziv("Prohujalo sa vihorom");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		
		k2.setIsbn(54321);
		k2.setNaziv("Gospodar prstenova");
		
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultat = 
				biblioteka.pronadjiKnjigu(null, -1, "PR", null);
		
		assertEquals(2, rezultat.size());
		assertTrue( rezultat.contains(k) );
		assertTrue( rezultat.contains(k2) );
	}
	
}
