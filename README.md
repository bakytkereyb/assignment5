# IT company assignment 5
## PostgreSQL
```SQL
CREATE TABLE projects (
	project_id INT,
	name VARCHAR(255),
	totalCost INT,
	PRIMARY KEY(project_id)
); 

CREATE TABLE employees (
	emp_id INT,
	name VARCHAR(255),
	address VARCHAR(255),
	department VARCHAR(255),
	empType VARCHAR(255),
	salary INT,
	project_id INT,
	PRIMARY KEY(emp_id),
	FOREIGN KEY(project_id) REFERENCES projects(project_id)
);
```
