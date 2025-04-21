package guiModels;

public class Course {
	String title;
	String section;
	String courseNumber;
	String instructor;
	String room;
	String meetingTime;
	
	public Course(String title, String section, String courseNumber, String instructor, String room, String meetingTime) {
		super();
		this.title = title;
		this.section = section;
		this.courseNumber = courseNumber;
		this.instructor = instructor;
		this.room = room;
		this.meetingTime = meetingTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	@Override
	public String toString() {
		return title + " " + courseNumber + "-" + section;
	}
	
	
}
