USE fourthweek;
drop table if exists  `pass_num`;
CREATE TABLE pass_num(
                 id smallint NOT NULL,
                 number smallint NOT NULL,
                 PRIMARY KEY (id));
INSERT INTO pass_num VALUES(1,4);
INSERT INTO pass_num VALUES(2,3);
INSERT INTO pass_num VALUES(3,3);
INSERT INTO pass_num VALUES(4,2);
INSERT INTO pass_num VALUES(5,5);
INSERT INTO pass_num VALUES(6,4);
SELECT m.id,m.number,COUNT(distinct n.number) AS t_rank
FROM pass_num AS m,pass_num AS n
WHERE m.number<=n.number
GROUP BY m.id
ORDER BY t_rank ASC,m.id ASC
