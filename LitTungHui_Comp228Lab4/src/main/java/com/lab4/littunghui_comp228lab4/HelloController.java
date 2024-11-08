package com.lab4.littunghui_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;

public class HelloController {
    // components
    @FXML private TextField nameField, addressField, ProvinceField, cityField, PostalCodeField, phoneField, emailField;
    @FXML private CheckBox scCheckBox, vwCheckBox;
    @FXML private RadioButton csRadio, businessRadio;
    @FXML private ComboBox<String> courseComboBox;
    @FXML private ListView<String> coursesListView ;
    @FXML private TextArea infoTextArea;

    @FXML
    // run at the beginning
    public void initialize() {
        // set the action method to course combo box
        courseComboBox.setOnAction(event -> {
            String selectedCourse = courseComboBox.getValue();
            // prevent duplicated
            if (selectedCourse != null && !coursesListView.getItems().contains(selectedCourse)) {
                coursesListView.getItems().add(selectedCourse);
            }
        });
    }

    // for change courses list
    @FXML
    public void setCsMajor(){
        coursesListView.getItems().clear();
        courseComboBox.getItems().clear();
        courseComboBox.getItems().addAll("Python", "Java", "C#", "JavaScript", "SQL");
    }

    @FXML
    public void setBMajor(){
        coursesListView.getItems().clear();
        courseComboBox.getItems().clear();
        courseComboBox.getItems().addAll("Marketing", "Accounting", "Finance");
    }

    @FXML
    private void onDisplay() {
        String name = nameField.getText();
        String address = addressField.getText();
        String province = ProvinceField.getText();
        String city = cityField.getText();
        String postalCode = PostalCodeField.getText();
        String phoneNumber = phoneField.getText();
        String email = emailField.getText();
        String major = csRadio.isSelected() ? "Computer Science" : "Business";

        boolean isStudentCouncil = scCheckBox.isSelected();
        boolean isVolunteerWork = vwCheckBox.isSelected();

        String result = String.format( "Name: %s%nAddress: %s%nProvince: %s%nCity: %s%nPostal Code: %s%nPhone Number: %s%nEmail: %s%n" +
                "Student Council: %s%nVolunteer Work: %s%nMajor: %s%nSelected Courses: %s%n", name, address, province, city, postalCode, phoneNumber, email,
                isStudentCouncil ? "Yes" : "No",
                isVolunteerWork ? "Yes" : "No", major, String.join("\n",coursesListView.getItems()));

        // set to textarea for displaying
        infoTextArea.setText(result);
    }
}