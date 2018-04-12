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

    private ArrayList<String> participatorIDs;

    private ArrayList<Task> taskList;

    private String creationTime;

    private ArrayList<Dotos> dotosList;

    public ArrayList<Dotos> getDotosList() {
        return dotosList;
    }

    public void setDotosList(ArrayList<Dotos> dotosList) {
        this.dotosList = dotosList;
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
