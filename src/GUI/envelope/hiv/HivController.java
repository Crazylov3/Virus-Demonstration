package GUI.envelope.hiv;

import GUI.GeneralVirusController;
import Main.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HivController extends GeneralVirusController implements Initializable {
    @FXML
    private ImageView image,hivb1,hivb2,hivb3,hivb4,hiv1,hiv2,hiv3,cell,ARN;
    @FXML
    private Label textExplain;
    @FXML
    private Button play;


    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }

//IMPLEMENT RUN ANIMATION
    @FXML
    public void runAnimation() {
        play.setVisible(false);
        play.setText("Replay");
        hiv1.setOpacity(1);
        hiv1.setTranslateX(0);
        hiv1.setTranslateY(0);
        hiv2.setOpacity(0);
        hiv2.setTranslateX(0);
        hiv2.setTranslateY(0);
        hiv3.setOpacity(0);
        hiv3.setTranslateX(0);
        hiv3.setTranslateY(0);

        ARN.setOpacity(0);
        ARN.setTranslateX(0);
        ARN.setTranslateY(0);

        cell.setOpacity(1.0);
        hivb1.setOpacity(0);
        hivb1.setTranslateX(0);
        hivb1.setTranslateY(0);
        hivb2.setOpacity(0);
        hivb2.setTranslateX(0);
        hivb2.setTranslateY(0);
        hivb3.setOpacity(0);
        hivb3.setTranslateX(0);
        hivb3.setTranslateY(0);
        hivb4.setOpacity(0);
        hivb4.setTranslateX(0);
        hivb4.setTranslateY(0);
        
        
        
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv1.opacityProperty(),  0.0)));
        Timeline tmVirus11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv1.opacityProperty(),  1.0)));
        
        Timeline tmVirus20 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv2.opacityProperty(),  0.0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv2.opacityProperty(),  1.0)));
        
        Timeline tmVirus30 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv3.opacityProperty(),  0.0)));
        Timeline tmVirus31 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hiv3.opacityProperty(),  1.0)));
        
        Timeline tmVirusb11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hivb1.opacityProperty(),  1.0)));
        Timeline tmVirusb21 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hivb2.opacityProperty(),  1.0)));
        Timeline tmVirusb31 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hivb3.opacityProperty(),  1.0)));
        Timeline tmVirusb41 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(hivb4.opacityProperty(),  1.0)));
        
        Timeline tmARN10 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN.opacityProperty(),  0.0)));
        Timeline tmARN11 = new Timeline(new KeyFrame(Duration.millis(1000),new KeyValue(ARN.opacityProperty(),  1.0)));
        
        TranslateTransition phase1 = new TranslateTransition();
        phase1.setNode(hiv1);
        phase1.setDuration(Duration.millis(2000));
        phase1.setToX(676-86);
        phase1.setToY(181-40);
        phase1.setOnFinished(event->{
        	tmVirus10.play();
        	tmVirus21.play();
        	tmARN11.play();
        	
        	TranslateTransition phase2 = new TranslateTransition();
            phase2.setNode(ARN);
            phase2.setDuration(Duration.millis(1000));
            phase2.setToX(663-671);
            phase2.setToY(346-185);
        	phase2.setOnFinished(event2->{
        		tmVirus20.setDelay(Duration.millis(1000));
        		tmVirus20.play();
        		tmVirus31.setDelay(Duration.millis(1000));
        		tmVirus31.play();
        		tmVirus31.setOnFinished(event3->{
        			tmVirusb11.play();
        			tmVirusb21.play();
        			tmVirusb31.play();
        			tmVirusb41.play();
        			tmVirusb41.setOnFinished(event4->{
        				play.setVisible(true);
        			});
        		});
        	});
        	phase2.play();
        	
        });
        phase1.play();
    }
@Override
	public void animation(ActionEvent e) throws IOException {
        super.animation(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
        play.setText("Play");
    }


//BACK TO MAIN MENU
//BACK TO MAIN MENU
@Override
	public void home(ActionEvent e) throws IOException {
    super.home(e);
    try {
        mediaPlayer.stop();
    } catch (Exception e1) {
    }
}

//IMPLEMENT VIDEO
    @Override
    public void video(ActionEvent e) {
        this.path = "src/GUI/envelope/hiv/media/animation.mp4";
        super.video(e);

    }

//SET STRUCTURE FOR HIV VIRUS

    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        	} 
    }
//SET STRUCTURE FOR HIV VIRUS
    @FXML
    void showGp120(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getGp120());
    }
    @FXML
    void showGp41(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getGp41());
    }
    @FXML
    void showHumanClass1(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getHumanClass1());
    }
    @FXML
    void showHumanClass2(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getHumanClass2());
    }
    @FXML
    void showIntegrase(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getIntegrase());
    }
    @FXML
    void showLipidBilayer(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getEnvelopeOfVirus().getEnvelopeOfVirus());
    }
    @FXML
    void showMatrixProtein(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getMatrixProtein());
    }
    @FXML
    void showNucleocapsid(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getNucleocapsid());
    }
    @FXML
    void showProtease(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getProtease());
    }
    @FXML
    void showProteinP79(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getProteinP79());
    }
    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getRNA());
    }
    @FXML
    void showReverse(ActionEvent event) {
        textExplain.setText(Main.hivVirus.getReverse());
    }

}
