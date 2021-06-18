package Virus.nonenvelope;
import Virus.AcidNucleic;
import Virus.Capsid;
import Virus.Virus;
public  abstract class NonenvelopeVirus extends Virus{
    //TODO add more attribute
    public NonenvelopeVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
    }
    @Override
    public void attackCell() {

    }
}
