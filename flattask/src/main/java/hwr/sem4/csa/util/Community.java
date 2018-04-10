package hwr.sem4.csa.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Communities")
public class Community {
    @Id
    private String id;
    @Column(name = "ParticipatorIDs")
    private ArrayList<String> participatorIDs;
    @Column(name = "TaskObjects")
    private ArrayList<Task> taskList;
    @Column(name = "Time_of_creation")
    private String creationTime;
    @Column(name = "ToDoObjects")
    private ArrayList<ToDo> toDoList;

    public ArrayList<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getParticipatorIDs() {
        return participatorIDs;
    }

    public void setParticipatorIDs(ArrayList<String> participatorIDs) {
        this.participatorIDs = participatorIDs;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
