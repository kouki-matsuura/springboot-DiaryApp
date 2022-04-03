/*ユーザマスタ*/
CREATE TABLE IF NOT EXISTS m_user
(
name VARCHAR(50) PRIMARY KEY,
photo VARCHAR,
 birthday DATE,
 age INT,
 gender INT,
 content VARCHAR
);

CREATE TABLE IF NOT EXISTS m_diary
(
title VARCHAR(50),
day DATE,
face VARCHAR,
text VARCHAR
);