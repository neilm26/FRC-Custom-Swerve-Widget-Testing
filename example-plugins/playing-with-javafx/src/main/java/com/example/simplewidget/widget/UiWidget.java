package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import com.example.simplewidget.data.Point2D;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

@Description(
    name = "Circle UI",
    dataTypes = Point2D.class,
    summary = "I got trapped in gradle hell for days"
)
@ParametrizedController("UiWidget.fxml")
public final class UiWidget extends SimpleAnnotatedWidget<Point2D> {

  @FXML
  private Pane root;

  @FXML
  private ObservableList<PieChart.Data> voltageAllocation = FXCollections.observableArrayList(
          new PieChart.Data("Default", 50),
          new PieChart.Data("Default2", 25)
  );

  private double oldRootWidth, oldRootHeight;

  @FXML
  private PieChart piechart = new PieChart();


  @FXML
  private void initialize() {
    oldRootHeight = root.getHeight();
    oldRootWidth = root.getWidth();

    piechart.setData(voltageAllocation);
    piechart.setClockwise(true);
    piechart.setLabelLineLength(50);
    piechart.setLabelsVisible(true);

    TextField textField = new TextField();

    root.getChildren().add(textField);

    root.widthProperty().addListener((observable, oldValue, newValue) -> {
       piechart.resize(
               piechart.getWidth()*(newValue.doubleValue()/oldRootWidth),
                     piechart.getHeight());
       oldRootWidth = newValue.doubleValue();
       textField.setText(newValue.toString());
    });

    root.heightProperty().addListener((observable, oldValue, newValue) -> {
      piechart.resize(
              piechart.getWidth(),
              piechart.getHeight()*(newValue.doubleValue()/oldRootWidth));
      oldRootHeight = newValue.doubleValue();
    });
  }

  @Override
  public Pane getView() {
    return root;
  }


}
