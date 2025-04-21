package guiModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SchedulerModel {
	ObservableList<Course> courses = FXCollections.observableArrayList();
    
    private String currentUserId;
    private int currentUserAccessLevel; // 0=Student, 1=Department Chair, 2=Registrar
    private String currentUserDepartment;
    private String selectedDepartment;
    private String selectedTerm;
	
	public SchedulerModel() {
		Course mockCourse = new Course("Intro to CS", "a", "101", "William, Bailey", "Olin 101", "MWF 8-9");
		Course mockCourse2 = new Course("Software Design", "a", "360", "Bradshaw, Michael", "Olin 101", "MWF 8-9");
		courses.add(mockCourse);
		courses.add(mockCourse2);
	}
	
	public void setCurrentUser(String userId, int accessLevel, String department) {
    
    public void setCurrentUser(String userId, int accessLevel, String department) {
        this.currentUserId = userId;
        this.currentUserAccessLevel = accessLevel;
        this.currentUserDepartment = department;
    }
    
    public String getCurrentUserId() {
        return currentUserId;
    }
    
    public int getCurrentUserAccessLevel() {
        return currentUserAccessLevel;
    }
    
    public String getCurrentUserDepartment() {
        return currentUserDepartment;
    }
    

    public void setSelectedDepartment(String department) {
    	this.selectedDepartment = department;
    }

    public String getSelectedDepartment() {
    	return selectedDepartment;
    }

    public void setSelectedTerm(String term) {
    	this.selectedTerm = term;
    }

    public String getSelectedTerm() {
    	return selectedTerm;
    }

	
	public ObservableList<Course> getCourses() {
		return courses;
	}
	
	public ObservableList<String> getConstraints() {
		ObservableList<String> returnConstraints = FXCollections.observableArrayList();
		returnConstraints.add("Constraint One");
		returnConstraints.add("Constraint Two");
		returnConstraints.add("Constraint Three");
		returnConstraints.add("Constraint Four");
		return returnConstraints;
	}
	
}

}