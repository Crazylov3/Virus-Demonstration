package GUI;

import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


public class GeneralVirusController {
    public Stage stage;
    public Scene scene;
    double x = 0, y = 0;
    public MediaPlayer mediaPlayer;
    public double speed = 1;
    public String path = "sample.mp4";

    @FXML
    public Slider progress, volumnBar;
    @FXML
    public Label moment;
    @FXML
    public Button collapseButton;
    @FXML
    public Button expandButton;
    @FXML
    public MediaView media;
    @FXML
    public ImageView image, volumn, muted;
    @FXML
    public AnchorPane viewField, playingBar, animationView, menuBar, structure;

    @FXML
    void collapse() {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(menuBar);
        slider.setToX(-200);
        slider.play();
        slider.setOnFinished((ActionEvent e) -> expandButton.setVisible(true));
        menuBar.setTranslateX(0);
    }

    @FXML
    void expand(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(menuBar);
        slider.setToX(0);
        slider.play();
        expandButton.setVisible(false);
        menuBar.setTranslateX(-200);
    }

    @FXML
    void mouseEntered() {
        expandButton.setText("》");
        expand(new ActionEvent());

    }

    @FXML
    void mouseExited() {
        expandButton.setText("〉");
    }

    @FXML
    void mouseEnteredCollapse() {
        collapseButton.setText("《");
    }

    @FXML
    void mouseExitedCollapse() {
        collapseButton.setText("〈");
    }

    //exit button ( X )
    @FXML
    void exit(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("DO YOU SURE TO EXIT?");
        alert.setContentText("Choose your option");
        alert.initStyle(StageStyle.UNDECORATED);
        ImageView icon = new ImageView(new File("src/GUI/source/media/your_icon.png").toURI().toString());
        icon.setFitHeight(50);
        icon.setFitWidth(50);
        alert.getDialogPane().setGraphic(icon);

        ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(new File("src/GUI/mainmenu/css/myDialogs.css").toURI().toString());
        dialogPane.getStyleClass().add("myDialog");


        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes) {
            System.exit(0);
        }
    }

    //minimize button ( - )
    @FXML
    void minimize(ActionEvent e) {
        ((Stage) (((Button) e.getSource()).getScene().getWindow())).setIconified(true);
    }

    //Drag
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }

    //structure of virus
    @FXML
    public void virusStructure(ActionEvent e) {
        media.setVisible(false);
        animationView.setVisible(false);
        structure.setVisible(true);
        playingBar.setVisible(false);
        collapse();
    }

    //animation of virus
    @FXML
    public void animation(ActionEvent e) throws IOException {
        media.setVisible(false);
        playingBar.setVisible(false);
        animationView.setVisible(true);
        structure.setVisible(false);
        collapse();
    }

    //video demonstrate virus
    @FXML
    public void video(ActionEvent e) {
        animationView.setVisible(false);
        media.setVisible(true);
        playingBar.setVisible(true);
        structure.setVisible(false);
        collapse();
        try {
            mediaPlayer.stop();
        } catch (Exception e1) {
        }
        File file = new File(this.path);
        Media m = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(m);
        media.setMediaPlayer(mediaPlayer);

        volumnBar.setValue(mediaPlayer.getVolume() * 100);
        volumnBar.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumnBar.getValue() / 100);
                if (volumnBar.getValue() == 0) {
                    muted.setVisible(true);
                    volumn.setVisible(false);
                } else {
                    volumn.setVisible(true);
                    muted.setVisible(false);
                }
            }
        });

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                                                          @Override
                                                          public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                                                              progress.setValue(newValue.toSeconds());
                                                              moment.setText("" + String.format("%02d", (int) newValue.toSeconds() / 60) + ":" + String.format("%02d", (int) newValue.toSeconds() % 60));
                                                          }
                                                      }
        );

        progress.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        progress.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(progress.getValue()));
            }
        });

        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                double total = mediaPlayer.getStopTime().toSeconds();
                progress.setMax(total);
            }
        });

        mediaPlayer.play();
    }

    @FXML
    public void play(ActionEvent e) {
        this.speed = 1;
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    @FXML
    public void pause(ActionEvent e) {
        mediaPlayer.pause();
    }

    @FXML
    public void skipUp(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    @FXML
    public void skipDown(ActionEvent e) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    public void slow(ActionEvent e) {
        this.speed /= 2;
        mediaPlayer.setRate(speed);
    }

    @FXML
    public void fast(ActionEvent e) {
        this.speed *= 2;
        mediaPlayer.setRate(speed);
    }

    @FXML
    public void mute() {
        if (volumnBar.getValue() > 0) {
            volumnBar.setValue(0);
            muted.setVisible(true);
            volumn.setVisible(false);
        } else {
            volumnBar.setValue(10);
            muted.setVisible(false);
            volumn.setVisible(true);
        }
    }


    // home button
    @FXML
    public void home(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/mainmenu/FXML/mainFxml.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //
    @FXML
    public void showPlayingBar() {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(playingBar);
        slider.setToY(0);
        slider.play();
        playingBar.setTranslateY(55);
    }

    @FXML
    public void hidePlayingBar() {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.millis(400));
        slider.setNode(playingBar);
        slider.setToY(55);
        slider.play();
        playingBar.setTranslateY(0);
    }

}






