package Virus.nonenvelope;

import Virus.AcidNucleic;
import Virus.Capsid;

public class RhinoVirus extends NonenvelopeVirus {
    //TODO add more attribute
    private String ssRNAgen;
    //TODO add more attribute
    public RhinoVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid icosahedral,String ssRNAgen) {
        super(size, typeOfAcidNucleic, icosahedral);
        this.ssRNAgen = ssRNAgen;
    }
	public String getSsRNAgen() {
		return ssRNAgen;
	}
    @Override
    public void attackCell() {

    }
}
