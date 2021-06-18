package Virus.envelope;
import Virus.Virus;
import Virus.Capsid;
import Virus.AcidNucleic;
import javafx.fxml.FXML;

public abstract class EnvelopeVirus extends Virus{
    private Envelope envelopeOfVirus;

    public EnvelopeVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid, Envelope envelopeOfVirus) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public Envelope getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(Envelope envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }

    @Override
    public void attackCell() {

    }


}
