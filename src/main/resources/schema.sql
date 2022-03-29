/*ユーザマスタ*/
CREATE TABLE IF NOT EXISTS m_user
(
name VARCHAR(50) PRIMARY KEY,
 birthday DATE,
 age INT,
 gender INT
);

CREATE TABLE IF NOT EXISTS m_diary
(
title VARCHAR(50) PRIMARY KEY,
day DATE,
face INT,
text VARCHAR
);