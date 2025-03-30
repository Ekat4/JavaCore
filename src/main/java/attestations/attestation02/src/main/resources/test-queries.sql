-- test-queries.sql

-- 1. Чтение данных из таблицы Товар
-- Получаем все товары
SELECT * FROM product;

-- Получаем товар с конкретным id
SELECT * FROM product WHERE id = 1;

-- 2. Чтение данных из таблицы Покупатель
-- Получаем всех пользователей
SELECT * FROM users;

-- Получаем покупателя с конкретным id
SELECT * FROM users WHERE id = 1;

-- 3. Чтение данных из таблицы Заказ
-- Получаем все заказы
SELECT * FROM orders;

-- Получаем заказ с конкретным id
SELECT * FROM orders WHERE id = 1;

-- 4. Изменение данных в таблице Товар
-- Изменяем цену товара с id = 1
UPDATE product SET price = 120.00 WHERE id = 1;

-- Изменяем количество товара с id = 2
UPDATE product SET quantity = 25 WHERE id = 2;

-- 5. Изменение данных в таблице Покупатель
-- Изменяем имя покупателя с id = 1
UPDATE users SET full_name = 'Иван Петров' WHERE id = 1;

-- 6. Изменение данных в таблице Заказ
-- Изменяем количество товаров в заказе с id = 1
UPDATE orders SET quantity = 4 WHERE id = 1;

-- 7. Удаление данных из таблицы Товар
-- Удаляем товар с id = 10
DELETE FROM product WHERE id = 10;

-- 8. Удаление данных из таблицы Покупатель
-- Удаляем пользователя с id = 9
DELETE FROM users WHERE id = 9;

-- 9. Удаление данных из таблицы Заказ
-- Удаляем заказ с id = 5
DELETE FROM orders WHERE id = 5;
