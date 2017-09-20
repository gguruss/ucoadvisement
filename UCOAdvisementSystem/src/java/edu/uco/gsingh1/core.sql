 /* 
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
/**
 * Author:  guru
 * Created: Mar 13, 2017
 */


--create  major table
DROP TABLE IF EXISTS userimage;
DROP TABLE IF EXISTS advisementstatus;
DROP TABLE IF EXISTS daytable;
DROP TABLE IF EXISTS advisorschedule;
DROP TABLE IF EXISTS breaks;
DROP TABLE IF EXISTS slots;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS timeslots;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS bookingstatus;
DROP TABLE IF EXISTS majorprereq;
DROP TABLE IF EXISTS studentcourses;
DROP TABLE IF EXISTS advisor;
DROP TABLE IF EXISTS prerequisite;
DROP TABLE IF EXISTS corequisite;
DROP TABLE IF EXISTS suggested;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS grouptable;
DROP TABLE IF EXISTS usertable;
DROP TABLE IF EXISTS major;

DROP TABLE IF EXISTS major;
CREATE TABLE major(
majorcode INT NOT NULL,
major varchar(255),
program varchar(255),
degree varchar(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
primary key(majorcode) 
);

--create a course table
DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
courseprefix varchar(4),
coursenumber int NOT NULL,
coursetitle varchar(255),
credithrs int,
datecreated TIMESTAMP,
datemodified TIMESTAMP
);

--insert all the majors into the major table
INSERT INTO major(majorcode,major,program,degree) VALUES(6100,'Computer Science','Computer Science','Bachelor of Science');
INSERT INTO major(majorcode,major,program,degree) VALUES(6110,'Software Engineering','Software Engineering','Bachelor of Science');
INSERT INTO major(majorcode,major,program,degree) VALUES(6102,'Computer Science-Information Science','Computer Science','Bachelor of Science');
INSERT INTO major(majorcode,major,program,degree) VALUES(6101,'Computer Science-Applied','Computer Science','Bachelor of Science');
INSERT INTO major(majorcode,major,program,degree) VALUES(6660,'Applied Mathematics and Computer Science','Applied Mathematics and Computer Science','Master of Science');

--insert all the courses into the courses table
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',1513,'College Algebra',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',1593,'Plane Trigonometry',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',1555,'College Algebra & Trigonometry',5);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',1513,'Beginning Programming',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',1521,'Beginning Programming Lab',5);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('HSAP',0001,'High School AP',0);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',1613,'Programming I',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',1621,'Programming I Lab',1);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',2413,'Visual Programming',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',2123,'Discrete Structures',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',2613,'Programming II',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',2621,'Programming II Lab',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',2833,'Computer Organization I',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',3833,'Computer Organization II',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('SE',3103,'Object Oriented Software Design and Construction',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',3303,'System Analysis and Design',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',3413,'Enterprise Programming',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('SE',4283,'Software Engineering I',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('SE',4423,'Software Engineering II',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('SE',4433,'Software Architecture and Design',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('SE',4513,'Software Engineering Senior Project',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',3613,'Data Structures and Algorithms',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4003,'Application Database Management',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4023,'Programming Languagues',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4063,'Networks',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4173,'Translator Design',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4153,'Operating Systems',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4513,'Software Design and Development',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4323,'Computer and Network Security',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4401,'Ethics in Computing',1);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',2313,'Calculus 1',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',2323,'Calculus 2',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',2333,'Calculus 3',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',3143,'Linear Algebra',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('STAT',2113,'Statistical Methods',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('STAT',2103,'Introduction to Statistics for Sciences',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('STAT',4113,'Mathematical Statistics',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('ACCT',2113,'Accounting I',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('ACCT',2133,'Accounting II',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MGMT',3103,'Principles of Management',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('ISOM',3263,'Management Information Systems',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5043,'Applied Database Management',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5053,'Operating Systems',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5063,'Networks',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5283,'Software Engineering',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5023,'Programming Languagues',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',5273,'Theory of Computing',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',5113,'Operations Research 1',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',5143,'Advanced Calculus for Applications 1',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('MATH',5853,'Introduction to Graduate Research',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('STAT',5263,'Computer Applications in Statistics',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4273,'Theory of Computing',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4133,'Artificial Intelligence',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4193,'Robotics',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4910,'Seminar',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4303,'Mobile Application Development',3);
INSERT INTO courses(courseprefix,coursenumber,coursetitle,credithrs) VALUES('CMSC',4373,'Web Server Programming',3);

--this column adds a new column course to the courses table
ALTER TABLE courses ADD COLUMN course VARCHAR(12);

--this query will concatenate courseprefix and coursenumber to generate a unique column course.
--this column was created as the coursenumber itself wouldnot be guaranteed to be unique
UPDATE courses SET course = CONCAT(courseprefix,coursenumber);

ALTER TABLE courses ADD PRIMARY KEY (course);

CREATE TABLE prerequisite
    (   
        prereqid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        maincourse VARCHAR(12),
        prereqcourse VARCHAR(12),
        FOREIGN KEY main_fk(maincourse) REFERENCES
        courses(course),
        FOREIGN KEY prereq_fk(prereqcourse) REFERENCES
        courses(course)
    );

CREATE TABLE corequisite
    (   
        coreqid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        maincourse varchar(12),
        corequisitecourse varchar(12),
        FOREIGN KEY main_fk(maincourse) REFERENCES
        courses(course),
        FOREIGN KEY coreq_fk(corequisitecourse) REFERENCES
        courses(course)
    );
 
CREATE TABLE suggested
    (   
        suggestedid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        maincourse varchar(12),
        suggestedcourse varchar(12),
        FOREIGN KEY main_fk(maincourse) REFERENCES
        courses(course),
        FOREIGN KEY suggested_fk(suggestedcourse) REFERENCES
        courses(course)
    );

INSERT INTO  prerequisite(maincourse,prereqcourse)
        values ('CMSC2413','CMSC1513');
 INSERT INTO  corequisite(maincourse,corequisitecourse)
        values ('CMSC1613','MATH1513');
 INSERT INTO  corequisite(maincourse,corequisitecourse)
        values ('CMSC1613','MATH1555');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC2833','CMSC1613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH2313','MATH1513');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('CMSC2123','MATH2313');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC2613','CMSC1613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH2323','MATH2313');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH2333','MATH2323');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH3143','MATH2333');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('STAT2103','MATH1513');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH2313','MATH1593');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('MATH3143','MATH2333');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC3833','CMSC2833');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC3413','CMSC2613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE3103','CMSC2613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4283','CMSC2613');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('SE4283','MATH2313');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('SE4283','STAT2103');
INSERT INTO  suggested (maincourse,suggestedcourse)
        values ('SE4283','SE3103');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('CMSC4003','MATH2313');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('CMSC4003','STAT2103');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4003','CMSC2613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4303','SE3103');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4373','SE3103');
INSERT INTO  suggested (maincourse,suggestedcourse)
        values ('CMSC4373','CMSC4003');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC3613','CMSC2123');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC3613','CMSC2613');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('CMSC3613','MATH2313');
 INSERT INTO  corequisite (maincourse,corequisitecourse)
        values ('CMSC3613','STAT2103');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4910','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4133','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4153','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4323','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4063','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4193','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4401','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4023','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4173','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4273','CMSC3613');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4423','SE4283');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4433','SE4283');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4513','SE4423');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4513','SE4433');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('SE4513','CMSC4003');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4513','CMSC4003');
INSERT INTO  prerequisite (maincourse,prereqcourse)
        values ('CMSC4513','SE4283');


--dropping the usertable
DROP TABLE IF EXISTS usertable;
CREATE TABLE usertable(
userid INT NOT NULL AUTO_INCREMENT,
firstname varchar(255),
middleinitial char(1),
lastname varchar(255),
username varchar(255), -- tried to add UNIQUE constraint to this which causes error in dropping table major
password char(64), /* SHA-256 encryption */
usertype varchar(25) NOT NULL,
studentid varchar(12) NOT NULL,
majorid INT,
phone char(10),
isverified smallint DEFAULT 0, --1 for verified ,0 for not verified
isadmin smallint DEFAULT 0, --1 for admin role, 0 for not verified
isadvisor smallint DEFAULT 0, --1 for advisor, 0 for normal users
advisementstatus TINYINT DEFAULT 0, -- 0 for not advised, 1 for advised,2 for noshow
randomcode varchar(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY(userid),
FOREIGN KEY (majorid) REFERENCES major(majorcode)
);


--dropping the grouptable
DROP TABLE IF EXISTS grouptable;
create table grouptable (
    id INT NOT NULL AUTO_INCREMENT,
    uid INT NOT NULL,
    groupname varchar(255),
    username varchar(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
    primary key (id),
FOREIGN KEY(uid) REFERENCES usertable(userid)
    --FOREIGN KEY (useremail) REFERENCES usertable(username) getting wierd error while dropping tables need to analyze
);

DROP TABLE IF EXISTS advisor;
CREATE TABLE advisor(
advisorid INT NOT NULL AUTO_INCREMENT,
userid INT NOT NULL,
advisorfirstname VARCHAR(255),
advisorlastname VARCHAR(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (advisorid),
FOREIGN KEY (userid) REFERENCES usertable(userid)
);

DROP TRIGGER IF EXISTS groupnameinsert_after_ins_trigger;

DELIMITER #

--adds the user to their respective group and if its an advisor insert record into advisor table
CREATE TRIGGER groupnameinsert_after_ins_trigger AFTER INSERT ON usertable
FOR EACH ROW
BEGIN
  IF(new.isadvisor = 0) THEN
    INSERT INTO grouptable (groupname, username,uid) VALUES ("studentgroup", new.username,new.userid);
  ELSE
    INSERT INTO grouptable (groupname, username,uid) VALUES ("advisorgroup", new.username,new.userid);
    INSERT INTO advisor (userid, advisorfirstname, advisorlastname) VALUES(new.userid,new.firstname,new.lastname);
  END IF;
END#


DELIMITER ;

DROP TRIGGER IF EXISTS groupname_before_delete_trigger;

DELIMITER #

CREATE TRIGGER groupname_before_delete_trigger BEFORE DELETE ON usertable
FOR EACH ROW
BEGIN
  DELETE FROM advisor where userid=old.userid;
  DELETE FROM grouptable where uid=old.userid;
  
END#

DELIMITER ;

--user hong sung with password 121
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified,isadmin,isadvisor)
VALUES
('hong','','sung','hsung@uco.edu','89aa1e580023722db67646e8149eb246c748e180e34a1cf679ab0b41a416d904','advisor','',null,1,1,1);
--user grace park with password 123
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified,isadmin,isadvisor)
VALUES
('grace','','park','gpark@uco.edu','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','advisor','',null,1,0,1);
--user guru singh with password 321
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('guru','c','singh','gsingh1@uco.edu','8d23cf6c86e834a7aa6eded54c26ce2bb2e74903538c61bdd5d2197997ab2f72','student','*20280118',6660,1);
--other users with password 987
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('clark','','kent','ckent@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280119',6100,1);
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('bruce','','wayne','bwayne@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280120',6101,1);
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('john','','doe','jdoe@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280121',6102,1);
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('jane','','doe','janedoe@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280122',6110,1);
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('morgan','','smith','msmith@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280123',6660,1);
INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,isverified)
VALUES
('matt','','damon','mdamon@uco.edu','55c8079ac96c6a4f6a94e3460c79e4006d62374cce6e9fc8b281938a3abc7627','student','*20280124',6100,1);

--This table consists of the prerequisites of a major
DROP TABLE IF EXISTS majorprereq;
CREATE TABLE majorprereq(
majorid int NOT NULL,
majorprereqcourse VARCHAR(12) NOT NULL,
FOREIGN KEY (majorid) REFERENCES major(majorcode),
FOREIGN KEY (majorprereqcourse) REFERENCES courses(course),
PRIMARY KEY(majorid,majorprereqcourse)
);

--prereq for 6100 B.S. in Computer Science
INSERT INTO majorprereq VALUES(6100,'CMSC1613');
INSERT INTO majorprereq VALUES(6100,'CMSC1621');
INSERT INTO majorprereq VALUES(6100,'CMSC2123'); 
INSERT INTO majorprereq VALUES(6100,'CMSC2613');
INSERT INTO majorprereq VALUES(6100,'CMSC2833');
INSERT INTO majorprereq VALUES(6100,'SE3103');
INSERT INTO majorprereq VALUES(6100,'CMSC3833');
INSERT INTO majorprereq VALUES(6100,'CMSC3613');
INSERT INTO majorprereq VALUES(6100,'CMSC4003');
INSERT INTO majorprereq VALUES(6100,'CMSC4023');
INSERT INTO majorprereq VALUES(6100,'CMSC4173');
INSERT INTO majorprereq VALUES(6100,'CMSC4153');
INSERT INTO majorprereq VALUES(6100,'CMSC4273');
INSERT INTO majorprereq VALUES(6100,'SE4283');
INSERT INTO majorprereq VALUES(6100,'CMSC4401');
INSERT INTO majorprereq VALUES(6100,'CMSC4513');
INSERT INTO majorprereq VALUES(6100,'MATH2313');
INSERT INTO majorprereq VALUES(6100,'MATH2323');
INSERT INTO majorprereq VALUES(6100,'MATH2333');
INSERT INTO majorprereq VALUES(6100,'MATH3143');
INSERT INTO majorprereq VALUES(6100,'STAT2113');
INSERT INTO majorprereq VALUES(6100,'STAT2103');
INSERT INTO majorprereq VALUES(6100,'STAT4113');

--majorprereq for 6101 B.S in Computer Science-Applied
INSERT INTO majorprereq VALUES(6101,'CMSC1613');
INSERT INTO majorprereq VALUES(6101,'CMSC1621');
INSERT INTO majorprereq VALUES(6101,'CMSC2413');
INSERT INTO majorprereq VALUES(6101,'CMSC2123');
INSERT INTO majorprereq VALUES(6101,'CMSC2613');
INSERT INTO majorprereq VALUES(6101,'CMSC2833');
INSERT INTO majorprereq VALUES(6101,'SE3103');
INSERT INTO majorprereq VALUES(6101,'CMSC3303');
INSERT INTO majorprereq VALUES(6101,'SE4283');
INSERT INTO majorprereq VALUES(6101,'CMSC3613');
INSERT INTO majorprereq VALUES(6101,'CMSC4003');
INSERT INTO majorprereq VALUES(6101,'CMSC4023');
INSERT INTO majorprereq VALUES(6101,'CMSC4173');
INSERT INTO majorprereq VALUES(6101,'CMSC4153');
INSERT INTO majorprereq VALUES(6101,'CMSC4513');
INSERT INTO majorprereq VALUES(6101,'MATH2313');
INSERT INTO majorprereq VALUES(6101,'MATH2323');
INSERT INTO majorprereq VALUES(6101,'STAT2113');
INSERT INTO majorprereq VALUES(6101,'STAT2103');
INSERT INTO majorprereq VALUES(6101,'STAT4113');

--majorprereq for 6102 B.S in Computer Science-Information Science
INSERT INTO majorprereq VALUES(6102,'CMSC1613');
INSERT INTO majorprereq VALUES(6102,'CMSC1621');
INSERT INTO majorprereq VALUES(6102,'CMSC2123');
INSERT INTO majorprereq VALUES(6102,'CMSC2413');
INSERT INTO majorprereq VALUES(6102,'CMSC2613');
INSERT INTO majorprereq VALUES(6102,'CMSC2833');
INSERT INTO majorprereq VALUES(6102,'SE3103');
INSERT INTO majorprereq VALUES(6102,'CMSC3303');
INSERT INTO majorprereq VALUES(6102,'CMSC3413');
INSERT INTO majorprereq VALUES(6102,'CMSC3613');
INSERT INTO majorprereq VALUES(6102,'CMSC4003');
INSERT INTO majorprereq VALUES(6102,'CMSC4063');
INSERT INTO majorprereq VALUES(6102,'CMSC4153');
INSERT INTO majorprereq VALUES(6102,'CMSC4323');
INSERT INTO majorprereq VALUES(6102,'CMSC4513');
INSERT INTO majorprereq VALUES(6102,'MATH2313');
INSERT INTO majorprereq VALUES(6102,'MATH2323');
INSERT INTO majorprereq VALUES(6102,'STAT2113');
INSERT INTO majorprereq VALUES(6102,'STAT2103');
INSERT INTO majorprereq VALUES(6102,'STAT4113');
INSERT INTO majorprereq VALUES(6102,'ACCT2113');
INSERT INTO majorprereq VALUES(6102,'ACCT2133');
INSERT INTO majorprereq VALUES(6102,'MGMT3103');
INSERT INTO majorprereq VALUES(6102,'ISOM3263');

--majorprereq for 6110 B.S in Software Engineering-Software Engineering
INSERT INTO majorprereq VALUES(6110,'CMSC1613');
INSERT INTO majorprereq VALUES(6110,'CMSC1621');
INSERT INTO majorprereq VALUES(6110,'CMSC2123');
INSERT INTO majorprereq VALUES(6110,'CMSC2613');
INSERT INTO majorprereq VALUES(6110,'CMSC2833');
INSERT INTO majorprereq VALUES(6110,'SE3103');
INSERT INTO majorprereq VALUES(6110,'CMSC3613');
INSERT INTO majorprereq VALUES(6110,'CMSC4003');
INSERT INTO majorprereq VALUES(6110,'CMSC4153');
INSERT INTO majorprereq VALUES(6110,'SE4283');
INSERT INTO majorprereq VALUES(6110,'CMSC4401');
INSERT INTO majorprereq VALUES(6110,'SE4423');
INSERT INTO majorprereq VALUES(6110,'SE4433');
INSERT INTO majorprereq VALUES(6110,'SE4513');
INSERT INTO majorprereq VALUES(6110,'MATH2313');
INSERT INTO majorprereq VALUES(6110,'MATH2323');
INSERT INTO majorprereq VALUES(6110,'MATH2333');
INSERT INTO majorprereq VALUES(6110,'MATH3143');
INSERT INTO majorprereq VALUES(6110,'STAT2113');
INSERT INTO majorprereq VALUES(6110,'STAT2103');
INSERT INTO majorprereq VALUES(6110,'STAT4113');

--majorprereq for 6660 B.S in Software Engineering-Software Engineering
INSERT INTO majorprereq VALUES(6660,'CMSC5043');
INSERT INTO majorprereq VALUES(6660,'CMSC5053');
INSERT INTO majorprereq VALUES(6660,'CMSC5063');
INSERT INTO majorprereq VALUES(6660,'CMSC5283');
INSERT INTO majorprereq VALUES(6660,'CMSC5023');
INSERT INTO majorprereq VALUES(6660,'CMSC5273');
INSERT INTO majorprereq VALUES(6660,'MATH5113');
INSERT INTO majorprereq VALUES(6660,'MATH5143');
INSERT INTO majorprereq VALUES(6660,'MATH5853');
INSERT INTO majorprereq VALUES(6660,'STAT5263');

DROP TABLE IF EXISTS daytable;
CREATE TABLE daytable(
dayid INT NOT NULL AUTO_INCREMENT,
daynum TINYINT,
dayname VARCHAR(12),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (dayid)
);

INSERT INTO daytable(daynum,dayname) VALUES (1,'sunday');
INSERT INTO daytable(daynum,dayname) VALUES (2,'monday');
INSERT INTO daytable(daynum,dayname) VALUES (3,'tuesday');
INSERT INTO daytable(daynum,dayname) VALUES (4,'wednesday');
INSERT INTO daytable(daynum,dayname) VALUES (5,'thursday');
INSERT INTO daytable(daynum,dayname) VALUES (6,'friday');
INSERT INTO daytable(daynum,dayname) VALUES (7,'saturday');

--This table defines types of booking status
DROP TABLE IF EXISTS bookingstatus;
CREATE TABLE bookingstatus(
statusid INT NOT NULL AUTO_INCREMENT,
status TINYINT, -- 0 for open -1 for cancelled by advisor and 1 for booked -2 cancelled by student
description VARCHAR(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (statusid)
);


INSERT INTO bookingstatus(status,description) VALUES (0,'open');
INSERT INTO bookingstatus(status,description) VALUES (1,'booked');
INSERT INTO bookingstatus(status,description) VALUES (-1,'cancelledbyadvisor');
INSERT INTO bookingstatus(status,description) VALUES (-2,'cancelledbystudent');

DROP TABLE IF EXISTS advisementstatus;
CREATE TABLE advisementstatus(
advisementstatusid INT NOT NULL AUTO_INCREMENT,
advisementstatus TINYINT, -- 0 for not advised, 1 for advised
advisementdescription VARCHAR(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (advisementstatusid)
);

INSERT INTO advisementstatus(advisementstatus,advisementdescription) VALUES (0,'not advised');
INSERT INTO advisementstatus(advisementstatus,advisementdescription) VALUES (1,'advised');


DROP TABLE IF EXISTS advisorschedule;
CREATE TABLE advisorschedule(
advisorscheduleid INT NOT NULL AUTO_INCREMENT,
advisorid INT NOT NULL,
availday TINYINT,
availFrom DATE,
availTo DATE,
availfromtime TIME,
availtotime TIME,
duration TINYINT,
datecreated TIMESTAMP,
datemodified TIMESTAMP,
userid INT NOT NULL,
PRIMARY KEY (advisorscheduleid),
FOREIGN KEY (advisorid) REFERENCES advisor(advisorid),
FOREIGN KEY (userid) REFERENCES usertable(userid)
);

-- test data for Dr Sung
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(1,2,'9:30','17:30',10,'2017-09-05','2017-09-15',1);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(1,3,'11:30','15:30',10,'2017-09-05','2017-09-15',1);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(1,4,'10:00','11:45',10,'2017-09-05','2017-09-15',1);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(1,5,'14:00','15:00',10,'2017-09-05','2017-09-15',1);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(1,6,'16:00','17:30',10,'2017-09-05','2017-09-15',1);
--test data for Dr Park
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(2,2,'9:00','14:30',10,'2017-09-05','2017-09-15',2);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(2,4,'10:00','15:00',10,'2017-09-05','2017-09-15',2);
INSERT INTO advisorschedule (advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo,userid)
VALUES
(2,5,'16:00','17:30',10,'2017-09-05','2017-09-15',2);



DROP TABLE IF EXISTS timeslots;
CREATE TABLE timeslots(
timeslotid INT NOT NULL AUTO_INCREMENT,
advisorid INT NOT NULL,
timeslotday TINYINT,
start_time DATETIME,
end_time DATETIME,
duration INT,
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (timeslotid),
FOREIGN KEY (advisorid) REFERENCES advisor(advisorid)
);

-- INSERT INTO timeslots(advisorid,timeslotday,start_time,end_time,duration)
-- VALUES
-- (1,'monday','09:00:00','19:00:00',10);
-- INSERT INTO timeslots(advisorid,timeslotday,start_time,end_time,duration)
-- VALUES
-- (1,'tuesday','09:00:00','12:00:00',10);
-- INSERT INTO timeslots(advisorid,timeslotday,start_time,end_time,duration)
-- VALUES
-- (1,'wednesday','09:00:00','17:00:00',10);
-- INSERT INTO timeslots(advisorid,timeslotday,start_time,end_time,duration)
-- VALUES
-- (1,'thursday','13:00:00','15:00:00',10);
-- INSERT INTO timeslots(advisorid,timeslotday,start_time,end_time,duration)
-- VALUES
-- (1,'friday','9:00:00','11:00:00',10);


DROP TABLE IF EXISTS breaks;
CREATE TABLE breaks(
breakid INT NOT NULL AUTO_INCREMENT,
advisorid INT NOT NULL,
breakday TINYINT,
start_time TIME,
end_time TIME,
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (breakid),
FOREIGN KEY(advisorid) REFERENCES advisor(advisorid)
);

--testing breaks data
INSERT INTO breaks
    (advisorid, breakday, start_time, end_time)
VALUES
    (1, 4, '11:00:00', '12:00:00');
INSERT INTO breaks
    (advisorid, breakday, start_time, end_time)
VALUES
    (2, 4, '11:00:00', '12:00:00');

DROP TABLE IF EXISTS appointments;
CREATE TABLE appointments(
appointmentid INT NOT NULL AUTO_INCREMENT,
advisorid INT NOT NULL,
userid INT,
appointmentday TINYINT,
appointmentdate DATE,
starttime DATETIME,
endtime DATETIME,
status TINYINT,
cancelledbyusertype VARCHAR(25),
cancelledbyuserid INT,
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY (appointmentid),
FOREIGN KEY (userid) REFERENCES usertable(userid),
FOREIGN KEY (cancelledbyuserid) REFERENCES usertable(userid),
FOREIGN KEY (advisorid) REFERENCES advisor(advisorid)
);

--test data
INSERT INTO appointments
(advisorid,userid,appointmentday,appointmentdate,starttime,endtime,status)
VALUES
(1,3,4,'2017-09-07','2017-09-06 10:10:00','2017-09-06 10:20:00',1);
INSERT INTO appointments
(advisorid,userid,appointmentday,appointmentdate,starttime,endtime,status)
VALUES
(1,4,4,'2017-09-06','2017-09-06 10:20:00','2017-09-06 10:30:00',1);

INSERT INTO appointments
(advisorid,userid,appointmentday,appointmentdate,starttime,endtime,status)
VALUES
(2,5,4,'2017-09-07','2017-09-06 10:20:00','2017-09-06 10:30:00',1);

--This table consists of all the courses student has taken
DROP TABLE IF EXISTS studentcourses;
CREATE TABLE studentcourses(
suid INT NOT NULL,
scourse VARCHAR(12) NOT NULL,
susername VARCHAR(255),
datecreated TIMESTAMP,
datemodified TIMESTAMP,
PRIMARY KEY(suid,scourse),
FOREIGN KEY (suid) REFERENCES usertable(userid),
FOREIGN KEY (scourse) REFERENCES courses(course)
);




DROP PROCEDURE IF EXISTS getVerificationCode;

DELIMITER #

CREATE PROCEDURE getVerificationCode(IN useremail VARCHAR(255),
                                      OUT verificationcode VARCHAR(255))                                          
    BEGIN
        DECLARE verificationcode VARCHAR(255);
        SELECT randomcode INTO verificationcode FROM usertable 
        WHERE username = useremail;
   
    END#
DELIMITER ;

DROP FUNCTION getVerCode;
DELIMITER #

CREATE FUNCTION getVerCode(useremail VARCHAR(255))
  RETURNS VARCHAR(255)
BEGIN
  DECLARE verificationcode VARCHAR(255);
  SELECT randomcode INTO verificationcode FROM usertable 
        WHERE username = useremail;
  RETURN verificationcode;

END#

DELIMITER ;

--checks if ucoemail exists
DROP FUNCTION checkIfEmailExists;
DELIMITER #

CREATE FUNCTION checkIfEmailExists(useremail VARCHAR(255))
  RETURNS SMALLINT
BEGIN
  DECLARE emailCheck SMALLINT;
  SELECT EXISTS(SELECT 1 FROM usertable WHERE LOWER(username)=LOWER(useremail)) INTO emailcheck;
  RETURN emailCheck;
END#

DELIMITER ;

--checks if student id exists 
DROP FUNCTION checkIfStudentIdExists;
DELIMITER #

CREATE FUNCTION checkIfStudentIdExists(id VARCHAR(255))
  RETURNS SMALLINT
BEGIN
  DECLARE studentIdCheck SMALLINT;
  SELECT EXISTS(SELECT 1 FROM usertable WHERE LOWER(studentid)=LOWER(id)) INTO studentIdCheck;
  RETURN studentIdCheck;
END#

DELIMITER ;

--checks if user has the verification code exists 
DROP FUNCTION checkVerificationCodeForUser;
DELIMITER #

CREATE FUNCTION checkVerificationCodeForUser(useremail VARCHAR(255), verificationCode VARCHAR(255))
  RETURNS SMALLINT
BEGIN
  DECLARE codeCheck SMALLINT;
  SELECT EXISTS(SELECT 1 FROM usertable WHERE username=LOWER(useremail) AND randomcode=LOWER(verificationCode)) INTO codeCheck;
RETURN codeCheck;
END#

DELIMITER ;

DROP VIEW IF EXISTS userview;
CREATE OR REPLACE VIEW userview
AS
SELECT u.userid,
        u.firstname,
       u.middleinitial,
       u.lastname,
       u.username,
       u.studentid,
       u.phone,
       m.majorcode,
       m.major,
       m.degree,
       a.advisementstatus,
       a.advisementdescription
FROM usertable u
JOIN major m 
ON m.majorcode=u.majorid
JOIN advisementstatus a 
ON a.advisementstatus=u.advisementstatus;

DROP VIEW IF EXISTS studentadvisementstatusview;
CREATE OR REPLACE VIEW studentadvisementstatusview
AS
SELECT u.userid,
        u.firstname,
       u.middleinitial,
       u.lastname,
       u.username,
       u.studentid,
       m.majorcode,
       m.major,
       m.degree,
       a.advisementstatus,
       a.advisementdescription
FROM usertable u
JOIN major m 
ON m.majorcode=u.majorid
JOIN advisementstatus a 
ON a.advisementstatus=u.advisementstatus;

DROP PROCEDURE IF EXISTS getUserDetail;
DELIMITER #

CREATE PROCEDURE getUserDetail(IN useremail VARCHAR(255))
BEGIN
 SELECT * FROM userview WHERE username=useremail;
END#

DELIMITER ;

DROP VIEW IF EXISTS studentcoursesview;
CREATE OR REPLACE VIEW studentcoursesview
AS
SELECT  sc.suid,
        sc.scourse,
        sc.susername AS susername,
        c.coursetitle
FROM studentcourses sc
JOIN courses c
ON sc.scourse=c.course;

DROP VIEW IF EXISTS majorprereqview;
CREATE OR REPLACE VIEW majorprereqview
AS
SELECT  
        majorid,
        majorprereqcourse,
        c.coursetitle
       FROM majorprereq 
JOIN courses c
ON majorprereqcourse=c.course;

DROP VIEW IF EXISTS breakview;
CREATE OR REPLACE VIEW breakview
AS
SELECT  
        b.breakid,
        b.breakday,
        b.advisorid,
        d.dayname,
        start_time,
        end_time
               FROM breaks b
JOIN daytable d
ON breakday=d.daynum;

DROP PROCEDURE IF EXISTS getCoursesTakenByStudents;
DELIMITER #

CREATE PROCEDURE getCoursesTakenByStudents(IN useremail VARCHAR(255))
BEGIN
 SELECT scourse, coursetitle FROM studentcoursesview WHERE susername=useremail;
END#

DELIMITER ;

DROP PROCEDURE IF EXISTS getMajorCourses;
DELIMITER #

CREATE PROCEDURE getMajorCourses(IN majorcode INT)
BEGIN
 SELECT * FROM majorprereqview WHERE majorid=majorcode;
END#

DELIMITER ;

DROP PROCEDURE IF EXISTS getMajorCoursesLeftToBeTaken;
DELIMITER #

CREATE PROCEDURE getMajorCoursesLeftToBeTaken(IN majorcode INT, userid INT)
BEGIN
SELECT *
FROM majorprereqview m
WHERE majorid=majorcode
AND m.majorprereqcourse NOT IN(
SELECT scourse FROM studentcourses sc 
WHERE sc.suid=userid);
END#

DELIMITER ;

--gets the appointment slot given a particular date
DROP PROCEDURE IF EXISTS getAvailableAppointmentSlots;
DELIMITER #

CREATE PROCEDURE getAvailableAppointmentSlots(IN userselecteddate DATE, IN advisorid INTEGER)

BEGIN
DECLARE availslots INT DEFAULT 0;
DECLARE slotlimit INT DEFAULT 0;
DECLARE appointmentslots INT DEFAULT 0;
DECLARE advisingduration INT DEFAULT 0;

SET advisingduration=(SELECT duration FROM advisorschedule WHERE availday=DAYOFWEEK(userselecteddate));


SELECT *
FROM(
SELECT dts.start_at,dts.end_at,ads.advisorid,ads.availday
FROM(
SELECT
             num + 1 as num
                , DATE_ADD(userselecteddate, INTERVAL (slots.num * advisingduration) MINUTE) start_at
                , DATE_ADD(userselecteddate, INTERVAL ((slots.num + 1)* advisingduration) MINUTE) end_at
                , DAYOFWEEK(userselecteddate) dayofweek
            FROM (
                  /* generates 1000 rows 0 to 999 */
                  SELECT hundreds.digit * 100 + tens.digit * 10 + ones.digit AS num
                  FROM (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                       ) ones
                  CROSS JOIN (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                             ) tens
                  CROSS JOIN (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                             ) hundreds
                  ) slots
)dts
INNER JOIN advisorschedule ads
ON
ads.availday=dts.dayofweek
WHERE TIME(dts.start_at)>=ads.availfromtime 
AND TIME(dts.end_at)<=ads.availtotime
AND ads.advisorid=advisorid)allslotsinaday
LEFT JOIN appointments ap on
allslotsinaday.start_at=ap.starttime
AND
allslotsinaday.end_at=ap.endtime
WHERE ap.starttime is NULL
AND  DAYOFWEEK(allslotsinaday.end_at)=DAYOFWEEK(userselecteddate)
;

END#

DELIMITER ;

-- the codes below are for setting collation type of the database
-- SET collation_connection = 'utf8_general_ci'
-- 
-- ALTER DATABASE your_database_name CHARACTER SET utf8 COLLATE utf8_general_ci
-- 
-- ALTER TABLE your_table_name CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci
-- 
-- SELECT CONCAT('ALTER TABLE `', table_name, '` MODIFY `', column_name, '` ', DATA_TYPE, ' CHARACTER SET UTF8 COLLATE utf8_general_ci', (CASE WHEN IS_NULLABLE = 'NO' THEN ' NOT NULL' ELSE '' END), ';')
-- FROM information_schema.COLUMNS 
-- WHERE TABLE_SCHEMA = 'wspdemo'
-- AND DATA_TYPE != 'varchar'
-- AND 
-- (
-- 	CHARACTER_SET_NAME != 'utf8_general_ci'
-- 	OR
-- 	COLLATION_NAME != 'utf8_general_ci'
-- );
-- 
-- SELECT table_schema, table_name, column_name, character_set_name, collation_name
-- 
-- FROM information_schema.columns
-- 
-- WHERE collation_name = 'latin1_swedish_ci'
-- 
-- ORDER BY table_schema, table_name,ordinal_position; 

-- SELECT CONCAT('ALTER TABLE `', table_name, '` MODIFY `', column_name, '` ', DATA_TYPE, ' CHARACTER SET UTF8 COLLATE utf8_general_ci', (CASE WHEN IS_NULLABLE = 'NO' THEN ' NOT NULL' ELSE '' END), ';')
-- FROM information_schema.COLUMNS 
-- WHERE TABLE_SCHEMA = 'mysql'
-- AND DATA_TYPE != 'varchar'
-- AND 
-- (
-- 	CHARACTER_SET_NAME != 'utf8'
-- 	OR
-- 	COLLATION_NAME != 'utf8_general_ci'
-- );

--procedure to check breaks at a particular date
DROP PROCEDURE IF EXISTS getBreakAtDate;
DELIMITER #

CREATE PROCEDURE getBreakAtDate(IN selectedDate DATETIME,IN advisorId int)
BEGIN
SELECT breakday,start_time,end_time
FROM breaks
WHERE breakday=DAYOFWEEK(selectedDate)
AND advisorid = advisorid;
END#

DELIMITER ;

--procedure to get time slots that are not booked and that is within advisors available time in a particular day and excludes time range which fall on breaks
DROP PROCEDURE IF EXISTS getAvailableAppointmentSlotsWithoutBreaks;
DELIMITER #
--advid here refers to advisor id
CREATE PROCEDURE getAvailableAppointmentSlotsWithoutBreaks(IN userselecteddate DATE, IN advid INTEGER)

BEGIN
DECLARE availslots INT DEFAULT 0;
DECLARE slotlimit INT DEFAULT 0;
DECLARE appointmentslots INT DEFAULT 0;
DECLARE advisingduration INT DEFAULT 0;

SET advisingduration=(SELECT duration FROM advisorschedule WHERE availday=DAYOFWEEK(userselecteddate) AND advisorid=advid);
SELECT *
FROM(
SELECT dts.start_at,dts.end_at,ads.advisorid,ads.availday
FROM(
SELECT
             num + 1 as num
                , DATE_ADD(userselecteddate, INTERVAL (slots.num * advisingduration) MINUTE) start_at
                , DATE_ADD(userselecteddate, INTERVAL ((slots.num + 1)* advisingduration) MINUTE) end_at
                , DAYOFWEEK(userselecteddate) dayofweek
            FROM (
                  /* generates 1000 rows 0 to 999 */
                  SELECT hundreds.digit * 100 + tens.digit * 10 + ones.digit AS num
                  FROM (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                       ) ones
                  CROSS JOIN (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                             ) tens
                  CROSS JOIN (
                        SELECT 0 AS digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
                        SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9
                             ) hundreds
                  ) slots
)dts
INNER JOIN advisorschedule ads
ON
ads.availday=dts.dayofweek
WHERE TIME(dts.start_at)>=ads.availfromtime 
AND TIME(dts.end_at)<=ads.availtotime
AND ads.advisorid=advid)allslotsinaday
LEFT JOIN appointments ap on
allslotsinaday.start_at=ap.starttime
AND
allslotsinaday.end_at=ap.endtime
AND
ap.status IN (1,-1)
AND
ap.advisorid=advid
LEFT JOIN breaks br ON
TIME(allslotsinaday.start_at)>=br.start_time
AND
TIME(allslotsinaday.end_at)<=br.end_time
AND
DAYOFWEEK(allslotsinaday.end_at) = br.breakday
AND
br.advisorid=advid
WHERE ap.starttime is NULL
AND br.start_time is NULL
AND  DAYOFWEEK(allslotsinaday.end_at)=DAYOFWEEK(userselecteddate)
;

END#

DELIMITER ;


DROP VIEW IF EXISTS appointmentview;
CREATE OR REPLACE VIEW appointmentview
AS
SELECT appointmentid,ap.userid,ap.advisorid appointmentdate,starttime,endtime,ap.status,b.description,u.username FROM appointments ap
JOIN usertable u
ON
ap.userid=u.userid
JOIN daytable d 
ON 
d.daynum=ap.appointmentday
JOIN bookingstatus b
ON b.status=ap.status;

DROP PROCEDURE IF EXISTS getAppointmentViewForStudent;
DELIMITER #

CREATE PROCEDURE getAppointmentViewForStudent(IN useremail VARCHAR(255))
BEGIN
SELECT *
FROM appointmentview
WHERE username=useremail;
END#

DELIMITER ;

DROP VIEW IF EXISTS advisorappointmentview;
CREATE OR REPLACE VIEW advisorappointmentview
AS
SELECT appointmentid,ap.userid,ap.advisorid,appointmentdate,starttime,endtime,ap.status,b.description AS bookingstatus,u.firstname,u.lastname,u.studentid,u.username,u.majorid FROM appointments ap
JOIN usertable u
ON
ap.userid=u.userid
JOIN daytable d 
ON 
d.daynum=ap.appointmentday
JOIN bookingstatus b
ON b.status=ap.status;

DROP TABLE IF EXISTS userimage;
create table userimage (
    fileid INT NOT NULL AUTO_INCREMENT,
    userid INT,
    useremail VARCHAR(255),
    filename VARCHAR(255),
    filetype VARCHAR(255),
    filesize BIGINT,
    filecontents LONGBLOB,  /* binary data */
    PRIMARY KEY (fileid),
    FOREIGN KEY (userid) REFERENCES usertable(userid)
    );

DROP VIEW IF EXISTS advisorscheduleview;
CREATE OR REPLACE VIEW advisorscheduleview
AS
SELECT d.daynum,d.dayname,a.advisorid,a.availfromtime,a.availtotime,a.duration FROM advisorschedule a
JOIN daytable d
on a.availday = d.daynum;

DROP PROCEDURE IF EXISTS getAdvisorSchedule;
DELIMITER #

CREATE PROCEDURE getAdvisorSchedule(IN advId int) --here advId refers to advisor Id
BEGIN
SELECT *
FROM advisorscheduleview
WHERE advisorid=advId;
END#

DELIMITER ;

DROP FUNCTION getLoggedInAdvisorId;
DELIMITER #

CREATE FUNCTION getLoggedInAdvisorId(uId INTEGER) --here uId refers to user Id
  RETURNS INT
BEGIN
  DECLARE advId INT;
  SELECT advisorid INTO advId FROM advisor WHERE userid=uId;
  RETURN advId;
END#

DELIMITER ;