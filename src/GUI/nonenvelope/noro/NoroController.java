package GUI.nonenvelope.noro;

import GUI.GeneralVirusController;
import Main.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoroController extends GeneralVirusController implements Initializable {
    @FXML
    private Label textExplain;
    @FXML
    private ImageView cell1, cell2, virus1, virus2;
    @FXML
    private Button replay;


    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }

    
//BACK TO MAIN MENU
    @Override
    public void home(ActionEvent e) throws IOException {
        super.home(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
    
  
    //RUN ANIMATION
    @Override
    public void animation(ActionEvent e) throws IOException {
        super.animation(e);
        try {

            replay.setText("PLAY");
            mediaPlayer.stop();
        } catch (Exception e1) {
        }

    }

    @FXML
    public void runAnimation(ActionEvent e) {
        replay.setText("REPLAY");
        replay.setVisible(false);
        cell1.setOpacity(1);
        cell2.setOpacity(0);
        virus1.setOpacity(1);
        virus1.setTranslateX(0);
        virus1.setTranslateY(0);
        virus2.setOpacity(0);

        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(1500), new KeyValue(cell1.opacityProperty(), 0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(cell1.opacityProperty(), 1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(cell2.opacityProperty(), 0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(1500), new KeyValue(cell2.opacityProperty(), 1.0)));
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus1.opacityProperty(), 0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus2.opacityProperty(), 1.0)));

        TranslateTransition phase1 = new TranslateTransition();
        phase1.setNode(virus1);
        phase1.setDuration(Duration.millis(2500));
        phase1.setToX(-268);
        phase1.setToY(182);
        phase1.setOnFinished(event -> {
            tm10.setDelay(Duration.millis(1500));
            tm21.setDelay(Duration.millis(1500));
            TranslateTransition phase2 = new TranslateTransition();
            phase2.setNode(virus1);
            phase2.setDuration(Duration.millis(2000));
            phase2.setToX(-287);
            phase2.setToY(205);
            phase2.setDelay(Duration.millis(1500));
            phase2.setOnFinished(event1 -> {
                TranslateTransition phase3 = new TranslateTransition();
                phase3.setDuration(Duration.millis(3000));
                phase3.setNode(virus1);
                phase3.setToX(-319);
                phase3.setToY(398);
                phase3.setOnFinished(event2 -> {
                    tmVirus10.setDelay(Duration.millis(2000));
                    tmVirus21.setDelay(Duration.millis(2000));
                    tmVirus10.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            replay.setVisible(true);

                        }
                    });
                    tmVirus21.play();
                    tmVirus10.play();

                });

                tm11.setDelay(Duration.millis(500));
                tm20.setDelay(Duration.millis(500));
                tm11.play();
                tm20.play();
                phase3.play();
            });

            tm10.play();
            tm21.play();
            phase2.play();
        });
        phase1.play();

    }


//IMPLEMENT VIDEO
    @Override
    public void video(ActionEvent e) {
        this.path = "src/GUI/nonenvelope/noro/media/animation.mp4";
        super.video(e);
    }
//SET STRUCTURE FOR NORO VIRUS  
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }
 
    @FXML
    void showConstant(ActionEvent event) {
        textExplain.setText(Main.noro.getConstantDomain());
    }
    @FXML
    void showPDomain(ActionEvent event) {
        textExplain.setText(Main.noro.getPDomain());
    }
    @FXML
    void showRNA(ActionEvent event) {
        textExplain.setText(Main.noro.getRNA());
    }
    @FXML
    void showSDomain(ActionEvent event) {
        textExplain.setText(Main.noro.getSDomain());
    }
    @FXML
    void showVariable(ActionEvent event) {
        textExplain.setText(Main.noro.getVariableDomain());
    }
    @FXML
    void introVirus() {
        textExplain.setText(Main.noro.getIntroVirus());
    }
}
