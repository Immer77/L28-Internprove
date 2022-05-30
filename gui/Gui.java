package gui;

import internprove.Parkeringshus;
import internprove.Parkeringsplads;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application {

    private ListView<Parkeringshus> lvwPHuse = new ListView<>();
    private ListView<Parkeringsplads> lvwPpladser = new ListView<>();
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Parkeringshuse og pladser");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(new Label("ParkeringsHuse"),0,0);
        pane.add(lvwPHuse,0,1);
        lvwPHuse.setPrefHeight(100);
        lvwPHuse.setPrefWidth(100);


        pane.add(new Label("Optagnepladser"),0,0);
        pane.add(lvwPHuse,0,1);
        lvwPHuse.setPrefHeight(100);
        lvwPHuse.setPrefWidth(100);
    }
}
