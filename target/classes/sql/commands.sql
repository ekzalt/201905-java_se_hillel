-- set sql time zone
SET GLOBAL time_zone = '+00:00';

-- select films between years
SELECT * FROM `local`.films
  INNER JOIN `local`.directors ON `local`.films.director_id = `local`.directors.id
  WHERE released BETWEEN '2008-01-01' AND '2018-12-31';

-- select actors by film id
SELECT * FROM `local`.films_actors
  INNER JOIN `local`.actors ON `local`.films_actors.actor_id = `local`.actors.id
  WHERE `local`.films_actors.film_id = 1;

-- select film id by film name
SELECT id FROM `local`.films
  WHERE name LIKE '%Captain America%' LIMIT 1;

-- select duplicates (entries) by field / select actors who have more than 1 film
SELECT *, COUNT(*) as entries FROM `local`.films_actors
  INNER JOIN `local`.actors ON `local`.films_actors.actor_id = `local`.actors.id
  GROUP BY `local`.films_actors.actor_id
  HAVING entries >= 2;

-- select director by name and born
SELECT * FROM `local`.directors
  WHERE `local`.directors.name LIKE '%test%' AND `local`.directors.born = '1980-01-07' LIMIT 1;

/*
-- delete old films
DELETE FROM `local`.films
  WHERE released < '2000-01-01';
*/
