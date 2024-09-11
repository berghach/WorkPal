-- @block
CREATE TYPE role AS ENUM('admin', 'manager', 'member');
-- CREATE TYPE event_type AS ENUM('conference', 'seminar', 'meeting', 'workshop');
-- CREATE TYPE booking_status AS ENUM('ongoing', 'confirmed', 'canceled', 'past');
-- @block
CREATE TABLE IF NOT EXISTS space_type(
    id SERIAL,
    name VARCHAR(30),
    CONSTRAINT pk_space_type PRIMARY KEY(id, name)
);
-- @block
CREATE TABLE IF NOT EXISTS users(
    id SERIAL,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    role_name role,
    email VARCHAR(25),
    password VARCHAR(225),
    CONSTRAINT pk_user PRIMARY KEY(id, email)
);
-- @block
CREATE TABLE IF NOT EXISTS admin()INHERITS(users);
-- @block
CREATE TABLE IF NOT EXISTS member(
    job VARCHAR(30)
)INHERITS(users);
-- @block
CREATE TABLE IF NOT EXISTS manager(
    departement VARCHAR(30)
)INHERITS(users);
-- @block
CREATE TABLE IF NOT EXISTS spaces(
    id SERIAL,
    title VARCHAR(20),
);
-- @block
CREATE TABLE IF NOT EXISTS services();
-- @block
CREATE TABLE IF NOT EXISTS plan();