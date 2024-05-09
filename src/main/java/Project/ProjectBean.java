package Project;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class ProjectBean implements Serializable
{
	
	private String projectId;
	private String projectTitle;
	private Date date;
	private Integer List_of_TODO;
	private String email_id;
	private Integer complted_todo;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getList_of_TODO() {
		return List_of_TODO;
	}
	public void setList_of_TODO(Integer list_of_TODO) {
		List_of_TODO = list_of_TODO;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Integer getComplted_todo() {
		return complted_todo;
	}
	public void setComplted_todo(Integer complted_todo) {
		this.complted_todo = complted_todo;
	}
	
	
	
	
	
	
	
	

}
