\echo 'Вывод: всей таблицы';
SELECT *
  FROM jaegers
 ORDER BY model_name;

\echo 'Вывод: только не уничтоженных роботов';
SELECT *
  FROM jaegers
 WHERE status = 'Active'
 ORDER BY model_name;

\echo 'Вывод: только роботов серии Mark-1 и Mark-4';
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4')
 ORDER BY model_name;

\echo 'Вывод: всех роботов, кроме Mark-1 и Mark-4';
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY model_name DESC;

\echo 'Вывод: информацию о самых старых роботах';
SELECT *
  FROM jaegers
 WHERE launch = 
         (SELECT Max(launch)
  FROM jaegers)
 ORDER BY model_name;


\echo 'Вывод: инфу из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju';
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill = 
        (SELECT Max(kaiju_kill) FROM jaegers)
 ORDER BY model_name; 


\echo 'Вывод: средний вес роботов, округлив его до трех знаков после запятой';
SELECT ROUND(AVG(weight)::NUMERIC , 3) 
  FROM jaegers;

\echo 'Вывод: увеличьте на единицу количество уничтоженных kaiju у неразрушенных роботов,а затем отобразите таблицу';
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = 'Active';
SELECT *
  FROM jaegers;

\echo 'Вывод: удалите уничтоженных роботов, а затем отобразите оставшихся';
DELETE 
  FROM jaegers
 WHERE status = 'Destroyed';
SELECT *
  FROM jaegers;