package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class AddDepartmentController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private TreeView<String> catalogTreeView;
    
    @FXML
    private ComboBox<String> departmentComboBox;
    
    @FXML
    private ComboBox<String> termComboBox;
    
    @FXML
    private Button selectButton;
    
    @FXML
    private TextArea departmentInfoTextArea;
    
    @FXML
    private Button backButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
        
        loadCatalogData();
        
        ObservableList<String> departments = FXCollections.observableArrayList(
            "Computer Science", "Mathematics", "Physics", "Chemistry", "Biology"
        );
        departmentComboBox.setItems(departments);
        
        ObservableList<String> terms = FXCollections.observableArrayList(
            "Fall 2024", "Spring 2025"
        );
        termComboBox.setItems(terms);
        termComboBox.setValue("Spring 2025");
        
        departmentComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateDepartmentInfo(newVal, termComboBox.getValue());
        });
        
        termComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            updateDepartmentInfo(departmentComboBox.getValue(), newVal);
        });
    }
    
    private void loadCatalogData() {
        TreeItem<String> rootItem = new TreeItem<>("Catalog");
        rootItem.setExpanded(true);
        
        TreeItem<String> fall2024 = new TreeItem<>("Fall 2024");
        TreeItem<String> spring2025 = new TreeItem<>("Spring 2025");
        
        TreeItem<String> csFall = new TreeItem<>("Computer Science");
        TreeItem<String> mathFall = new TreeItem<>("Mathematics");
        
        TreeItem<String> csSpring = new TreeItem<>("Computer Science");
        TreeItem<String> mathSpring = new TreeItem<>("Mathematics");
        TreeItem<String> physicsSpring = new TreeItem<>("Physics");
        
        csFall.getChildren().addAll(
            new TreeItem<>("CS 101 - Introduction to Programming"),
            new TreeItem<>("CS 201 - Data Structures"),
            new TreeItem<>("CS 330 - Computer Architecture")
        );
        
        mathFall.getChildren().addAll(
            new TreeItem<>("MATH 120 - Calculus I"),
            new TreeItem<>("MATH 220 - Linear Algebra")
        );
        
        csSpring.getChildren().addAll(
            new TreeItem<>("CS 102 - Advanced Programming"),
            new TreeItem<>("CS 240 - Algorithms"),
            new TreeItem<>("CS 360 - Database Systems")
        );
        
        mathSpring.getChildren().addAll(
            new TreeItem<>("MATH 121 - Calculus II"),
            new TreeItem<>("MATH 320 - Differential Equations")
        );
        
        physicsSpring.getChildren().addAll(
            new TreeItem<>("PHYS 150 - Introduction to Mechanics"),
            new TreeItem<>("PHYS 250 - Electricity and Magnetism")
        );
        
        fall2024.getChildren().addAll(csFall, mathFall);
        spring2025.getChildren().addAll(csSpring, mathSpring, physicsSpring);
        
        rootItem.getChildren().addAll(fall2024, spring2025);
        
        catalogTreeView.setRoot(rootItem);
        catalogTreeView.setShowRoot(false);
        
        fall2024.setExpanded(true);
        spring2025.setExpanded(true);
        
        catalogTreeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                TreeItem<String> parent = newValue.getParent();
                if (parent != null && (parent.getValue().equals("Fall 2024") || parent.getValue().equals("Spring 2025"))) {
                    String departmentName = newValue.getValue();
                    departmentComboBox.setValue(departmentName);
                    String termName = parent.getValue();
                    termComboBox.setValue(termName);
                } else if (parent != null && parent.getParent() != null && 
                          (parent.getParent().getValue().equals("Fall 2024") || 
                           parent.getParent().getValue().equals("Spring 2025"))) {
                    String departmentName = parent.getValue();
                    departmentComboBox.setValue(departmentName);
                    String termName = parent.getParent().getValue();
                    termComboBox.setValue(termName);
                }
            }
        });
    }
    
    private void updateDepartmentInfo(String department, String term) {
        if (department == null || term == null) {
            departmentInfoTextArea.setText("");
            return;
        }
        
        StringBuilder info = new StringBuilder();
        info.append("Department: ").append(department).append("\n");
        info.append("Term: ").append(term).append("\n\n");
        
        if (term.equals("Fall 2024")) {
            if (department.equals("Computer Science")) {
                info.append("Courses:\n");
                info.append("- CS 101 - Introduction to Programming (3 credits)\n");
                info.append("- CS 201 - Data Structures (4 credits)\n");
                info.append("- CS 330 - Computer Architecture (3 credits)\n");
            } else if (department.equals("Mathematics")) {
                info.append("Courses:\n");
                info.append("- MATH 120 - Calculus I (4 credits)\n");
                info.append("- MATH 220 - Linear Algebra (3 credits)\n");
            }
        } else if (term.equals("Spring 2025")) {
            if (department.equals("Computer Science")) {
                info.append("Courses:\n");
                info.append("- CS 102 - Advanced Programming (3 credits)\n");
                info.append("- CS 240 - Algorithms (4 credits)\n");
                info.append("- CS 360 - Database Systems (3 credits)\n");
            } else if (department.equals("Mathematics")) {
                info.append("Courses:\n");
                info.append("- MATH 121 - Calculus II (4 credits)\n");
                info.append("- MATH 320 - Differential Equations (3 credits)\n");
            } else if (department.equals("Physics")) {
                info.append("Courses:\n");
                info.append("- PHYS 150 - Introduction to Mechanics (4 credits)\n");
                info.append("- PHYS 250 - Electricity and Magnetism (4 credits)\n");
            }
        }
        
        departmentInfoTextArea.setText(info.toString());
    }
    
    @FXML
    private void handleSelectAction(ActionEvent event) {
        String selectedDepartment = departmentComboBox.getValue();
        String selectedTerm = termComboBox.getValue();
        
        if (selectedDepartment == null) {
            departmentInfoTextArea.setText("Please select a department first.");
            return;
        }
        
        schedulerModel.setSelectedDepartment(selectedDepartment);
        schedulerModel.setSelectedTerm(selectedTerm);
        
        viewModel.showDepartment();
        
        //you can access the selected department and term from the SchedulerModel
        //using schedulerModel.getSelectedDepartment() and schedulerModel.getSelectedTerm()
    }
    
    @FXML
    private void handleBackAction(ActionEvent event) {
        viewModel.showHome();
    }
}