

-- Проверка существования таблиц
SELECT * FROM information_schema.tables WHERE table_name = 'client';
SELECT * FROM information_schema.tables WHERE table_name = 'trainer';
SELECT * FROM information_schema.tables WHERE table_name = 'athlete';
SELECT * FROM information_schema.tables WHERE table_name = 'workout';
SELECT * FROM information_schema.tables WHERE table_name = 'result';


-- 1. Чтение данных из таблицы Клиент
-- Получаем всех клиентов
SELECT * FROM client;  -- Исправлено на правильное название таблицы

-- Получаем клиента с конкретным id
SELECT * FROM client WHERE id = 1;

-- 2. Чтение данных из таблицы Тренер
-- Получаем всех тренеров
SELECT * FROM trainer;  -- Исправлено на правильное название таблицы

-- Получаем тренера с конкретным id
SELECT * FROM trainer WHERE id = 1;  -- Замените 1 на нужный id

-- 3. Чтение данных из таблицы Спортсмен
-- Получаем всех спортсменов
SELECT * FROM athlete;  -- Исправлено на правильное название таблицы

-- Получаем спортсмена с конкретным id
SELECT * FROM athlete WHERE id = 1;  -- Замените 1 на нужный id

-- 4. Изменение данных в таблице Клиент
-- Изменяем имя клиента с id = 1
UPDATE client SET full_name = 'Иван Иванов' WHERE id = 1;  -- Исправлено на правильное название колонки

-- 5. Изменение данных в таблице Тренер
-- Изменяем имя тренера с id = 1
UPDATE trainer SET full_name = 'Виталий Семенов' WHERE id = 1;  -- Исправлено на правильное название колонки

-- 6. Изменение данных в таблице Спортсмен
-- Изменяем имя спортсмена с id = 1
UPDATE athlete SET full_name = 'Ярослав Филимонов' WHERE id = 1;  -- Исправлено на правильное название колонки

-- 7. Удаление данных из таблицы Клиент
-- Удаляем клиента с id = 10
DELETE FROM client WHERE id = 10;

-- 8. Удаление данных из таблицы Тренер
-- Удаляем тренера с id = 9
DELETE FROM trainer WHERE id = 9;

-- 9. Удаление данных из таблицы Спортсмен
-- Удаляем спортсмена с id = 5
DELETE FROM athlete WHERE id = 5;

