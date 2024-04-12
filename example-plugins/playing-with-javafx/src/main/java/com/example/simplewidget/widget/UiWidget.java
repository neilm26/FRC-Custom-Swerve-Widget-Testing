package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import com.example.simplewidget.data.Point2D;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(
    name = "Testing My Widget",
    dataTypes = Point2D.class,
    summary = "I got trapped in gradle hell for days"
)
@ParametrizedController("UiWidget.fxml")
public final class UiWidget extends SimpleAnnotatedWidget<Point2D> {

  @FXML
  private Pane root;
  @FXML
  private Label xCoordinateView;

  @FXML
  private Label yCoordinateView;

  @FXML
  private void initialize() {

    // Bind the text in the labels to the data
    // If you are unfamiliar with the -> notation used here, read the Oracle tutorial on lambda expressions:
    // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
//    xCoordinateView.textProperty().bind(dataOrDefault.map(point -> point.getX()).map(x -> "X: " + x));
//    yCoordinateView.textProperty().bind(dataOrDefault.map(point -> point.getY()).map(y -> "Y: " + y));
  }

  @Override
  public Pane getView() {
    return root;
  }
}
