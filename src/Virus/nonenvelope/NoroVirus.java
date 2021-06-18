package Virus.nonenvelope;
import Virus.AcidNucleic;
import Virus.Capsid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NoroVirus extends NonenvelopeVirus {
    private String ConstantDomain;
    private String VariableDomain;
    private String PDomain;
    private String SDomain;
    private String RNA;
    private String introVirus;

    public NoroVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid, String constantDomain, String variableDomain, String PDomain, String SDomain, String RNA, String introVirus) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
        ConstantDomain = constantDomain;
        VariableDomain = variableDomain;
        this.PDomain = PDomain;
        this.SDomain = SDomain;
        this.RNA = RNA;
        this.introVirus = introVirus;
    }

    public NoroVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
    }

    public String getConstantDomain() {
        return ConstantDomain;
    }

    public void setConstantDomain(String constantDomain) {
        ConstantDomain = constantDomain;
    }

    public String getVariableDomain() {
        return VariableDomain;
    }

    public void setVariableDomain(String variableDomain) {
        VariableDomain = variableDomain;
    }

    public String getPDomain() {
        return PDomain;
    }

    public void setPDomain(String PDomain) {
        this.PDomain = PDomain;
    }

    public String getSDomain() {
        return SDomain;
    }

    public void setSDomain(String SDomain) {
        this.SDomain = SDomain;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String RNA) {
        this.RNA = RNA;
    }

    public String getIntroVirus() {
        return introVirus;
    }

    public void setIntroVirus(String introVirus) {
        this.introVirus = introVirus;
    }

    @Override
    public void attackCell(){

    }
}
