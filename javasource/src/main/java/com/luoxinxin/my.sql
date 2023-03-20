show create table tbl_user;

CREATE TABLE `t_teacher` (
                             `tid` int NOT NULL AUTO_INCREMENT,
                             `tname ` varchar(100) DEFAULT NULL,
                             PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_student` (
                             `stuid` int NOT NULL AUTO_INCREMENT,
                             `tname` varchar(100) DEFAULT NULL,
                             `age` int,
                             `sex` char(1),
                             PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_course` (
                            `cid` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) DEFAULT NULL,
                            `teacherid` int,
                            PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ` t_sc` (
                         `stuid` int,
                         `cid` int,
                         `score` int,
                         PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


select * from t_teacher where tname = "李老师"
select c.cid,c.name,t.name,s.name
select s.* from t_student in()
select t.* from t_teacher t
select c.* from t_course c
select * from t_sc sc left join t_techer t on sc;