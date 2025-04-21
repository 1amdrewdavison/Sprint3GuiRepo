package views;

import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ConstraintController {
    
    ViewTransitionModel model;
    
    public ConstraintController() {
        
    }

    public void setModel(ViewTransitionModel model) {
        // TODO Auto-generated method stub
        this.model = model;
    }
    
    @FXML
    private Button submitChangesButton;

    @FXML
    void submitChanges(ActionEvent event) {
        model.showDepartment("Changes submitted");
    }
}
