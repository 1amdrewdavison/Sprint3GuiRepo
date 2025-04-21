package guiModels;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.ConstraintController;
import views.CreateCourseController;
import views.DepartmentController;
import views.ModifyCourseController;

public class ViewTransitionModel {

	BorderPane mainview;
	public SchedulerModel schedulerModel;
	BorderPane departmentView;
	
	public ViewTransitionModel(BorderPane mainview, SchedulerModel model) {
		this.mainview = mainview;
		this.schedulerModel = model;
	}
	
	public void showDepartment() {
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
		
	}
	
	public void showHome() {
		
	}
}
