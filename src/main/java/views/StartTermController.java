package views;

import java.time.LocalDate;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartTermController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private ComboBox<String> yearComboBox;
    
    @FXML
    private ComboBox<String> termComboBox;
    
    @FXML
    private DatePicker startDatePicker;
    
    @FXML
    private CheckBox copyPreviousTermCheckBox;
    
    @FXML
    private VBox departmentSelectionPane;
    
    @FXML
    private VBox departmentCheckboxContainer;
    
    @FXML
    private DatePicker deptDeadlinePicker;
    
    @FXML
    private DatePicker registrationStartPicker;
    
    @FXML
    private DatePicker dropAddDeadlinePicker;
    
    @FXML
    private DatePicker endDatePicker;
    
    @FXML
    private TextArea statusTextArea;
    
    @FXML
    private Button cancelButton;
    
    @FXML
    private Button createTermButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
        
        initializeForm();
        
        setupEventListeners();
    }
    
    private void initializeForm() {
        ObservableList<String> years = FXCollections.observableArrayList(
            "2024-2025", "2025-2026", "2026-2027", "2027-2028"
        );
        yearComboBox.setItems(years);
        yearComboBox.setValue("2025-2026");
        
        ObservableList<String> terms = FXCollections.observableArrayList(
            "Fall", "Spring", "Summer", "Winter (CentreTerm)"
        );
        termComboBox.setItems(terms);
        termComboBox.setValue("Fall");
        
        LocalDate today = LocalDate.now();
        
        LocalDate defaultStart;
        if (today.getMonthValue() >= 5) {
            defaultStart = LocalDate.of(today.getYear() + 1, 8, 1);
        } else {
            defaultStart = LocalDate.of(today.getYear(), 8, 1);
        }
        startDatePicker.setValue(defaultStart);
        
        updateRelativeDates(defaultStart);
        
        statusTextArea.setText("Ready to create new term. Please fill in the required information.");
    }
    
    private void setupEventListeners() {
        startDatePicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateRelativeDates(newVal);
        });
        
        copyPreviousTermCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            departmentSelectionPane.setDisable(newVal);
            if (newVal) {
                updateStatus("Departments will be copied from the previous term.");
            } else {
                updateStatus("Please select departments to include in the new term.");
            }
        });
        
        termComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.equals("Fall")) {
                startDatePicker.setValue(LocalDate.of(LocalDate.now().getYear(), 8, 1));
            } else if (newVal.equals("Spring")) {
                startDatePicker.setValue(LocalDate.of(LocalDate.now().getYear() + 1, 1, 15));
            } else if (newVal.equals("Summer")) {
                startDatePicker.setValue(LocalDate.of(LocalDate.now().getYear() + 1, 5, 15));
            }
        });
    }
    
    private void updateRelativeDates(LocalDate startDate) {
        if (startDate == null) return;
        
        deptDeadlinePicker.setValue(startDate.minusMonths(1));
        
        registrationStartPicker.setValue(startDate.minusWeeks(2));
        
        dropAddDeadlinePicker.setValue(startDate.plusWeeks(2));
        
        endDatePicker.setValue(startDate.plusMonths(4));
    }
    
    private void updateStatus(String message) {
        statusTextArea.setText(message);
    }
    
    @FXML
    private void handleCancelAction(ActionEvent event) {
        viewModel.showHome();
    }
    
    @FXML
    private void handleCreateTermAction(ActionEvent event) {
        if (yearComboBox.getValue() == null || termComboBox.getValue() == null || startDatePicker.getValue() == null) {
            updateStatus("Error: Please fill in all required fields (Academic Year, Term, and Start Date).");
            return;
        }
        
        String termName = termComboBox.getValue() + " " + yearComboBox.getValue().split("-")[0];
        
        updateStatus("Term '" + termName + "' has been created successfully.");
        
        createTermButton.setDisable(true);
        
        Button viewTermButton = new Button("View Term");
        viewTermButton.setPrefWidth(120);
        viewTermButton.setPrefHeight(35);
        viewTermButton.setOnAction(e -> viewModel.showCurrentTerm());
        
        Button[] buttons = { cancelButton, viewTermButton };
        createTermButton.getParent().getChildrenUnmodifiable().forEach(node -> {
            if (node instanceof Button && node != cancelButton) {
                ((Button) node).setVisible(false);
            }
        });
        ((HBox) createTermButton.getParent()).getChildren().add(viewTermButton);
    }
}