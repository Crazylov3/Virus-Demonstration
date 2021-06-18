package Virus.nonenvelope;
import Virus.AcidNucleic;
import Virus.Capsid;

public class PolioVirus extends NonenvelopeVirus{
	private String ssRNA;
	private String VPg;
    public PolioVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid,String ssRNA,String VPg) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
        this.ssRNA = ssRNA;
        this.VPg = VPg;
    }
	public String getSsRNA() {
		return ssRNA;
	}
	public void setSsRNA(String ssRNA) {
		this.ssRNA = ssRNA;
	}
	public String getVPg() {
		return VPg;
	}
	public void setVPg(String vPg) {
		VPg = vPg;
	}
	@Override
	public void attackCell() {

	}
    
    
}
