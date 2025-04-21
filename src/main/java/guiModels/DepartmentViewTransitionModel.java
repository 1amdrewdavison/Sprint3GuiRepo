package guiModels;

import javafx.scene.layout.BorderPane;

public class DepartmentViewTransitionModel {

	BorderPane mainview;
	DepartmentModel model;
	
	public DepartmentViewTransitionModel(BorderPane mainview, DepartmentModel model) {
		this.mainview = mainview;
		this.model = model;
	}
	
	public void showCourseModification() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(DepartmentViewTransitionModel.class
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
	    loader.setLocation(DepartmentViewTransitionModel.class
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
	    loader.setLocation(DepartmentViewTransitionModel.class
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
