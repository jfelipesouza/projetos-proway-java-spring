package tasks.entity;

public class Tasks {
	private String taskName,description;
	private int id,userreference;
	
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserreference() {
		return userreference;
	}
	public void setUserreference(int userreference) {
		this.userreference = userreference;
	}
	@Override
	public String toString() {
		return "Tasks [taskName=" + taskName + ", description=" + description  + ", userreference="
				+ userreference + "]";
	}
	
	public Tasks(String taskName, String description,int userreference) {
		this.taskName = taskName;
		this.description = description;
		this.userreference = userreference;
	}

	public Tasks() {

	}
	
}
