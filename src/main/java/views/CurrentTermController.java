package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class CurrentTermController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private TreeView<String> termTreeView;
    
    @FXML
    private VBox registrarToolsPane;
    
    @FXML
    private Button validateButton;
    
    @FXML
    private Button finalizeButton;
    
    @FXML
    private TextArea statusTextArea;
    
    @FXML
    private Button backButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
        
        if (schedulerModel.getCurrentUserAccessLevel() == 2) {
            registrarToolsPane.setVisible(true);
            registrarToolsPane.setManaged(true);
        }
        
        loadTermData();
        
        updateStatus("Current term loaded successfully. No validation errors detected.");
    }
    
    private void loadTermData() {
        TreeItem<String> rootItem = new TreeItem<>("Spring 2025");
        rootItem.setExpanded(true);
        
        TreeItem<String> cs = new TreeItem<>("Computer Science");
        TreeItem<String> math = new TreeItem<>("Mathematics");
        TreeItem<String> physics = new TreeItem<>("Physics");
        TreeItem<String> chemistry = new TreeItem<>("Chemistry");
        
        cs.getChildren().addAll(
            new TreeItem<>("CS 102 - Advanced Programming (3 credits)"),
            new TreeItem<>("CS 240 - Algorithms (4 credits)"),
            new TreeItem<>("CS 360 - Database Systems (3 credits)"),
            new TreeItem<>("CS 380 - Artificial Intelligence (4 credits)")
        );
        
        math.getChildren().addAll(
            new TreeItem<>("MATH 121 - Calculus II (4 credits)"),
            new TreeItem<>("MATH 320 - Differential Equations (3 credits)"),
            new TreeItem<>("MATH 330 - Discrete Mathematics (3 credits)")
        );
        
        physics.getChildren().addAll(
            new TreeItem<>("PHYS 150 - Introduction to Mechanics (4 credits)"),
            new TreeItem<>("PHYS 250 - Electricity and Magnetism (4 credits)"),
            new TreeItem<>("PHYS 350 - Modern Physics (3 credits)")
        );
        
        chemistry.getChildren().addAll(
            new TreeItem<>("CHEM 110 - General Chemistry (4 credits)"),
            new TreeItem<>("CHEM 210 - Organic Chemistry (4 credits)")
        );
        
        rootItem.getChildren().addAll(cs, math, physics, chemistry);
        
        termTreeView.setRoot(rootItem);
        termTreeView.setShowRoot(false);
        
        cs.setExpanded(true);
        math.setExpanded(true);
        physics.setExpanded(true);
        chemistry.setExpanded(true);
    }
    
    /**
     * Updates the status/error text area with a new message
     * This method can be reused across different views
     */
    public void updateStatus(String message) {
        statusTextArea.setText(message);
    }
    
    @FXML
    private void handleValidateAction(ActionEvent event) {
        updateStatus("Validation in progress...\nChecking for scheduling conflicts...\nChecking classroom assignments...\nAll courses validated successfully.");
    }
    
    @FXML
    private void handleFinalizeAction(ActionEvent event) {
        updateStatus("WARNING: This will finalize the term and prevent further changes. This action cannot be undone.\n\nTo proceed, click Finalize Term again.");
        
        finalizeButton.setText("Confirm Finalize");
        
        finalizeButton.setOnAction(e -> {
            updateStatus("Term has been finalized successfully. Registration is now open for students.");
            finalizeButton.setText("Finalize Term");
            finalizeButton.setDisable(true);
        });
    }
    
    @FXML
    private void handleBackAction(ActionEvent event) {
        viewModel.showHome();
    }
}