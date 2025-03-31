# Task Tracker CLI

Task Tracker is a command-line application for managing tasks. It allows users to add, update, delete, and track the status of their tasks using a simple CLI interface. Tasks are stored in a JSON file for persistence.

## Features
- Add new tasks
- Update task descriptions
- Delete tasks
- Mark tasks as in progress or done
- List all tasks
- List tasks by status (todo, in-progress, done)

## Requirements
- Java 11 or later
- Gson library (`gson-2.10.1.jar`)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/task-tracker.git
   cd task-tracker
   ```
2. Download and place `gson-2.10.1.jar` in the project directory.
3. Compile the project:
   ```sh
   javac -cp gson-2.10.1.jar -d bin src/com/tasktracker/*.java
   ```

## Usage
Run the application from the command line:

### Add a Task
```sh
task-cli add "Buy groceries"
```
**Output:** `Task added successfully (ID: 1)`

### Update a Task
```sh
task-cli update 1 "Buy groceries and cook dinner"
```

### Delete a Task
```sh
task-cli delete 1
```

### Mark a Task as In Progress
```sh
task-cli mark-in-progress 1
```

### Mark a Task as Done
```sh
task-cli mark-done 1
```

### List All Tasks
```sh
task-cli list
```

### List Tasks by Status
```sh
task-cli list done
```
```sh
task-cli list todo
```
```sh
task-cli list in-progress
```

## Error Handling
- Invalid commands will prompt a usage message.
- Invalid task IDs will display an appropriate error.

## License
This project is licensed under the MIT License.

## Author
Ahmed Elsayed