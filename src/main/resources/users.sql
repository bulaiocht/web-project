DROP TABLE IF EXISTS epam_test.USERS;
CREATE TABLE epam_test.USERS (
USERID INT AUTO_INCREMENT NOT NULL,
LOGIN VARCHAR(35) NOT NULL,
PASSWORD VARCHAR(35) NOT NULL,
ACCOUNTSTATUSID INT(11),
ACCOUNTTYPEID INT(11),
FIO VARCHAR(35),
CREATEDBY INT(11),
CONSTRAINT users_pk PRIMARY KEY (USERID)
);

INSERT INTO epam_test.USERS (LOGIN, PASSWORD, ACCOUNTSTATUSID, ACCOUNTTYPEID, FIO, CREATEDBY) VALUES
  ("user1", "user1", 1, 1, "User Michailovich", 1),
  ("user2", "user2", 2, 2, "User Ivanovich", 1),
  ("user3", "user3", 1, 1, "User Martynovich", 1);