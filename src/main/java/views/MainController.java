package views;

import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

public class MainController {
  
    ViewTransitionModel model;

    @FXML
    private Button homeButton;
    
    @FXML
    private Button logoutButton;
    
    @FXML
    private Label idDisplay;
    
    @FXML
    private AnchorPane topPane;
    
    public void setModel(ViewTransitionModel newModel) {
        model = newModel;
        model.setMainController(this);
    }
    
    public void setUserIdDisplay(String userId) {
        idDisplay.setText("ID: " + userId);
    }
    
    public void showNavigationElements(boolean show) {
        topPane.setVisible(show);
        topPane.setManaged(show);
    }
    
    @FXML
    void onClickDepartment(ActionEvent event) {
        model.showDepartment();
    }

    @FXML
    void logout(ActionEvent event) {
        model.showLogin();
    }

    @FXML
    void navigateHome(ActionEvent event) {
        model.showHome();
    }
}