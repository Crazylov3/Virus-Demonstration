package GUI.envelope.covid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.Main;
import GUI.GeneralVirusController;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CovidController extends GeneralVirusController implements Initializable {
    @FXML
    private ImageView image, hostCell1, hostCell2, virus1, virus2;
    @FXML
    private Label setData;
    @FXML
    private Button replay;


    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {
    }


    //IMPLEMENT RUN ANIMATION
    @Override
    public void animation(ActionEvent e) throws IOException {
        replay.setText("PLAY");
        super.animation(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    public void runAnimation() {
        replay.setVisible(false);
        replay.setText("Replay");
        virus1.setTranslateX(0);
        virus1.setRotate(0);
        virus1.setTranslateY(0);
        virus1.setOpacity(1);
        virus2.setOpacity(0);
        hostCell1.setOpacity(1);
        hostCell2.setOpacity(0);
        Timeline tm10 = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(hostCell1.opacityProperty(), 0.0)));
        Timeline tm11 = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(hostCell1.opacityProperty(), 1.0)));
        Timeline tm20 = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(hostCell2.opacityProperty(), 0.0)));
        Timeline tm21 = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(hostCell2.opacityProperty(), 1.0)));
        Timeline tmVirus10 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus1.opacityProperty(), 0)));
        Timeline tmVirus21 = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(virus2.opacityProperty(), 1.0)));

        tm10.setDelay(Duration.millis(500));
        tm11.setDelay(Duration.millis(550));
        tm20.setDelay(Duration.millis(500));
        tm21.setDelay(Duration.millis(500));

        RotateTransition rotation = new RotateTransition();
        PauseTransition pause = new PauseTransition();
        pause.setDuration(Duration.millis(4000));
        pause.setOnFinished(event -> {
            tmVirus10.setOnFinished(event1 -> {
                replay.setVisible(true);
            });

            tmVirus10.play();
            tmVirus21.play();
        });

        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(2000));
        slider.setNode(virus1);
        slider.setToX(-180);
        slider.setToY(136);


        TranslateTransition slider1 = new TranslateTransition();
        slider1.setDuration(Duration.millis(1000));
        slider1.setNode(virus1);
        slider1.setToX(-195);
        slider1.setToY(202);

        TranslateTransition slider2 = new TranslateTransition();
        slider2.setDuration(Duration.millis(2000));
        slider2.setNode(virus1);
        slider2.setToX(-301);
        slider2.setToY(391);

        Timeline tm3 = new Timeline(new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                slider2.play();
                tm11.play();
                tm20.play();
                pause.play();

            }
        }));

        rotation.setNode(virus1);
        rotation.setByAngle(8.1);
        rotation.setDuration(Duration.millis(500));

        slider.setOnFinished(event -> {
            tm10.play();
            tm21.play();
            slider1.play();
            rotation.play();
            tm3.play();
        });
        slider.play();
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


    //IMPLEMENT VIDEO
    @Override
    public void video(ActionEvent e) {
        this.path = "src/GUI/envelope/covid/media/covidvideo.mp4";
        super.video(e);

    }


    //SET STRUCTURE FOR COVID VIRUS
    @Override
    public void virusStructure(ActionEvent e) {
        super.virusStructure(e);
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
    }

    @FXML
    public void setEP(ActionEvent e) { // set detail for Envelope Protein
        setData.setText(Main.corona.getEvenlopeProtein());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setMP(ActionEvent e) { //set detail for M protein
        setData.setText(Main.corona.getMprotein());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setSG(ActionEvent e) { //set detail for spike Glycoprotein
        setData.setText(Main.corona.getSpike());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setNP(ActionEvent e) {// set detail for N protein and RNA
        setData.setText(Main.corona.getTypeOfNucleocapsid().getTypeOfStructureOfCapsid());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

    @FXML
    public void setLM(ActionEvent e) { //set detail for Lipid membrane
        setData.setText(Main.corona.getEnvelopeOfVirus().getEnvelopeOfVirus());
        setData.setMaxWidth(260);
        setData.setWrapText(true);
    }

}

