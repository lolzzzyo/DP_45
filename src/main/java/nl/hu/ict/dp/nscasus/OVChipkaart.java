package nl.hu.ict.dp.nscasus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ovchipkaart")
public class OVChipkaart {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "kaart_Sequence")
    @SequenceGenerator(name = "kaart_Sequence", sequenceName = "KAART_SEQ")
    private int kaartnr;
    private Date geldigheid;
    private String kaartopdruk;
    
    @ManyToOne()
    @JoinColumn(name = "reizigerid")
    private Reiziger reiziger;

    public int getKaartnr() {
        return kaartnr;
    }

    public void setKaartnr(int kaartnr) {
        this.kaartnr = kaartnr;
    }

    public Date getGeldigheid() {
        return geldigheid;
    }

    public void setGeldigheid(Date geldigheid) {
        this.geldigheid = geldigheid;
    }

    public String getKaartopdruk() {
        return kaartopdruk;
    }

    public void setKaartopdruk(String kaartopdruk) {
        this.kaartopdruk = kaartopdruk;
    }
    
    public void setReiziger(Reiziger reiziger) {
    	this.reiziger = reiziger;
    }

    public String toString() {
        return "OVChipkaart{" +
                "kaartnr=" + kaartnr +
                ", geldigheid=" + geldigheid +
                ", kaartopdruk='" + kaartopdruk + '\'' +
                '}';
    }
}
