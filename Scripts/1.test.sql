select * from `member`;

delete from `member` where id = 41;

-- selectByAll
select id,email,password as passwd,name,regdate from member;

-- selectById
select id,email,password as passwd,name,regdate
from `member` 
where email = 'slswkzkzktl12@naver.com';

-- insert
insert into `member`(email,passwd,name,regdate) values
	(?,?,?,?);
	
-- update
update `member` set name=?, password=?, where email=?