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
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import java.util.Objects;

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

    public void init() throws DocumentException, SAXException {
        unitsTypeComboBox.getItems().clear();
        unitsTypeComboBox.getItems().addAll(Converter.getInstance().getUnitsType());
        unitsTypeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            unitsSrcComboBox.getItems().clear();
            unitsTrgComboBox.getItems().clear();
            try {
                Converter.getInstance().getUnits().stream().filter(i -> i.getType().compare(newValue)).forEach(i -> {
                    unitsSrcComboBox.getItems().add(i);
                    unitsTrgComboBox.getItems().add(i);
                });
                unitsSrcComboBox.getSelectionModel().selectFirst();
                unitsTrgComboBox.getSelectionModel().selectFirst();
            } catch (SAXException | DocumentException e) {
                e.printStackTrace();
            }
        });
        unitsTypeComboBox.getSelectionModel().selectFirst();

        ChangeListener<? super Units> listener = (observable, oldValue, newValue) ->{
            String text = valueTextField.getText();
            valueTextField.setText("a");
            valueTextField.setText(text);
        };
        unitsSrcComboBox.valueProperty().addListener(listener);
        unitsTrgComboBox.valueProperty().addListener(listener);

        valueTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("")) {
                valueTextField.setText("");
                return;
            }
            if(newValue.charAt(newValue.length()-1)=='.') {
                int t = 0;
                for (int i = 0; i < newValue.length(); i++)
                    if(newValue.charAt(i)=='.')
                        t++;
                if(t>1 || Objects.equals(oldValue, "")) {
                    valueTextField.setText(oldValue);
                    return;
                }
            }
            if(!(newValue.charAt(newValue.length()-1) >= '0' && newValue.charAt(newValue.length()-1) <= '9' || newValue.charAt(newValue.length()-1)=='.')){
                valueTextField.setText(oldValue);
                return;
            }
            else {
                double value = Double.valueOf(newValue);
                try {
                    resultTextField.setText(
                            String.valueOf(Converter.getInstance().convert(
                                    value,
                                    unitsSrcComboBox.getValue(),
                                    unitsTrgComboBox.getValue())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
