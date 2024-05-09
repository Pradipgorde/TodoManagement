package todo;

import java.io.Serializable;
import java.sql.Date;



@SuppressWarnings("serial")
public class TodoBean implements Serializable
{
	
	private String todo_id;
	private String Descption;
	private String Status ;
	private Date createOn;
	private Date update;
	private String email;
	private String ProjectId;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(String todo_id) {
		this.todo_id = todo_id;
	}
	public String getDescption() {
		return Descption;
	}
	public void setDescption(String descption) {
		Descption = descption;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
		

}
