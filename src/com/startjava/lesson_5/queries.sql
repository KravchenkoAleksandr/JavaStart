\echo '�����: ���� �������';
SELECT *
  FROM jaegers
 ORDER BY model_name;

\echo '�����: ������ �� ������������ �������';
SELECT *
  FROM jaegers
 WHERE status = 'Active'
 ORDER BY model_name;

\echo '�����: ������ ������� ����� Mark-1 � Mark-4';
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4')
 ORDER BY model_name;

\echo '�����: ���� �������, ����� Mark-1 � Mark-4';
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY model_name DESC;

\echo '�����: ���������� � ����� ������ �������';
SELECT *
  FROM jaegers
 WHERE launch = 
         (SELECT Max(launch)
  FROM jaegers)
 ORDER BY model_name;


\echo '�����: ���� �� �������� model_name, mark, launch, kaiju_kill ��� �������, ������� ���������� ������ ���� kaiju';
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill = 
        (SELECT Max(kaiju_kill) FROM jaegers)
 ORDER BY model_name; 


\echo '�����: ������� ��� �������, �������� ��� �� ���� ������ ����� �������';
SELECT ROUND(AVG(weight)::NUMERIC , 3) 
  FROM jaegers;

\echo '�����: ��������� �� ������� ���������� ������������ kaiju � ������������� �������,� ����� ���������� �������';
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = 'Active';
SELECT *
  FROM jaegers;

\echo '�����: ������� ������������ �������, � ����� ���������� ����������';
DELETE 
  FROM jaegers
 WHERE status = 'Destroyed';
SELECT *
  FROM jaegers;