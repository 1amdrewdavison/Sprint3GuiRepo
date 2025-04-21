package views;

import guiModels.Course;
import guiModels.ViewTransitionModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ModifyCourseController {
	
	ViewTransitionModel model;
	Course course;
	
	@FXML
    private TextField courseNumber;
	
	private SimpleStringProperty courseNumberData  = new SimpleStringProperty();

    @FXML
    private TextField courseSection;
    
	private SimpleStringProperty courseSectionData  = new SimpleStringProperty();

    @FXML
    private TextField courseTitle;
    
	private SimpleStringProperty courseTitleData  = new SimpleStringProperty();

    @FXML
    private MenuButton crosslistedDropdown;

    @FXML
    private MenuButton falseLimit;

    @FXML
    private MenuButton instructorDropdown;

    @FXML
    private TextField instructorRawEntry;
    
	private SimpleStringProperty instructorData  = new SimpleStringProperty();

    @FXML
    private MenuButton roomDropdown;

    @FXML
    private TextField roomRawEntry;
    
	private SimpleStringProperty roomData  = new SimpleStringProperty();

    @FXML
    private Button submitChangesButton;

    @FXML
    private MenuButton tiemDropdown;

    @FXML
    private TextField timeRawEntry;
    
	private SimpleStringProperty timeData  = new SimpleStringProperty();

	
	public ModifyCourseController() {
		
	}

	public void setModel(ViewTransitionModel viewTransitionModel) {
		this.model = viewTransitionModel;
				
		Bindings.bindBidirectional(courseNumber.textProperty(), courseNumberData);
		Bindings.bindBidirectional(courseSection.textProperty(), courseSectionData);
		Bindings.bindBidirectional(courseTitle.textProperty(), courseTitleData);
		Bindings.bindBidirectional(instructorRawEntry.textProperty(), instructorData);
		Bindings.bindBidirectional(roomRawEntry.textProperty(), roomData);
		Bindings.bindBidirectional(timeRawEntry.textProperty(), timeData);
	}

    @FXML
    void submitChanges(ActionEvent event) {
    	model.showDepartment("Changes submitted");
    }
    
    public void setCourse(Course course) {
    	this.course = course;
    	
    	this.courseNumberData.set(course.getCourseNumber());
    	this.courseSectionData.set(course.getSection());
    	this.courseTitleData.set(course.getTitle());
    	this.instructorData.set(course.getInstructor());
    	this.roomData.set(course.getRoom());
    	this.timeData.set(course.getMeetingTime());
    }
}
