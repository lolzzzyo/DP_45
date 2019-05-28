package nl.hu.ict.dp.nscasus;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "reiziger")
public class Reiziger {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reiziger_Sequence")
    @SequenceGenerator(name = "reiziger_Sequence", sequenceName = "REIZIGER_SEQ")
	private int reizigerId;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;

	
	@OneToMany()
	@JoinColumn(name = "reizigerid")
	private List<OVChipkaart> kaarten;
	
	public Reiziger(int reizigerId, String voorletters, String tussenvoegsel, String achternaam) {
		this.reizigerId = reizigerId;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
	}
	
	public Reiziger(){	
		kaarten = new ArrayList<OVChipkaart>();
	}

	public int getReizigerId() {
		return reizigerId;
	}
	
	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}
	
	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	 public Collection<OVChipkaart> getKaarten() {
	    return kaarten;
	 }
	
    public void addKaart(OVChipkaart kaart) {
        if (!getKaarten().contains(kaart)) {
            getKaarten().add(kaart);
            
            kaart.setReiziger(this);
        }
    }
	
	public String toString() {
		String s = voorletters + " " + tussenvoegsel + " " + achternaam + "\n" + kaarten;
		return s;
	}
}
