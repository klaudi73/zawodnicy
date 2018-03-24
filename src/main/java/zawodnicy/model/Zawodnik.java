package zawodnicy.model;

import java.sql.Date;

public class Zawodnik {
	
	
	private Integer zawodnik_id;
	private String imie;
	private String nazwisko;
	private String kraj;
	private Date dataUr;
	private Integer wzrost;
	private Integer waga;
	
	public Zawodnik(Integer zawodnik_id, String imie, String nazwisko, String kraj, Date dataUr, Integer wzrost, Integer waga) {
		this.zawodnik_id = zawodnik_id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.kraj = kraj;
		this.dataUr = dataUr;
		this.wzrost = wzrost;
		this.waga = waga;
	}
	
	
	
	public Integer getZawodnik_id() {
		return zawodnik_id;
	}



	public void setZawodnik_id(Integer zawodnik_id) {
		this.zawodnik_id = zawodnik_id;
	}



	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public Date getDataUr() {
		return dataUr;
	}
	public void setDataUr(Date dataUr) {
		this.dataUr = dataUr;
	}
	public Integer getWzrost() {
		return wzrost;
	}
	public void setWzrost(Integer wzrost) {
		this.wzrost = wzrost;
	}
	public Integer getWaga() {
		return waga;
	}
	public void setWaga(Integer waga) {
		this.waga = waga;
	}



	@Override
	public String toString() {
		return "Zawodnik [zawodnik_id=" + zawodnik_id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", kraj=" + kraj
				+ ", dataUr=" + dataUr + ", wzrost=" + wzrost + ", waga=" + waga + "]";
	}
	
	
	
}
