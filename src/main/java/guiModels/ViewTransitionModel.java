package guiModels;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.ConstraintController;
import views.CourseController;
import views.DepartmentController;

public class ViewTransitionModel {

	BorderPane mainview;
	SchedulerModel model;
	
	public ViewTransitionModel(BorderPane mainview, SchedulerModel model) {
		this.mainview = mainview;
		this.model = model;
	}
	
	public void showDepartment() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/DepartmentView.fxml"));
	    try {
	      Pane view = loader.load();
	      mainview.setCenter(view);
	      DepartmentController cont = loader.getController();
	      cont.setModel(model);
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
	      mainview.setCenter(view);
	      CourseController cont = loader.getController();
	      cont.setModel(model);
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
	      mainview.setCenter(view);
	      ConstraintController cont = loader.getController();
	      cont.setModel(model);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
	
	public void showInitializeCourse() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ViewTransitionModel.class
	        .getResource("../views/CourseModificationView.fxml"));
	    try {
	      Pane view = loader.load();
	      mainview.setCenter(view);
	      CourseController cont = loader.getController();
	      cont.setModel(model);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
}
