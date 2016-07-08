SET FOREIGN_KEY_CHECKS = 0
GO
DROP DATABASE IF EXISTS employee_app
GO
CREATE DATABASE IF NOT EXISTS employee_app
GO
ALTER SCHEMA employee_app  DEFAULT CHARACTER SET utf8 
GO
USE employee_app
GO
DROP TABLE IF EXISTS employee
GO
CREATE TABLE IF NOT EXISTS employee 
(
  emp_id INT NOT NULL AUTO_INCREMENT ,	
  emp_first_name VARCHAR(150) NOT NULL ,
  emp_last_name VARCHAR(150) NOT NULL ,
  emp_start_date TIMESTAMP NOT NULL,
  emp_end_date TIMESTAMP,
  designation_id INT NOT NULL,
  dept_id INT NOT NULL,
  mgr_id INT ,
  update_user VARCHAR(150) NOT NULL ,
  update_date TIMESTAMP NOT NULL,
  PRIMARY KEY (emp_id) ,
  UNIQUE INDEX emp_id_UNIQUE (emp_id ASC) 
 )
GO
DROP TABLE IF EXISTS designation
GO
CREATE TABLE IF NOT EXISTS designation 
(
  designation_id INT NOT NULL AUTO_INCREMENT,
  designation_name VARCHAR(150) UNIQUE NOT NULL,
  designation_desc VARCHAR(150) UNIQUE NOT NULL,
  PRIMARY KEY (designation_id) ,
  UNIQUE INDEX designation_id_UNIQUE (designation_id ASC) 
)
GO
DROP TABLE IF EXISTS department
GO
CREATE TABLE IF NOT EXISTS department 
(
	dept_id INT NOT NULL AUTO_INCREMENT,
	dept_name VARCHAR(150) UNIQUE NOT NULL,
	dept_desc VARCHAR(250) NOT NULL,
	dept_mgr INT,
	PRIMARY KEY (dept_id) ,
    UNIQUE INDEX dept_id_UNIQUE (dept_id ASC) 
)
GO
DROP TABLE IF EXISTS project
GO
CREATE TABLE IF NOT EXISTS project
(
  project_id INT NOT NULL AUTO_INCREMENT,	
  project_name VARCHAR(150) UNIQUE NOT NULL,
  project_desc VARCHAR(250) NOT NULL,
  project_manager INT NOT NULL,
  project_startdate TIMESTAMP NOT NULL,
  project_enddate TIMESTAMP NOT NULL,
  update_user VARCHAR(150) NOT NULL ,
  update_date TIMESTAMP NOT NULL,
  PRIMARY KEY (project_id) ,
  UNIQUE INDEX project_id_UNIQUE (project_id ASC) 
)
GO
DROP TABLE IF EXISTS project_employee
GO
CREATE TABLE IF NOT EXISTS project_employee
(
  project_emp_assn_id INT NOT NULL AUTO_INCREMENT,
  project_id INT NOT NULL,
  emp_id INT NOT NULL,
  update_user VARCHAR(150) NOT NULL ,
  update_date TIMESTAMP NOT NULL,
  PRIMARY KEY (project_emp_assn_id) ,
  UNIQUE INDEX project_emp_assn_id_UNIQUE (project_emp_assn_id ASC) 
)
GO
DROP TABLE IF EXISTS role
GO
CREATE TABLE IF NOT EXISTS role
(
  role_id INT NOT NULL AUTO_INCREMENT,	
  role_name VARCHAR(150) UNIQUE NOT NULL,
  role_desc VARCHAR(250) NOT NULL,
  PRIMARY KEY (role_id) ,
  UNIQUE INDEX role_id_UNIQUE (role_id ASC) 
)
GO
DROP TABLE IF EXISTS role_employee
GO
CREATE TABLE IF NOT EXISTS role_employee
(
  role_emp_assn_id INT NOT NULL AUTO_INCREMENT,
  role_id INT NOT NULL, 
  emp_id INT NOT NULL, 
   PRIMARY KEY (role_emp_assn_id) ,
  UNIQUE INDEX role_emp_assn_id_UNIQUE (role_emp_assn_id ASC) 	
)
GO
ALTER TABLE employee ADD CONSTRAINT fk_designation_id FOREIGN KEY (designation_id) 
REFERENCES designation(designation_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE employee ADD CONSTRAINT fk_dept_id FOREIGN KEY (dept_id) 
REFERENCES department(dept_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE employee ADD CONSTRAINT fk_mgr_id FOREIGN KEY (mgr_id) 
REFERENCES employee(emp_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE department ADD CONSTRAINT fk_dept_mgr_id FOREIGN KEY (dept_mgr) 
REFERENCES employee(emp_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE project ADD CONSTRAINT fk_project_mgr_id FOREIGN KEY (project_manager) 
REFERENCES employee(emp_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE project_employee ADD CONSTRAINT fk_project_assn_project_id FOREIGN KEY (project_id) 
REFERENCES project(project_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE project_employee ADD CONSTRAINT fk_project_assn_emp_id FOREIGN KEY (emp_id) 
REFERENCES employee(emp_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE role_employee ADD CONSTRAINT fk_role_assn_role_id FOREIGN KEY (role_id) 
REFERENCES role(role_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE role_employee ADD CONSTRAINT fk_role_assn_emp_id FOREIGN KEY (emp_id) 
REFERENCES employee(emp_id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
SET FOREIGN_KEY_CHECKS = 1
GO

INSERT INTO role(`role_name`, `role_desc`) VALUES ('DEVELOPER UI', 'UI Developer/Programmer')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('DEVELOPER MIDDLEWARE', 'Middleware Developer/Programmer')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('DEVELOPER DATABASE', 'Database-Backend Developer/Programmer')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('DEVELOPER PERFORMANCE', 'Performance Tuning Developer/Programmer')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('BUSINESS ANALYST', 'Business Analysts')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('FUNCTIONAL ANALYST', 'Functional Analysts/Subject Matter Expert')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('UI DESIGNER', 'UI Designer/Graphics Artists')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('UX DESIGNER', 'User Experience Designer')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('UI TESTER', 'UI Tester')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('MIDDLEWARE TESTER', 'Middleware Tester')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('DATABASE TESTER', 'Database Tester')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('PERFORMANCE TESTER', 'Permformance Tester')
GO
INSERT INTO role(`role_name`, `role_desc`) VALUES ('EXECUTIVE', 'Executive Role')
GO
COMMIT
GO

INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('TRAINEE_PROG', 'Trainee Programmer')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('PROG', 'Programmer')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('SENIOR PROG', 'Senior Programmer')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('ASSOCIATE', 'Associate')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('SENIOR ASSOCIATE', 'Senior Associate')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('ASSOCIATE MANAGER', 'Associate Manager')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('PROJECT MANAGER', 'Project Manager')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('ASSOCIATE ARCHITECT', 'Associate Architect')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('ARCHITECT', 'Architect')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('SENIOR ARCHITECT', 'Senior Architect')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('PRINCIPLE ARCHITECT', 'Principle Architect')
GO
INSERT INTO designation(`designation_name`,`designation_desc`) VALUES ('EXECUTIVE', 'Executive - Management')
GO
COMMIT
GO

INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('SALES', 'Pre-Sales/Sales',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('MARKETING', 'Marketing and Advertisements',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('ACCOUNTING', 'Account and Finance',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('DESIGN', 'Design and Architecture',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('DEVELOPMENT', 'Development and Build',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('TESTING', 'Testing',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('QUALITY', 'Quality Assurance',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('LEGAL', 'Legal',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('HR', 'Human Resources',null)
GO
INSERT INTO department(`dept_name`,`dept_desc`,`dept_mgr`) VALUES ('EXECUTIVE', 'Executive Heads',null)
GO
COMMIT
GO

INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('John', 'Doe',CURRENT_TIMESTAMP,null,12,10,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Jane', 'Doe',CURRENT_TIMESTAMP,null,12,10,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Tony', 'Sell',CURRENT_TIMESTAMP,null,12,1,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Joan', 'Advert',CURRENT_TIMESTAMP,null,12,2,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Sonia', 'Check',CURRENT_TIMESTAMP,null,12,3,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Wanda', 'Blake',CURRENT_TIMESTAMP,null,12,4,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Mark', 'Think',CURRENT_TIMESTAMP,null,12,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('William', 'Validate',CURRENT_TIMESTAMP,null,12,6,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Sarah', 'Good',CURRENT_TIMESTAMP,null,12,7,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Katrina', 'Fair',CURRENT_TIMESTAMP,null,12,8,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Violet', 'Blue',CURRENT_TIMESTAMP,null,12,9,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Steve', 'Job II',CURRENT_TIMESTAMP,null,7,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Lary', 'Page II',CURRENT_TIMESTAMP,null,7,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('William', 'Bates II',CURRENT_TIMESTAMP,null,7,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Larry', 'Ellison II',CURRENT_TIMESTAMP,null,7,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) VALUES ('Marrisa', 'Mayers II',CURRENT_TIMESTAMP,null,7,5,null,'admin',CURRENT_TIMESTAMP)
GO
COMMIT
GO

INSERT INTO project(`project_name`,`project_desc`,`project_manager`,`project_startdate`,`project_enddate`,`update_user`,`update_date`) VALUES ('Apricot-DEV', 'Apricot Product Development',12, CURRENT_TIMESTAMP,'2015-12-31 12:00:00','admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project(`project_name`,`project_desc`,`project_manager`,`project_startdate`,`project_enddate`,`update_user`,`update_date`) VALUES ('Tottle-DEV', 'Tottle Product Development',13, CURRENT_TIMESTAMP,'2015-12-31 12:00:00','admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project(`project_name`,`project_desc`,`project_manager`,`project_startdate`,`project_enddate`,`update_user`,`update_date`) VALUES ('NitroHard-DEV', 'NitroHard Product Development',14, CURRENT_TIMESTAMP,'2015-12-31 12:00:00','admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project(`project_name`,`project_desc`,`project_manager`,`project_startdate`,`project_enddate`,`update_user`,`update_date`) VALUES ('SoothSayer-DEV', 'SoothSayer Product Development',15, CURRENT_TIMESTAMP,'2015-12-31 12:00:00','admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project(`project_name`,`project_desc`,`project_manager`,`project_startdate`,`project_enddate`,`update_user`,`update_date`) VALUES ('Yipee-DEV', 'Yipee Product Development',16, CURRENT_TIMESTAMP,'2015-12-31 12:00:00','admin',CURRENT_TIMESTAMP)
GO
COMMIT
GO

INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 1', 'Apricot Developer 1',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 2', 'Apricot Developer 2',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 3', 'Apricot Developer 3',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 4', 'Apricot Developer 4',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 5', 'Apricot Developer 5',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 6', 'Apricot Developer 6',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 7', 'Apricot Developer 7',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 8', 'Apricot Developer 8',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('A Developer 9', 'Apricot Developer 9',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO


INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 1', 'Tottle Developer 1',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 2', 'Tottle Developer 2',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 3', 'Tottle Developer 3',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 4', 'Tottle Developer 4',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 5', 'Tottle Developer 5',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 6', 'Tottle Developer 6',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 7', 'Tottle Developer 7',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 8', 'Tottle Developer 8',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('T Developer 9', 'Tottle Developer 9',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO


INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 1', 'NitroHard Developer 1',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 2', 'NitroHard Developer 2',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 3', 'NitroHard Developer 3',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 4', 'NitroHard Developer 4',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 5', 'NitroHard Developer 5',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 6', 'NitroHard Developer 6',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 7', 'NitroHard Developer 7',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 8', 'NitroHard Developer 8',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('N Developer 9', 'NitroHard Developer 9',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO

INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 1', 'SoothSayer Developer 1',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 2', 'SoothSayer Developer 2',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 3', 'SoothSayer Developer 3',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 4', 'SoothSayer Developer 4',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 5', 'SoothSayer Developer 5',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 6', 'SoothSayer Developer 6',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 7', 'SoothSayer Developer 7',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 8', 'SoothSayer Developer 8',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('S Developer 9', 'SoothSayer Developer 9',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 1', 'Yipee Developer 1',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 2', 'Yipee Developer 2',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 3', 'Yipee Developer 3',CURRENT_TIMESTAMP,null,1,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 4', 'Yipee Developer 4',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 5', 'Yipee Developer 5',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 6', 'Yipee Developer 6',CURRENT_TIMESTAMP,null,2,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 7', 'Yipee Developer 7',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 8', 'Yipee Developer 8',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO employee(`emp_first_name`,`emp_last_name`,`emp_start_date`,`emp_end_date`,`designation_id`,`dept_id`,`mgr_id`,`update_user`,`update_date`) 
VALUES ('Y Developer 9', 'Yipee Developer 9',CURRENT_TIMESTAMP,null,3,5,null,'admin',CURRENT_TIMESTAMP)
GO
COMMIT
GO

INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 12, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 17, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 18, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 19, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 20, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 21, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 22, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 23, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 24, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (1, 25, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 13, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 26, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 27, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 28, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 29, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 30, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 31, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 32, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 33, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (2, 34, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 14, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 35, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 36, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 37, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 38, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 39, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 40, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 41, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 42, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (3, 43, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 15, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 44, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 45, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 46, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 47, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 48, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 49, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 50, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 51, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (4, 52, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 16, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 53, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 54, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 55, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 56, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 57, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 58, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 59, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 60, 'admin',CURRENT_TIMESTAMP)
GO
INSERT INTO project_employee(`project_id`,`emp_id`,`update_user`,`update_date`) VALUES (5, 61, 'admin',CURRENT_TIMESTAMP)
GO
COMMIT
GO

INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 1)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 2)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 3)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 4)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 5)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 6)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 7)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 8)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 9)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 10)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 11)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 12)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 13)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 14)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 15)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (13, 16)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 17)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 18)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 19)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 20)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 20)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 21)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 21)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 21)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 22)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 22)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 22)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 23)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 24)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 25)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 26)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 27)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 28)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 29)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 29)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 30)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 30)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 30)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 31)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 31)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 31)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 32)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 33)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 34)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 35)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 36)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 37)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 38)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 38)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 39)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 39)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 39)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 40)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 40)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 40)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 41)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 42)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 43)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 44)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 45)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 46)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 47)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 47)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 48)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 48)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 48)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 49)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 49)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 49)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 50)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 51)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 52)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 53)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 54)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 55)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 56)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 56)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 57)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 57)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 57)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 58)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 58)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 58)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 59)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 60)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (1, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (2, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (3, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (4, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (5, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (6, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (7, 61)
GO
INSERT INTO role_employee(`role_id`,`emp_id`) VALUES (8, 61)
GO
COMMIT
GO

UPDATE employee set mgr_id = 1  WHERE emp_id in (2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
GO
UPDATE employee set mgr_id = 12 WHERE emp_id in (25)
GO
UPDATE employee set mgr_id = 25 WHERE emp_id in (23,24)
GO
UPDATE employee set mgr_id = 23 WHERE emp_id in (17,20)
GO
UPDATE employee set mgr_id = 24 WHERE emp_id in (18,19,21,22)
GO
UPDATE employee set mgr_id = 13 WHERE emp_id in (34)
GO
UPDATE employee set mgr_id = 34 WHERE emp_id in (32,33)
GO
UPDATE employee set mgr_id = 32 WHERE emp_id in (26,29)
GO
UPDATE employee set mgr_id = 33 WHERE emp_id in (27,28,30,31)
GO
UPDATE employee set mgr_id = 14 WHERE emp_id in (43)
GO
UPDATE employee set mgr_id = 43 WHERE emp_id in (41,42)
GO
UPDATE employee set mgr_id = 41 WHERE emp_id in (35,38)
GO
UPDATE employee set mgr_id = 42 WHERE emp_id in (36,37,39,40)
GO
UPDATE employee set mgr_id = 15 WHERE emp_id in (52)
GO
UPDATE employee set mgr_id = 52 WHERE emp_id in (50,51)
GO
UPDATE employee set mgr_id = 50 WHERE emp_id in (44,47)
GO
UPDATE employee set mgr_id = 51 WHERE emp_id in (45,46,48,49)
GO
UPDATE employee set mgr_id = 16 WHERE emp_id in (61)
GO
UPDATE employee set mgr_id = 61 WHERE emp_id in (59,60)
GO
UPDATE employee set mgr_id = 59 WHERE emp_id in (53,56)
GO
UPDATE employee set mgr_id = 60 WHERE emp_id in (54,55,57,58)
GO
COMMIT
GO

UPDATE department SET dept_mgr = 1 WHERE dept_id = 10
GO
UPDATE department SET dept_mgr = 3 WHERE dept_id = 1
GO
UPDATE department SET dept_mgr = 4 WHERE dept_id = 2
GO
UPDATE department SET dept_mgr = 5 WHERE dept_id = 3
GO
UPDATE department SET dept_mgr = 6 WHERE dept_id = 4
GO
UPDATE department SET dept_mgr = 7 WHERE dept_id = 5
GO
UPDATE department SET dept_mgr = 8 WHERE dept_id = 6
GO
UPDATE department SET dept_mgr = 9 WHERE dept_id = 7
GO
UPDATE department SET dept_mgr = 10 WHERE dept_id = 8
GO
UPDATE department SET dept_mgr = 11 WHERE dept_id = 9
GO
COMMIT
GO

 

select 
	employeeInfo.emp_id as 'employeeInfo.emp_id',  
	employeeInfo.emp_first_name as 'employeeInfo.emp_first_name', 
	employeeInfo.emp_last_name as 'employeeInfo.emp_last_name', 
	employeeInfo.emp_start_date as 'employeeInfo.emp_start_date', 
	employeeInfo.emp_end_date as 'employeeInfo.emp_end_date', 
	employeeInfo.designation_id as 'employeeInfo.designation_id', 
	employeeInfo.dept_id as 'employeeInfo.dept_id', 
	employeeInfo.mgr_id as 'employeeInfo.mgr_id', 
	employeeInfo.update_user as 'employeeInfo.update_user', 
	employeeInfo.update_date as 'employeeInfo.update_date',
	designationInfo.designation_id as 'designationInfo.designation_id',
	designationInfo.designation_name as 'designationInfo.designation_name',
	departmentInfo.dept_id as 'departmentInfo.dept_id',
	departmentInfo.dept_name as 'departmentInfo.dept_name',
	departmentInfo.dept_desc as 'departmentInfo.dept_desc',
	deptManagerInfo.emp_id as 'deptManagerInfo.emp_id',
	deptManagerInfo.emp_first_name as 'deptManagerInfo.emp_first_name',
	deptManagerInfo.emp_last_name as 'deptManagerInfo.emp_last_name',
	deptManagerInfo.designation_id as 'deptManagerInfo.designation_id',
	managerInfo.emp_id as 'managerInfo.emp_id',
	managerInfo.emp_first_name as 'managerInfo.emp_first_name',
	managerInfo.emp_last_name as 'managerInfo.emp_last_name',
	managerInfo.designation_id as 'managerInfo.designation_id',
	roleAssnInfo.role_emp_assn_id as 'roleAssnInfo.role_emp_assn_id',
	roleAssnInfo.role_id as 'roleAssnInfo.role_id',
  	roleAssnInfo.emp_id as 'roleAssnInfo.emp_id',
  	roleInfo.role_id as 'roleInfo.role_id',
  	roleInfo.role_name as 'roleInfo.role_name',
  	roleInfo.role_desc as 'roleInfo.role_desc',
  	employeeProjectAssnInfo.project_emp_assn_id as 'employeeProjectAssnInfo.project_emp_assn_id',
  	employeeProjectAssnInfo.project_id as 'employeeProjectAssnInfo.project_id',
	employeeProjectAssnInfo.emp_id as 'employeeProjectAssnInfo.emp_id',
	employeeProjectAssnInfo.update_user as 'employeeProjectAssnInfo.update_user',
	employeeProjectAssnInfo.update_date as 'employeeProjectAssnInfo.update_date',
	projectInfo.project_id as 'projectInfo.project_id',
	projectInfo.project_name as 'projectInfo.project_name',
	projectInfo.project_desc as 'projectInfo.project_desc',
	projectInfo.project_manager as 'projectInfo.project_manager',
	projectInfo.project_startdate as 'projectInfo.project_startdate',
	projectInfo.project_enddate as 'projectInfo.project_enddate',
	projectInfo.update_user as 'projectInfo.update_user',
	projectInfo.update_date as 'projectInfo.update_date',
	
	projectManagerInfo.emp_id as 'projectManagerInfo.emp_id',
	projectManagerInfo.emp_first_name as 'projectManagerInfo.emp_first_name',
	projectManagerInfo.emp_last_name as 'projectManagerInfo.emp_last_name',
	projectManagerInfo.designation_id as 'projectManagerInfo.designation_id'
	
from 
	employee employeeInfo
left outer join designation     	designationInfo 			on employeeInfo.designation_id 			= designationInfo.designation_id
left outer join department      	departmentInfo 				on employeeInfo.dept_id 	   			= departmentInfo.dept_id
left join 		employee 	    	deptManagerInfo 			on departmentInfo.dept_mgr 	   			= deptManagerInfo.emp_id
left outer join employee 	    	managerInfo 				on employeeInfo.mgr_id 	  	   			= managerInfo.emp_id
left outer join role_employee 		roleAssnInfo 				on employeeInfo.emp_id 	  	   			= roleAssnInfo.emp_id 
left join 		role 				roleInfo 					on roleAssnInfo.role_id 	   			= roleInfo.role_id 
left outer join project_employee 	employeeProjectAssnInfo 	on employeeInfo.emp_id 	  	   			= employeeProjectAssnInfo.emp_id
left join 		project 			projectInfo 				on employeeProjectAssnInfo.project_id 	= projectInfo.project_id
left join 		employee 			projectManagerInfo 			on projectInfo.project_manager			= projectManagerInfo.emp_id
