package views;

import guiModels.SchedulerModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DepartmentController {
	
	SchedulerModel model;
	
    private SimpleStringProperty statusTextProperty = new SimpleStringProperty("");
	
	@FXML
	private TextArea statusBar;
	
	@FXML
	private Label departmentNameLabel;
	
	public DepartmentController() {
		
	}

	public void setModel(SchedulerModel model) {
		// TODO Auto-generated method stub
		this.model = model;
	      
		Bindings.bindBidirectional(statusBar.textProperty(), statusTextProperty);
	}
	
	@FXML
    void addCourse(ActionEvent event) {
    	
    }
	
	@FXML
    void addConstraint(ActionEvent event) {
    	
    }
	
	@FXML
    void validateSchedule(ActionEvent event) {
    	setStatus("Schedule validated.");
    }
	
	@FXML
    void markAsComplete(ActionEvent event) {
    	setStatus("Department schedule marked as complete.");
    }

	void setStatus(String status) {
		statusTextProperty.set(status + "\n" + statusTextProperty.get());
	}
}
