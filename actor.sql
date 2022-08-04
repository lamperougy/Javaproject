USE fourthweek;
drop table if exists  `actor`;
CREATE TABLE actor  (
                        actor_id  smallint(5)  NOT NULL PRIMARY KEY,
                        first_name  varchar(45) NOT NULL,
                        last_name  varchar(45) NOT NULL,
                        last_update  datetime NOT NULL);
#代码测试
ALTER TABLE actor ADD UNIQUE INDEX uniq_idx_firstname(first_name);
ALTER TABLE actor ADD INDEX idx_lastname(last_name);
INSERT INTO actor VALUES(0,'wu','zhou','2002-10-03 00:00:00');
INSERT INTO actor VALUES(1,'lelouch','lamperougy','2000-12-05 00:00:00');
INSERT INTO actor VALUES(2,'cc','love','501-02-14 00:00:00');
SELECT *
FROM actor
WHERE first_name='wu'
UNION
SELECT *
FROM actor
WHERE last_name='lamperougy'
