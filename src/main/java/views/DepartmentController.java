package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DepartmentController {
	
	ViewTransitionModel model;
	
    private SimpleStringProperty statusTextProperty = new SimpleStringProperty("");
	
	@FXML
	private TextArea statusBar;
	
	@FXML
	private Label departmentNameLabel;
	
	public DepartmentController() {
		
	}

	public void setModel(ViewTransitionModel model) {
		// TODO Auto-generated method stub
		this.model = model;
	      
		statusBar.editableProperty().set(false);
		Bindings.bindBidirectional(statusBar.textProperty(), statusTextProperty);
	}
	
	@FXML
    void addCourse(ActionEvent event) {
    	model.showInitializeCourse();
    }
	
	@FXML
    void addConstraint(ActionEvent event) {
    	model.showConstraintModification();
    }
	
	@FXML
    void modifyCourse(ActionEvent event) {
    	model.showCourseModification();
    }
	
	@FXML
    void validateSchedule(ActionEvent event) {
    	setStatus("Schedule validated.");
    }
	
	@FXML
    void markAsComplete(ActionEvent event) {
    	setStatus("Department schedule marked as complete.");
    }

	public void setStatus(String status) {
		statusTextProperty.set(status + "\n" + statusTextProperty.get());
	}
}
