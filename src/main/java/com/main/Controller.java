package com.main;

import com.convetion.Converter;
import com.convetion.Units;
import com.convetion.UnitsType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Controller {

    @FXML
    private ComboBox<Units> unitsSrcComboBox;

    @FXML
    private TextField resultTextField;

    @FXML
    private TextField valueTextField;

    @FXML
    private ComboBox<UnitsType> unitsTypeComboBox;

    @FXML
    private ComboBox<Units> unitsTrgComboBox;

    @FXML
    void initialize() {
        assert unitsSrcComboBox != null : "fx:id=\"unitsSrcComboBox\" was not injected: check your FXML file 'main.fxml'.";
        assert resultTextField != null : "fx:id=\"resultTextField\" was not injected: check your FXML file 'main.fxml'.";
        assert valueTextField != null : "fx:id=\"valueTextField\" was not injected: check your FXML file 'main.fxml'.";
        assert unitsTypeComboBox != null : "fx:id=\"unitsTypeComboBox\" was not injected: check your FXML file 'main.fxml'.";
        assert unitsTrgComboBox != null : "fx:id=\"unitsTrgComboBox\" was not injected: check your FXML file 'main.fxml'.";

        unitsTypeComboBox.getItems().clear();
        unitsTypeComboBox.getItems().addAll(Converter.getInstance().getUnitsType());
        unitsTypeComboBox.selectionModelProperty().addListener(new ChangeListener<SingleSelectionModel<UnitsType>>() {
            public void changed(ObservableValue<? extends SingleSelectionModel<UnitsType>> observable, SingleSelectionModel<UnitsType> oldValue, SingleSelectionModel<UnitsType> newValue) {
                unitsSrcComboBox.getItems().clear();
                unitsTrgComboBox.getItems().clear();
                for (Units i: Converter.getInstance().getUnits()) {
                    if(i.getType().compare(newValue.getSelectedItem())) {
                        unitsSrcComboBox.getItems().add(i);
                        unitsTrgComboBox.getItems().add(i);
                    }
                }
            }
        });

        valueTextField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue == "")
                    resultTextField.setText("");
                else {
                    double value = Double.valueOf(newValue);
                    resultTextField.setText(
                            String.valueOf(Converter.getInstance().convert(
                                    value,
                                    unitsSrcComboBox.getValue(),
                                    unitsTrgComboBox.getValue())));
                }
            }
        });
    }
}
