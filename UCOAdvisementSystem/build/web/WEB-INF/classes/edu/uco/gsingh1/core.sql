/* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
/**
 * Author:  guru
 * Created: Mar 13, 2017
 */


--create  major table

DROP TABLE IF EXISTS studentcourses;
DROP TABLE IF EXISTS prereq;
DROP TABLE IF EXISTS usertable;
DROP TABLE IF EXISTS grouptable;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS major;

DROP TABLE IF EXISTS major;
CREATE TABLE major(
majorcode INT NOT NULL,
major varchar(255),
program varchar(255),
degree varchar(255),
primary key(majorcode) 
);

--create a course table
DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
courseprefix varchar(4),
coursenumber int NOT NULL,
coursetitle varchar(255),
credithrs int
);

--insert all the majors into the major table
INSERT INTO major VALUES(6100,'Computer Science','Computer Science','Bachelor of Science');
INSERT INTO major VALUES(6110,'Software Engineering','Software Engineering','Bachelor of Science');
INSERT INTO major VALUES(6102,'Computer Science-Information Science','Computer Science','Bachelor of Science');
INSERT INTO major VALUES(6101,'Computer Science-Applied','Computer Science','Bachelor of Science');
INSERT INTO major VALUES(6660,'Applied Mathematics and Computer Science','Applied Mathematics and Computer Science','Master of Science');

--insert all the courses of each major into the courses table
INSERT INTO courses VALUES('CMSC',1613,'Programming I',3);
INSERT INTO courses VALUES('CMSC',1621,'Programming I Laboratory',1);
INSERT INTO courses VALUES('CMSC',2413,'Visual Programming',3);
INSERT INTO courses VALUES('CMSC',2123,'Discrete Structures',3);
INSERT INTO courses VALUES('CMSC',2613,'Programming II',3);
INSERT INTO courses VALUES('CMSC',2833,'Computer Organization I',3);
INSERT INTO courses VALUES('CMSC',3833,'Computer Organization II',3);
INSERT INTO courses VALUES('SE',3103,'Object Oriented Software Design and Construction',3);
INSERT INTO courses VALUES('CMSC',3303,'System Analysis and Design',3);
INSERT INTO courses VALUES('CMSC',3413,'Enterprise Programming',3);
INSERT INTO courses VALUES('SE',4283,'Software Engineering I',3);
INSERT INTO courses VALUES('SE',4423,'Software Engineering II',3);
INSERT INTO courses VALUES('SE',4433,'Software Architecture and Design',3);
INSERT INTO courses VALUES('SE',4513,'Software Engineering Senior Project',3);
INSERT INTO courses VALUES('CMSC',3613,'Data Structures and Algorithms',3);
INSERT INTO courses VALUES('CMSC',4003,'Application Database Management',3);
INSERT INTO courses VALUES('CMSC',4023,'Programming Languagues',3);
INSERT INTO courses VALUES('CMSC',4063,'Networks',3);
INSERT INTO courses VALUES('CMSC',4173,'Translator Design',3);
INSERT INTO courses VALUES('CMSC',4153,'Operating Systems',3);
INSERT INTO courses VALUES('CMSC',4513,'Software Design and Development',3);
INSERT INTO courses VALUES('CMSC',4323,'Computer and Network Security',3);
INSERT INTO courses VALUES('CMSC',4401,'Ethics in Computing',1);
INSERT INTO courses VALUES('MATH',2313,'Calculus 1',3);
INSERT INTO courses VALUES('MATH',2323,'Calculus 2',3);
INSERT INTO courses VALUES('MATH',2333,'Calculus 3',3);
INSERT INTO courses VALUES('MATH',3143,'Linear Algebra',3);
INSERT INTO courses VALUES('STAT',2113,'Statistical Methods',3);
INSERT INTO courses VALUES('STAT',2103,'Introduction to Statistics for Sciences',3);
INSERT INTO courses VALUES('STAT',4113,'Mathematical Statistics',3);
INSERT INTO courses VALUES('ACCT',2113,'Accounting I',3);
INSERT INTO courses VALUES('ACCT',2133,'Accounting II',3);
INSERT INTO courses VALUES('MGMT',3103,'Principles of Management',3);
INSERT INTO courses VALUES('ISOM',3263,'Management Information Systems',3);
INSERT INTO courses VALUES('CMSC',5043,'Applied Database Management',3);
INSERT INTO courses VALUES('CMSC',5053,'Operating Systems',3);
INSERT INTO courses VALUES('CMSC',5063,'Networks',3);
INSERT INTO courses VALUES('CMSC',5283,'Software Engineering',3);
INSERT INTO courses VALUES('CMSC',5023,'Programming Languagues',3);
INSERT INTO courses VALUES('CMSC',5273,'Theory of Computing',3);
INSERT INTO courses VALUES('MATH',5113,'Operations Research 1',3);
INSERT INTO courses VALUES('MATH',5143,'Advanced Calculus for Applications 1',3);
INSERT INTO courses VALUES('MATH',5853,'Introduction to Graduate Research',3);
INSERT INTO courses VALUES('STAT',5263,'Computer Applications in Statistics',3);
INSERT INTO courses VALUES('CMSC',4273,'Theory of Computing',3);

--this column adds a new column course to the courses table
ALTER TABLE courses ADD COLUMN course VARCHAR(12);

--this query will concatenate courseprefix and coursenumber to generate a unique column course.
--this column was created as the coursenumber itself wouldnot be guaranteed to be unique
UPDATE courses SET course = CONCAT(courseprefix,coursenumber);

ALTER TABLE courses ADD PRIMARY KEY (course);

--dropping the usertable
DROP TABLE IF EXISTS usertable;
CREATE TABLE usertable(
userid INT NOT NULL AUTO_INCREMENT,
firstname varchar(255),
middleinitial char(1),
lastname varchar(255),
ucoemail varchar(255), -- tried to add UNIQUE constraint to this which causes error in dropping table major
password char(64), /* SHA-256 encryption */
usertype varchar(25) NOT NULL,
studentid varchar(12),
majorid INT,
phone char(10),
PRIMARY KEY(userid),
FOREIGN KEY (majorid) REFERENCES major(majorcode)
);

INSERT INTO usertable(firstname,middleinitial,lastname,ucoemail,password,usertype,studentid,majorid)
VALUES
('hong','','sung','hsung@uco.edu','89aa1e580023722db67646e8149eb246c748e180e34a1cf679ab0b41a416d904','advisor','',null);
INSERT INTO usertable(firstname,middleinitial,lastname,ucoemail,password,usertype,studentid,majorid)
VALUES
('guru','c','singh','gsingh1@uco.edu','8d23cf6c86e834a7aa6eded54c26ce2bb2e74903538c61bdd5d2197997ab2f72','student','*20280118',6660);


--dropping the grouptable
DROP TABLE IF EXISTS grouptable;
create table grouptable (
    id INT NOT NULL AUTO_INCREMENT,
    groupname varchar(255),
    useremail varchar(255),
    primary key (id)
    --FOREIGN KEY (useremail) REFERENCES usertable(ucoemail) getting wierd error while dropping tables need to analyze
);

insert into grouptable (groupname, useremail) values ('advisorgroup', 'hsung@uco.edu');
insert into grouptable (groupname, useremail) values ('studentgroup', 'gsingh1@uco.edu');

--This table consists of the prerequisites of a major
DROP TABLE IF EXISTS prereq;
CREATE TABLE prereq(
majorid int NOT NULL,
prereqcourse VARCHAR(12) NOT NULL,
FOREIGN KEY (majorid) REFERENCES major(majorcode),
FOREIGN KEY (prereqcourse) REFERENCES courses(course),
PRIMARY KEY(majorid,prereqcourse)
);

--prereq for 6100 B.S. in Computer Science
INSERT INTO prereq VALUES(6100,'CMSC1613');
INSERT INTO prereq VALUES(6100,'CMSC1621');
INSERT INTO prereq VALUES(6100,'CMSC2123');
INSERT INTO prereq VALUES(6100,'CMSC2613');
INSERT INTO prereq VALUES(6100,'CMSC2833');
INSERT INTO prereq VALUES(6100,'SE3103');
INSERT INTO prereq VALUES(6100,'CMSC3833');
INSERT INTO prereq VALUES(6100,'CMSC3613');
INSERT INTO prereq VALUES(6100,'CMSC4003');
INSERT INTO prereq VALUES(6100,'CMSC4023');
INSERT INTO prereq VALUES(6100,'CMSC4173');
INSERT INTO prereq VALUES(6100,'CMSC4153');
INSERT INTO prereq VALUES(6100,'CMSC4273');
INSERT INTO prereq VALUES(6100,'SE4283');
INSERT INTO prereq VALUES(6100,'CMSC4401');
INSERT INTO prereq VALUES(6100,'CMSC4513');
INSERT INTO prereq VALUES(6100,'MATH2313');
INSERT INTO prereq VALUES(6100,'MATH2323');
INSERT INTO prereq VALUES(6100,'MATH2333');
INSERT INTO prereq VALUES(6100,'MATH3143');
INSERT INTO prereq VALUES(6100,'STAT2113');
INSERT INTO prereq VALUES(6100,'STAT2103');
INSERT INTO prereq VALUES(6100,'STAT4113');

--prereq for 6101 B.S in Computer Science-Applied
INSERT INTO prereq VALUES(6101,'CMSC1613');
INSERT INTO prereq VALUES(6101,'CMSC1621');
INSERT INTO prereq VALUES(6101,'CMSC2413');
INSERT INTO prereq VALUES(6101,'CMSC2123');
INSERT INTO prereq VALUES(6101,'CMSC2613');
INSERT INTO prereq VALUES(6101,'CMSC2833');
INSERT INTO prereq VALUES(6101,'SE3103');
INSERT INTO prereq VALUES(6101,'CMSC3303');
INSERT INTO prereq VALUES(6101,'SE4283');
INSERT INTO prereq VALUES(6101,'CMSC3613');
INSERT INTO prereq VALUES(6101,'CMSC4003');
INSERT INTO prereq VALUES(6101,'CMSC4023');
INSERT INTO prereq VALUES(6101,'CMSC4173');
INSERT INTO prereq VALUES(6101,'CMSC4153');
INSERT INTO prereq VALUES(6101,'CMSC4513');
INSERT INTO prereq VALUES(6101,'MATH2313');
INSERT INTO prereq VALUES(6101,'MATH2323');
INSERT INTO prereq VALUES(6101,'STAT2113');
INSERT INTO prereq VALUES(6101,'STAT2103');
INSERT INTO prereq VALUES(6101,'STAT4113');

--prereq for 6102 B.S in Computer Science-Information Science
INSERT INTO prereq VALUES(6102,'CMSC1613');
INSERT INTO prereq VALUES(6102,'CMSC1621');
INSERT INTO prereq VALUES(6102,'CMSC2123');
INSERT INTO prereq VALUES(6102,'CMSC2413');
INSERT INTO prereq VALUES(6102,'CMSC2613');
INSERT INTO prereq VALUES(6102,'CMSC2833');
INSERT INTO prereq VALUES(6102,'SE3103');
INSERT INTO prereq VALUES(6102,'CMSC3303');
INSERT INTO prereq VALUES(6102,'CMSC3413');
INSERT INTO prereq VALUES(6102,'CMSC3613');
INSERT INTO prereq VALUES(6102,'CMSC4003');
INSERT INTO prereq VALUES(6102,'CMSC4063');
INSERT INTO prereq VALUES(6102,'CMSC4153');
INSERT INTO prereq VALUES(6102,'CMSC4323');
INSERT INTO prereq VALUES(6102,'CMSC4513');
INSERT INTO prereq VALUES(6102,'MATH2313');
INSERT INTO prereq VALUES(6102,'MATH2323');
INSERT INTO prereq VALUES(6102,'STAT2113');
INSERT INTO prereq VALUES(6102,'STAT2103');
INSERT INTO prereq VALUES(6102,'STAT4113');
INSERT INTO prereq VALUES(6102,'ACCT2113');
INSERT INTO prereq VALUES(6102,'ACCT2133');
INSERT INTO prereq VALUES(6102,'MGMT3103');
INSERT INTO prereq VALUES(6102,'ISOM3263');

--prereq for 6110 B.S in Software Engineering-Software Engineering
INSERT INTO prereq VALUES(6110,'CMSC1613');
INSERT INTO prereq VALUES(6110,'CMSC1621');
INSERT INTO prereq VALUES(6110,'CMSC2123');
INSERT INTO prereq VALUES(6110,'CMSC2613');
INSERT INTO prereq VALUES(6110,'CMSC2833');
INSERT INTO prereq VALUES(6110,'SE3103');
INSERT INTO prereq VALUES(6110,'CMSC3613');
INSERT INTO prereq VALUES(6110,'CMSC4003');
INSERT INTO prereq VALUES(6110,'CMSC4153');
INSERT INTO prereq VALUES(6110,'SE4283');
INSERT INTO prereq VALUES(6110,'CMSC4401');
INSERT INTO prereq VALUES(6110,'SE4423');
INSERT INTO prereq VALUES(6110,'SE4433');
INSERT INTO prereq VALUES(6110,'SE4513');
INSERT INTO prereq VALUES(6110,'MATH2313');
INSERT INTO prereq VALUES(6110,'MATH2323');
INSERT INTO prereq VALUES(6110,'MATH2333');
INSERT INTO prereq VALUES(6110,'MATH3143');
INSERT INTO prereq VALUES(6110,'STAT2113');
INSERT INTO prereq VALUES(6110,'STAT2103');
INSERT INTO prereq VALUES(6110,'STAT4113');

--prereq for 6660 B.S in Software Engineering-Software Engineering
INSERT INTO prereq VALUES(6660,'CMSC5043');
INSERT INTO prereq VALUES(6660,'CMSC5053');
INSERT INTO prereq VALUES(6660,'CMSC5063');
INSERT INTO prereq VALUES(6660,'CMSC5283');
INSERT INTO prereq VALUES(6660,'CMSC5023');
INSERT INTO prereq VALUES(6660,'CMSC5273');
INSERT INTO prereq VALUES(6660,'MATH5113');
INSERT INTO prereq VALUES(6660,'MATH5143');
INSERT INTO prereq VALUES(6660,'MATH5853');
INSERT INTO prereq VALUES(6660,'STAT5263');

--This table consists of all the courses student has taken
DROP TABLE IF EXISTS studentcourses;
CREATE TABLE studentcourses(
suid INT NOT NULL,
scourse VARCHAR(12) NOT NULL,
PRIMARY KEY(suid,scourse),
FOREIGN KEY (suid) REFERENCES usertable(userid),
FOREIGN KEY (scourse) REFERENCES courses(course)
);

--for trial user takes these courses
INSERT INTO studentcourses VALUES(2,'CMSC5043');
INSERT INTO studentcourses VALUES(2,'CMSC5063');
INSERT INTO studentcourses VALUES(2,'CMSC5283');
INSERT INTO studentcourses VALUES(2,'CMSC5023');
INSERT INTO studentcourses VALUES(2,'MATH5113');

