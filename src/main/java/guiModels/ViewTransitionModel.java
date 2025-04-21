package guiModels;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.ConstraintController;
import views.CreateCourseController;
import views.DepartmentController;
import views.MainController;
import views.ModifyCourseController;

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
		// Show the top navigation when showing department
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
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
	    
    public void showDepartment(String departmentStatusUpdate) {
    	// Show the top navigation when showing department
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
	      // TODO Auto-generated catch block
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
	      // TODO Auto-generated catch block
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
	      // TODO Auto-generated catch block
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
	      // TODO Auto-generated catch block
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
	      // TODO Auto-generated catch block
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
	          cont.setModels(this, model);
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	    }
	    
	    public void showHome() {
	        // Show the top navigation when showing home
	        if (mainController != null) {
	            mainController.showNavigationElements(true);
	            mainController.setUserIdDisplay(model.getCurrentUserId());
	        }
	        
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(ViewTransitionModel.class
	            .getResource("../views/HomeView.fxml"));
	        try {
	            BorderPane view = loader.load();
	            mainview.setCenter(view);
	            HomeController cont = loader.getController();
	            cont.setModels(this, model);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void showViewCurrentTerm() {
	        showCurrentTerm();
	    }

	    public void showCatalog() {
	        // Show the top navigation
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
	            cont.setModels(this, model);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void showViewCatalog() {
	        showCatalog();
	    }
	    
	    public void showCurrentTerm() {
	        // Show the top navigation
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
	            cont.setModels(this, model);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void showAddDepartment() {
	        // Show the top navigation
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
	            cont.setModels(this, model);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
