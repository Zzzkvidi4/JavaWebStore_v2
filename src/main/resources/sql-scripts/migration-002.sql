INSERT 
	INTO ROLES(name, display_name) 
    VALUES ('ADMIN', 'Администратор');
INSERT 
	INTO ROLES(name, display_name) 
	VALUES ('USER', 'Пользователь');

INSERT 
	INTO USERS(name, surname, login, email, password)
	VALUES ('Роман', 'Скиданов', 'Zzzkvidi4', 'abcd', 'admin');
INSERT 
	INTO USERS(name, surname, login, email, password)
	VALUES ('Аня', 'Акинина', 'Salatik', 'abcde', 'user');
    
INSERT
	INTO USER_ROLES(user_id, role_id)
    VALUES(1, 1);
INSERT
	INTO USER_ROLES(user_id, role_id)
    VALUES(1, 2);
INSERT
	INTO USER_ROLES(user_id, role_id)
    VALUES(2, 2);
    

