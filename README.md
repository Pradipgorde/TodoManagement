# TodoManagement


Develop an application to manage todos with the following capabilities:

1. Create a new project.
2. Manage todos within a project (Add, Edit, Update, and Mark as complete).
3. Export the project summary as a gist on GitHub.

Generate the project summary in markdown format and export the content as a secret gist.
The exported gist should follow this format:

• File name: <Project title>.md (Markdown)

• Project title as heading.

• Summary: <No. of completed todos> / <No. of total todos> completed.

• Section 1: Task list of pending todos (with an open checkbox).
• Section 2: Task list of completed todos (with a checked box).

Sample format:

Expectations
1. Selected schema/representation should include:
a. Project: Unique Id, Title, Created Date, List of Todos.
b. Todo: Unique Id, Description, Status, Created Date, Updated Date.
2. Basic Auth for user login.
3. Home page provisions:
a. Create a new project.
b. List all projects.
c. View a project.
4. Detailed project view should include:
a. Project title (Editable).
b. List of todos with description, date, and completion status.
c. Actions to Add/Update/Remove a todo.
d. Mark a todo as pending or complete.

# Explanation.
•	Description: - App manage user Todos in project i.e. one user can create multiple project, in single project user can create multiple todos as per project needs. Todos having option like its pending, complete as per user needs user can select this option for future understanding. User can edit todos, delete todos. Also I have provide function likes todos have created date as well updated date.
