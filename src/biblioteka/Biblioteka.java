package biblioteka;

import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs{

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Knjiga> VratiSveKnjige() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac) {
		if(autor==null && ISBN<=0 && naslov==null && izdavac==null)
			throw new IllegalArgumentException("Morate ineti bar neki kriterijum za pretragu");
		
		return null;
	}

}
