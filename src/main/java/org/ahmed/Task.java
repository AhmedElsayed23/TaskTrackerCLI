package org.ahmed;

import java.time.LocalDateTime;

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
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Constructor
    public Task(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public int getId() {return id;}
    public String getDescription() {return description;}
    public String getStatus() {return status;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}

    // Setters
    public void setDescription(String description) {this.description = description; this.updatedAt = LocalDateTime.now();}
    public void setStatus(String status) {this.status = status; this.updatedAt = LocalDateTime.now();}

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
