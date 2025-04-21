package views;

import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CreateCourseController {
	
	ViewTransitionModel model;
	
	public CreateCourseController() {
		
	}

	public void setModel(ViewTransitionModel viewTransitionModel) {
		// TODO Auto-generated method stub
		this.model = viewTransitionModel;
	}
	
	@FXML
    private Button submitNewCourseButton;

    @FXML
    private Button submitTemplateCourseButton;

    @FXML
    void submitNewCourse(ActionEvent event) {
    	model.showCourseModification();
    }

    @FXML
    void submitTemplateCourse(ActionEvent event) {
    	model.showCourseModification();
    }
}
