package guiModels;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import views.AddDepartmentController;
import views.CatalogController;
import views.ConstraintController;
import views.CreateCourseController;
import views.CurrentTermController;
import views.DepartmentController;
import views.HomeController;
import views.LoginController;
import views.MainController;
import views.ModifyCourseController;
import views.StartTermController;

public class ViewTransitionModel {

	BorderPane mainview;
	public SchedulerModel schedulerModel;
	BorderPane departmentView;
    private MainController mainController;
	
	public ViewTransitionModel(BorderPane mainview, SchedulerModel model) {
		this.mainview = mainview;
		this.schedulerModel = model;
	}
	
	public void setMainController(MainController controller) {
        this.mainController = controller;
    }
	
    public void showDepartment() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
        
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/DepartmentView.fxml"));
	    try {
	      BorderPane view = loader.load();
	      mainview.setCenter(view);
	      departmentView = view;
	      DepartmentController cont = loader.getController();
	      cont.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	    
    public void showDepartment(String departmentStatusUpdate) {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
    	
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/DepartmentView.fxml"));
	    try {
	      BorderPane view = loader.load();
	      mainview.setCenter(view);
	      departmentView = view;
	      DepartmentController cont = loader.getController();
	      cont.setModel(this);
	      cont.setStatus(departmentStatusUpdate);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void showCourseModification() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/CourseModificationView.fxml"));
	    try {
	      Pane view = loader.load();
	      departmentView.setCenter(view);
	      ModifyCourseController cont = loader.getController();
	      cont.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void showCourseModification(Course course) {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/CourseModificationView.fxml"));
	    try {
	      Pane view = loader.load();
	      departmentView.setCenter(view);
	      ModifyCourseController cont = loader.getController();
	      cont.setModel(this);
	      cont.setCourse(course);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void showConstraintModification() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/ConstraintModificationView.fxml"));
	    try {
	      Pane view = loader.load();
	      departmentView.setCenter(view);
	      ConstraintController cont = loader.getController();
	      cont.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void showInitializeCourse() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/InitializeCourseView.fxml"));
	    try {
	      Pane view = loader.load();
	      departmentView.setCenter(view);
	      CreateCourseController cont = loader.getController();
	      cont.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
    
    public void showLogin() {
        // Hide the top navigation when showing login
        if (mainController != null) {
            mainController.showNavigationElements(false);
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/LoginView.fxml"));
        try {
          Pane view = loader.load();
          mainview.setCenter(view);
          LoginController cont = loader.getController();
          cont.setModels(this, schedulerModel);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public void showHome() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
            mainController.setUserIdDisplay(schedulerModel.getCurrentUserId());
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/HomeView.fxml"));
        try {
            BorderPane view = loader.load();
            mainview.setCenter(view);
            HomeController cont = loader.getController();
            cont.setModels(this, schedulerModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showViewCurrentTerm() {
        showCurrentTerm();
    }

    public void showCatalog() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/CatalogView.fxml"));
        try {
            BorderPane view = loader.load();
            mainview.setCenter(view);
            CatalogController cont = loader.getController();
            cont.setModels(this, schedulerModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showViewCatalog() {
        showCatalog();
    }
    
    public void showCurrentTerm() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/CurrentTermView.fxml"));
        try {
            BorderPane view = loader.load();
            mainview.setCenter(view);
            CurrentTermController cont = loader.getController();
            cont.setModels(this, schedulerModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showAddDepartment() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/AddDepartmentView.fxml"));
        try {
            BorderPane view = loader.load();
            mainview.setCenter(view);
            AddDepartmentController cont = loader.getController();
            cont.setModels(this, schedulerModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showStartTerm() {
        if (mainController != null) {
            mainController.showNavigationElements(true);
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewTransitionModel.class
            .getResource("../views/StartTermView.fxml"));
        try {
            BorderPane view = loader.load();
            mainview.setCenter(view);
            StartTermController cont = loader.getController();
            cont.setModels(this, schedulerModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
