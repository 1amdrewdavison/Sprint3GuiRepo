package guiModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SchedulerModel {
    
    private String currentUserId;
    private int currentUserAccessLevel; // 0=Student, 1=Department Chair, 2=Registrar
    private String currentUserDepartment;
    private String selectedDepartment;
    private String selectedTerm;
    
    public SchedulerModel() {}
    
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
}