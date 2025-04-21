package views;

import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ModifyCourseController {
	
	ViewTransitionModel model;
	
	public ModifyCourseController() {
		
	}

	public void setModel(ViewTransitionModel viewTransitionModel) {
		this.model = viewTransitionModel;
	}
	
	@FXML
    private Button submitChangesButton;

    @FXML
    void submitChanges(ActionEvent event) {
    	model.showDepartment("Changes submitted");
    }
}
