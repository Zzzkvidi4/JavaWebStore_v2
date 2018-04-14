CREATE TABLE users(
	user_id int auto_increment primary key,
    name varchar(45),
    surname varchar(45),
    login varchar(45) not null unique,
    email varchar(45) not null unique,
    password varchar(45) not null
);

CREATE TABLE roles(
	role_id int auto_increment primary key,
    name varchar(20) not null,
    display_name varchar(20) not null
);

CREATE TABLE user_roles(
	user_id int not null,
    role_id int not null,
    CONSTRAINT user_roles_pk PRIMARY KEY(user_id, role_id),
    INDEX user_index (user_id),
    INDEX role_index (role_id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

DROP TABLE user_roles;
DROP TABLE users;
DROP TABLE roles;