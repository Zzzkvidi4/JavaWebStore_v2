CREATE TABLE product_types(
	product_type_id int auto_increment primary key,
    name varchar(40) not null
);

CREATE TABLE countries(
	country_id int auto_increment primary key,
    name varchar(20) not null
);

CREATE TABLE products(
	product_id int auto_increment primary key,
    product_type_id int not null,
    country_id int not null,
    name text not null,
    count int not null,
    price decimal not null,
    index product_type_index (product_type_id),
    index country_index (country_id),
    constraint product_type_fk foreign key (product_type_id) references  product_types(product_type_id),
    constraint country_fk foreign key (country_id) references countries(country_id)
);

CREATE TABLE product_type_params(
	product_type_param_id int auto_increment primary key,
    product_type_id int not null,
    name varchar(45) not null,
    type varchar(30) not null,
    comment varchar(50),
    is_optional boolean not null,
    index product_type_index (product_type_id),
    constraint product_type_fk foreign key (product_type_id) references product_types(product_type_id)
);

CREATE TABLE product_param_values(
	product_id int not null,
    product_type_param_id int not null,
    value varchar(45) not null,
    constraint param_values_pk primary key (product_id, product_type_param_id),
    index product_index (product_id),
    index product_index (product_type_param_id),
    constraint product_fk foreign key (product_id) references products(product_id),
    constraint product_type_param_fk foreign key (product_type_param_id) references product_type_params(product_type_param_id)
);

CREATE TABLE statuses(
	status_id int auto_increment primary key,
    name varchar(20) not null,
    display_name varchar(30) not null
);

CREATE TABLE orders(
	order_id int auto_increment primary key,
    user_id int not null,
    date datetime not null,
    status_id int not null,
    price decimal not null,
    index status_index (status_id),
    index user_index (user_id),
    constraint status_fk foreign key (status_id) references statuses(status_id),
    constraint user_fk foreign key (user_id) references users(user_id)
);

CREATE TABLE order_items(
	order_item_id int auto_increment primary key,
    product_id int not null,
    order_id int not null,
    count int not null,
    index product_index (product_id),
    index order_index (order_id),
    constraint order_product_un unique (product_id, order_id),
    constraint order_fk foreign key (order_id) references orders(order_id),
    constraint product_fk foreign key (product_id) references products(product_id)
);