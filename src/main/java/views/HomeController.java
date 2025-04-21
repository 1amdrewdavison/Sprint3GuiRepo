package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class HomeController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private Label statusLabel;
    
    @FXML
    private Button viewCurrentTermButton;
    
    @FXML
    private Button viewCatalogButton;
    
    @FXML
    private VBox departmentChairControls;
    
    @FXML
    private Button viewDepartmentButton;
    
    @FXML
    private ComboBox<String> departmentComboBox;
    
    @FXML
    private Button proposeNewDepartmentButton;
    
    @FXML
    private ComboBox<String> newDepartmentComboBox;
    
    @FXML
    private VBox registrarControls;
    
    @FXML
    private Button startTermButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
        
        ObservableList<String> departments = FXCollections.observableArrayList(
            "Computer Science", "Mathematics", "Physics", "Chemistry", "Biology");
        departmentComboBox.setItems(departments);
        newDepartmentComboBox.setItems(departments);
        
        setupUserInterface();
    }
    
    private void setupUserInterface() {
        int accessLevel = schedulerModel.getCurrentUserAccessLevel();
        String userId = schedulerModel.getCurrentUserId();
        String department = schedulerModel.getCurrentUserDepartment();
        
        switch (accessLevel) {
            case 0: // Student
                statusLabel.setText("Welcome to the system. You are logged in as: Student");
                break;
            case 1: // Department Chair
                departmentChairControls.setVisible(true);
                statusLabel.setText("Welcome to the system. You are logged in as: Department Chair of " + department);
                break;
            case 2: // Registrar
                departmentChairControls.setVisible(true);
                registrarControls.setVisible(true);
                departmentComboBox.setVisible(true);
                newDepartmentComboBox.setVisible(true);
                statusLabel.setText("Welcome to the system. You are logged in as: Registrar");
                break;
        }
        
        //if user is a department chair, set their department as the default
        if (accessLevel == 1) {
            departmentComboBox.setValue(department);
        }
    }
    
    // Event Handlers
    @FXML
    private void handleViewCurrentTermAction(ActionEvent event) {
        viewModel.showCurrentTerm();
    }
    
    @FXML
    private void handleViewCatalogAction(ActionEvent event) {
        viewModel.showCatalog();
    }
    
    @FXML
    private void handleViewDepartmentAction(ActionEvent event) {
        int accessLevel = schedulerModel.getCurrentUserAccessLevel();
        String departmentToView = accessLevel == 1 
                                ? schedulerModel.getCurrentUserDepartment() 
                                : departmentComboBox.getValue();
        
        viewModel.showDepartment();
    }
    
    @FXML
    private void handleProposeNewDepartmentAction(ActionEvent event) {
        int accessLevel = schedulerModel.getCurrentUserAccessLevel();
        String departmentToPropose = accessLevel == 1 
                                   ? schedulerModel.getCurrentUserDepartment() 
                                   : newDepartmentComboBox.getValue();
        
        viewModel.showDepartment(); // You might want to create a specific view for this
    }
    
    @FXML
    private void handleStartTermAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Start Term", "Feature Not Implemented", 
                 "The Start Term functionality is not yet implemented.");
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    private void handleAddDepartmentAction(ActionEvent event) {
        viewModel.showAddDepartment();
    }
}