package views;

import guiModels.SchedulerModel;
import guiModels.ViewTransitionModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class CatalogController {
    
    private ViewTransitionModel viewModel;
    private SchedulerModel schedulerModel;
    
    @FXML
    private TreeView<String> catalogTreeView;
    
    @FXML
    private Button backButton;
    
    public void setModels(ViewTransitionModel viewModel, SchedulerModel schedulerModel) {
        this.viewModel = viewModel;
        this.schedulerModel = schedulerModel;
        
        // Initialize the catalog data
        loadCatalogData();
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
    }
    
    @FXML
    private void handleBackAction(ActionEvent event) {
        viewModel.showHome();
    }
}