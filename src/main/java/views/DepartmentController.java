package views;

import java.util.ArrayList;

import guiModels.Course;
import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class DepartmentController {
	
	ViewTransitionModel model;
	
    private SimpleStringProperty statusTextProperty = new SimpleStringProperty("");
	
    @FXML
    private Button addConstraintButton;

    @FXML
    private Button addCourseButton;

    @FXML
    private Button completeButton;
    
	@FXML
	private TextArea statusBar;
	
	@FXML
	private Label departmentNameLabel;

    @FXML
    private Button validateScheduleButton;
    
    @FXML
    private Button editCourseSelectionButton;

    @FXML
    private ListView<String> constraintList;
    
    //Display
    @FXML
    private ListView<String> courseListDisplay;
	
    //Actual Data
    
    private ObservableList<Course> courseListReal;
    
	public DepartmentController() {

	}

	public void setModel(ViewTransitionModel model) {
		// TODO Auto-generated method stub
		this.model = model;
		courseListReal = FXCollections.observableArrayList();
		
		ObservableList<Course> courses = model.schedulerModel.getCourses();
		ObservableList<String> returnCourses = FXCollections.observableArrayList();
		for (Course course : courses) {
			returnCourses.add(course.toString());
		}
		
		courseListDisplay.setItems(returnCourses);
		courseListReal.addAll(courses);
		
		constraintList.setItems(model.schedulerModel.getConstraints());
		
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
	
	@FXML
    void editCourseSelection(ActionEvent event) {
        ObservableList<Integer> selectedItems = courseListDisplay.getSelectionModel().getSelectedIndices();
        model.showCourseModification(courseListReal.get(selectedItems.get(0)));
    }
}
