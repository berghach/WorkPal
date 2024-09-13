-- @block
CREATE TYPE role AS ENUM('admin', 'manager', 'member');
-- @block
CREATE TABLE IF NOT EXISTS space_type(
    id SERIAL,
    name VARCHAR(30),
    CONSTRAINT pk_space_type PRIMARY KEY(id),
    CONSTRAINT must_be_unique_name UNIQUE(name)
);
-- @block
CREATE TABLE IF NOT EXISTS users(
    id SERIAL,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    role_name role,
    email VARCHAR(25),
    password VARCHAR(225),
    CONSTRAINT pk_user PRIMARY KEY(id),
    CONSTRAINT must_be_unique_email UNIQUE(email)
);
-- @block
CREATE TABLE IF NOT EXISTS admin(
    CONSTRAINT pk_user_admin PRIMARY KEY(id),
    CONSTRAINT must_be_unique_email_admin UNIQUE(email)
)INHERITS(users);
-- to respect the data integrity, by maintaining the role for each row
ALTER TABLE admin
ALTER COLUMN role_name SET DEFAULT 'admin';
-- @block
CREATE TABLE IF NOT EXISTS member(
    job VARCHAR(30),
    CONSTRAINT pk_user_member PRIMARY KEY(id),
    CONSTRAINT must_be_unique_email_member UNIQUE(email)
)INHERITS(users);
-- to respect the data integrity, by maintaining the role for each row
ALTER TABLE member
ALTER COLUMN role_name SET DEFAULT 'member';
-- @block
CREATE TABLE IF NOT EXISTS manager(
    departement VARCHAR(30),
    CONSTRAINT pk_user_manager PRIMARY KEY(id),
    CONSTRAINT must_be_unique_email_manager UNIQUE(email)
)INHERITS(users);
-- to respect the data integrity, by maintaining the role for each row
ALTER TABLE manager
ALTER COLUMN role_name SET DEFAULT 'manager';
-- @block
CREATE TABLE IF NOT EXISTS spaces(
    id SERIAL,
    title VARCHAR(20),
    description VARCHAR(500),
    capacity INT,
    price FLOAT,
    space_type_id INT,
    manager_id INT,
    CONSTRAINT pk_spaces PRIMARY KEY(id),
    CONSTRAINT fk_space_type FOREIGN KEY (space_type_id) 
        REFERENCES space_type(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_manager FOREIGN KEY(manager_id)
        REFERENCES manager(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS services(
    id SERIAL,
    name VARCHAR(20),
    description VARCHAR(500),
    price FLOAT,
    manager_id INT,
    CONSTRAINT pk_services PRIMARY KEY(id),
    CONSTRAINT fk_manager FOREIGN KEY(manager_id)
        REFERENCES manager(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS plan(
    id SERIAL,
    title VARCHAR(30),
    description VARCHAR(500),
    period INTERVAL,
    price FLOAT,
    manager_id INT,
    CONSTRAINT pk_plan PRIMARY KEY(id),
    CONSTRAINT fk_manager FOREIGN KEY(manager_id)
        REFERENCES manager(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS subscription(
    id SERIAL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    is_expired BOOLEAN,
    is_canceled BOOLEAN,
    member_id INT,
    plan_id INT,
    CONSTRAINT pk_subscription PRIMARY KEY(id),
    CONSTRAINT fk_member FOREIGN KEY(member_id)
        REFERENCES member(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_plan FOREIGN KEY(plan_id)
        REFERENCES plan(id)
        ON DELETE CASCADE
);
ALTER TABLE subscription
ALTER COLUMN is_expired SET DEFAULT FALSE;
ALTER TABLE subscription
ALTER COLUMN is_canceled SET DEFAULT FALSE;
-- @block
CREATE TYPE event_type AS ENUM('conference', 'seminar', 'meeting', 'workshop');
-- @block
CREATE TABLE IF NOT EXISTS events(
    id SERIAL,
    title VARCHAR(30),
    date TIMESTAMP,
    location VARCHAR(30),
    event_type event_type,
    space_id INT,
    CONSTRAINT pk_events PRIMARY KEY(id),
    CONSTRAINT fk_spaces FOREIGN KEY(space_id)
        REFERENCES spaces(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS registration(
    id SERIAL,
    date TIMESTAMP,
    member_id INT,
    event_id INT,
    CONSTRAINT pk_registration PRIMARY KEY(id),
    CONSTRAINT fk_member FOREIGN KEY(member_id)
        REFERENCES member(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_event FOREIGN KEY(event_id)
        REFERENCES events(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS favorite(
    member_id INT,
    space_id INT,
    CONSTRAINT fk_member FOREIGN KEY(member_id)
        REFERENCES member(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_space FOREIGN KEY(space_id)
        REFERENCES spaces(id)
        ON DELETE CASCADE,
    CONSTRAINT must_be_unique_pair_favorite UNIQUE(member_id, space_id)
);
-- @block
CREATE TABLE IF NOT EXISTS review(
    id SERIAL,
    rate INT CHECK(rate < 6 AND rate > 0),
    comment VARCHAR(500),
    member_id INT,
    space_id INT,
    CONSTRAINT pk_review PRIMARY KEY(id),
    CONSTRAINT fk_member FOREIGN KEY(member_id)
        REFERENCES member(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_space FOREIGN KEY(space_id)
        REFERENCES spaces(id)
        ON DELETE CASCADE,
    CONSTRAINT must_be_unique_pair_review UNIQUE(member_id, space_id)
);
-- @block
CREATE TYPE booking_status AS ENUM('ongoing', 'confirmed', 'canceled', 'past');
-- @block
CREATE TABLE IF NOT EXISTS booking(
    id SERIAL,
    booking_date TIMESTAMP,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    member_id INT,
    space_id INT NULL,
    service_id INT NULL,
    status booking_status,
    CONSTRAINT pk_booking PRIMARY KEY(id),
    CONSTRAINT fk_member FOREIGN KEY(member_id)
        REFERENCES member(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_space FOREIGN KEY(space_id)
        REFERENCES spaces(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_service FOREIGN KEY(service_id)
        REFERENCES services(id)
        ON DELETE CASCADE
);
-- @block
CREATE TABLE IF NOT EXISTS payment(
    id SERIAL,
    is_payed BOOLEAN,
    total_price FLOAT,
    booking_id INT NULL,
    subscription_id INT NULL,
    CONSTRAINT pk_payment PRIMARY KEY(id),
    CONSTRAINT fk_booking FOREIGN KEY(booking_id)
        REFERENCES booking(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_subscription FOREIGN KEY(subscription_id)
        REFERENCES subscription(id)
        ON DELETE CASCADE
);