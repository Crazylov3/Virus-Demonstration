package Virus.envelope;
import Virus.AcidNucleic;
import Virus.Capsid;
import Virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EbolaVirus extends EnvelopeVirus {
//    private Envelope envelopeOfVirus;
    private String GlyProtein;
    private String Nucleprotein;
    private String RNA;
    private String VP;

    public EbolaVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid, Envelope envelopeOfVirus,  String glyProtein, String nucleprotein, String RNA, String VP) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid, envelopeOfVirus);
        GlyProtein = glyProtein;
        Nucleprotein = nucleprotein;
        this.RNA = RNA;
        this.VP = VP;
    }

    public Envelope getEnvelopeOfVirus() {
        return super.getEnvelopeOfVirus();
    }

    public void setEnvelopeOfVirus(Envelope envelopeOfVirus) {
        super.setEnvelopeOfVirus(envelopeOfVirus);
    }

    public String getGlyProtein() {
        return GlyProtein;
    }

    public void setGlyProtein(String glyProtein) {
        GlyProtein = glyProtein;
    }

    public String getNucleprotein() {
        return Nucleprotein;
    }

    public void setNucleprotein(String nucleprotein) {
        Nucleprotein = nucleprotein;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String RNA) {
        this.RNA = RNA;
    }

    public String getVP() {
        return VP;
    }

    public void setVP(String VP) {
        this.VP = VP;
    }
    @Override
    public void attackCell(){

    }
}
