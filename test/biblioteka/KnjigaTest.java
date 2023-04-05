/**
 * 
 */
package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Irena
 *
 */
class KnjigaTest {

	Knjiga k;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 k = new Knjiga();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	/**
	 * Test method for {@link biblioteka.Knjiga#setNaziv(java.lang.String)}.
	 */
	@Test
	void testSetNaziv() {
		k.setNaziv("Tihi don");
		
		assertEquals("Tihi don", k.getNaziv());
	}
	
	@Test
	void testSetNazivNull() {
		assertThrows(NullPointerException.class, 
				() -> k.setNaziv(null));
	}
	
	@Test
	void testSetNazivPrazanString() {
		assertThrows(IllegalArgumentException.class, 
				() -> k.setNaziv(""));
	}

	/**
	 * Test method for {@link biblioteka.Knjiga#setIsbn(long)}.
	 */
	@Test
	void testSetIsbn() {
		k.setIsbn(1);
		
		assertEquals(1, k.getIsbn());
	}
	@ParameterizedTest
	@CsvSource({
		"0",
		"-1",
		"-55"
	})
	void testSetIsbnNedozvoljeno(int isbn) {
		assertThrows(IllegalArgumentException.class, 
				()->k.setIsbn(isbn));
	}

	/**
	 * Test method for {@link biblioteka.Knjiga#setIzdavac(java.lang.String)}.
	 */
	@Test
	void testSetIzdavacNull() {
		assertThrows(NullPointerException.class, 
				() -> k.setIzdavac(null));
	}
	
	@Test
	void testSetIzdavacPrazanString() {
		assertThrows(IllegalArgumentException.class, 
				() -> k.setIzdavac(""));
	}
	
	@Test
	void testSetIzdavac() {
		k.setIzdavac("Vulkan");
		
		assertEquals("Vulkan", k.getIzdavac());
	}

	/**
	 * Test method for {@link biblioteka.Knjiga#setIzdanje(int)}.
	 */
	@Test
	void testSetIzdanje() {
		k.setIzdanje(1);
		
		assertEquals(1, k.getIzdanje());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0",
		"-1",
		"-55"
	})
	void testSetIzdanjeNedozvoljeno(int izdanje) {
		assertThrows(IllegalArgumentException.class,
				() -> k.setIzdanje(izdanje));
	}
	

	/**
	 * Test method for {@link biblioteka.Knjiga#toString()}.
	 */
	@Test
	@DisplayName("Test za proveru toString metode")
	void testToString() {
		k.setNaziv("Tihi don");
		k.setIzdavac("Vulkan");
		k.setIzdanje(3);
		k.setIsbn(999);
		
		Autor a = new Autor();
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		List<Autor> autori = new ArrayList<Autor>();
		autori.add(a);
		
		k.setAutori(autori);
		
		String s = k.toString();
		
		assertTrue(s.contains("999"));
		assertTrue(s.contains("Tihi don"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("Vulkan"));
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
		
	}

	/**
	 * Test method for {@link biblioteka.Knjiga#equals(java.lang.Object)}.
	 */
	@ParameterizedTest
	@CsvSource({
	"999, 999, true",
	"2803, 2939, false"
	})
	void testEquals(long isbn1, long isbn2, boolean isti) {
		k.setIsbn(isbn1);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(isbn2);
		
		assertEquals(isti, k.equals(k2));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(k.equals(null));
	}

	@Test
	void testEqualsIsti() {
		assertTrue(k.equals(k));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(k.equals(new Exception()));
	}
}
