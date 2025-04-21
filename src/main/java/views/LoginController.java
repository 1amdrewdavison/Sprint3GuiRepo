package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private TextField idField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button submitButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
    }
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        //System.out.println("Login button clicked"); // Debugging output
        
        String id = idField.getText();
        String password = passwordField.getText();
        
        if (id.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Login Failed", "ID and Password cannot be empty.");
            return;
        }
        
        // Simple login logic based on ID prefix
        // S = Student, D = Department Chair, R = Registrar
        int accessLevel = 0; // Default: Student
        String department = "";
        
        if (id.startsWith("S")) {
            accessLevel = 0; // Student
        } else if (id.startsWith("D")) {
            accessLevel = 1; // Department Chair
            department = determineDepartment(id);
        } else if (id.startsWith("R")) {
            accessLevel = 2; // Registrar
        }
        
        schedulerModel.setCurrentUser(id, accessLevel, department);
        
        viewModel.showHome();
    }
    
    private String determineDepartment(String id) {
        switch (id) {
            case "D001":
                return "Computer Science";
            case "D002":
                return "Mathematics";
            case "D003":
                return "Physics";
            case "D004":
                return "Chemistry";
            case "D005":
                return "Biology";
            default:
                return "Unknown Department";
        }
    }
    
    private void showAlert(AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}