package biblioteka;

import java.util.List;

public class Knjiga {

	private String naziv;
	private long isbn;
	private List<Autor> autori;
	private String izdavac;
	private int izdanje;
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv==null)
			throw new NullPointerException("Naziv ne sme da bude null!");
		
		if(naziv.isEmpty())
			throw new IllegalArgumentException("Naziv ne sme da bude prazan!");
		
		this.naziv = naziv;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN ne sme biti nula niti manji");
		
		this.isbn = isbn;
	}

	public List<Autor> getAutori() {
		return autori;
	}

	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Izdavac ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");		
		
		this.izdavac = izdavac;
	}

	public int getIzdanje() {
		return izdanje;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autori == null) ? 0 : autori.hashCode());
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		result = prime * result + izdanje;
		result = prime * result + ((izdavac == null) ? 0 : izdavac.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (autori == null) {
			if (other.autori != null)
				return false;
		} else if (!autori.equals(other.autori))
			return false;
		if (isbn != other.isbn)
			return false;
		if (izdanje != other.izdanje)
			return false;
		if (izdavac == null) {
			if (other.izdavac != null)
				return false;
		} else if (!izdavac.equals(other.izdavac))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}
	
	
}
