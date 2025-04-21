package views;

import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

public class MainController {
  
	ViewTransitionModel model;

	@FXML
    private Button homeButton;
	
	@FXML
    private Button logoutButton;
	
	@FXML
    private Label idDisplay;
	
    public void setModel(ViewTransitionModel newModel) {
    	model=newModel;
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

    }
}