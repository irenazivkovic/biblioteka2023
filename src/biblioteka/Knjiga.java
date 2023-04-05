package biblioteka;

import java.util.List;
import java.util.Objects;
/**
 * Predstavlja elektronsku ili stampanu knjigu.
 * 
 * Moze imati autora, naslov, izdavaca, izdanje i isbn broj.
 * 
 * @author Irena
 * @since 0.1.0
 */
public class Knjiga {

	/**
	 * Naziv knjige kao String
	 */
	private String naziv;
	/**
	 * isbn broj knjige koji bi trebao imati 9 ili 13 cifara
	 */
	private long isbn;
	/**
	 * Lista autora knjige 
	 * Lista moze biti prazna ili null u slucajevima
	 * da je autor knjige nepoznat (npr. narodne pesme, bajke)
	 */
	private List<Autor> autori;
	/**
	 * izdavac knjige kao String
	 */
	private String izdavac;
	/**
	 * Izdanje knjige kao ceo broj
	 */
	private int izdanje;
	
	/**
	 * Vraca naslov knjige
	 * @return naslov kao String
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja vrednost atributa naziv
	 * Naziv ne sme biti null niti prazan string
	 * 
	 * @param naziv nova vrednost za naslov knjige
	 * @throws NullPointerException ako je naziv postavljen na null 
	 * @throws IllegalArgumentException ukoliko je naziv prazan string
	 * 
	 */
	public void setNaziv(String naziv) {
		if(naziv==null)
			throw new NullPointerException("Naziv ne sme da bude null!");
		
		if(naziv.isEmpty())
			throw new IllegalArgumentException("Naziv ne sme da bude prazan!");
		
		this.naziv = naziv;
	}

	/**
	 * Vraca isbn knjige
	 * 
	 * @return isbne knjige kao ceo broj
	 */
	public long getIsbn() {
		return isbn;
	}
	
	/**
	 * Postavlja vrednost za isbn broj knjige.
	 * 
	 * ISBN broj mora biti veci od nule.
	 * 
	 * @param isbn isbn broj knjige kao ceo broj
	 * @throws IllegalArgumentException ako se unese isbn broj koji je manji od 1
	 */
	public void setIsbn(long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN ne sme biti nula niti manji");
		
		this.isbn = isbn;
	}

	/**
	 * Vraca listu autora knjige.
	 * 
	 * @return Listu sa autorima knjige, ili null ako knjiga nema poznate autore.
	 */
	public List<Autor> getAutori() {
		return autori;
	}

	/**
	 * Postavlja listu sa autorima knjige.
	 * 
	 * Lista sme biti null ili prazna ako knjiga nema poznate autore.
	 * 
	 * @param autori lista sa autorima knjige.
	 */
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	/**
	 * Vraca naziv izdavacke kuce koja je izdala knjigu.
	 * 
	 * @return Naziv izdavacke kuce za tu knjigu kao String
	 */
	public String getIzdavac() {
		return izdavac;
	}

	/**
	 * Postavlja vrednost atributa izdavac.
	 * 
	 * Izdavac ne sme biti null niti prazan String.
	 * 
	 * @param izdavac nova vrednost za naziv izdavaca knjige
	 * 
	 * @throws NullPointerException ako se unese null vrednost za izdavaca
	 * @throws IllegalArgumentException ako se unese prazan String kao izdavac
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Izdavac ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");		
		
		this.izdavac = izdavac;
	}

	/**
	 * Vraca izdanje knjige
	 * 
	 * @return izdanje knjige kao ceo broj.
	 */
	public int getIzdanje() {
		return izdanje;
	}

	/**
	 * Postavlja vrednost za izdanje knjige.
	 * 
	 * Broj izdanja mora biti veci od nule.
	 * 
	 * @param izdanje broj izdanja kao ceo broj
	 * @throws IllegalArgumentException ako se unese broj izdanja koji je manji od 1
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje < 1)
			throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
		
		this.izdanje = izdanje;
	}

	@Override
	public String toString() {
		return "Knjiga [naziv=" + naziv + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	/**
	 * Izracunava hash code na osnovu isbn broja.
	 * 
	 * @return hash code na osnovu isbn broja.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	/**
	 * Poredi dve knjige preko isbn broja.
	 * 
	 * @return
	 * <ul>
	 * 		<li> true - ako je isbn broj obe knjige isti ili ako je unet isti objekat </li>
	 * 		<li> false - ako je unet null objekat ili ako nije klase Knjiga </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return isbn == other.isbn;
	}
	
	
}
