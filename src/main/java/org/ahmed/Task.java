package org.ahmed;

import java.util.Date;

public class Task {
    //Task Properties
    //Each task should have the following properties:
    //id: A unique identifier for the task
    //description: A short description of the task
    //status: The status of the task (todo, in-progress, done)
    //createdAt: The date and time when the task was created
    //updatedAt: The date and time when the task was last updated

    private final int id;
    private String description;
    private String status;
    private final Date createdAt;
    private Date updatedAt;

    //Constructor
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Getters
    public int getId() {return id;}
    public String getDescription() {return description;}
    public String getStatus() {return status;}
    public Date getCreatedAt() {return createdAt;}
    public Date getUpdatedAt() {return updatedAt;}

    // Setters
    public void setDescription(String description) {this.description = description; this.updatedAt =new Date();}
    public void setStatus(String status) {this.status = status; this.updatedAt = new Date();}

    //toString
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
