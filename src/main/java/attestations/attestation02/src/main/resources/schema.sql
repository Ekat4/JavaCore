

-- Создание таблицы users
create table if not exists users (
    id bigserial primary key,  -- Уникальный идентификатор пользователя
    fio varchar(222)           -- Полное имя пользователя
);

-- Добавление комментария к таблице users
comment on table users is'Таблица покупателей!';


-- Создание таблицы orders
create table if not exists orders (
    id bigserial primary key,           -- Уникальный идентификатор заказа
    user_id bigint references users(id),  -- Внешний ключ на таблицу users
    order_date date,                    -- Дата заказа
    count_of_orders numeric,            -- Общее количество заказов
    user_discount numeric                -- Скидка пользователя
);

