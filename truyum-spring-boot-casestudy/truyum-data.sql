create database casestudy;
use casestudy;

-- 1. Create menu_item table
create table if not exists menu_table(
	item_id int primary key,
    item_name varchar(50),
    item_price decimal(5,2),
    item_active varchar(4),
    date_of_launch date,
    category varchar(20),
    free_delivery varchar(4),
    
    constraint ck_item_active check(item_active='Yes' or item_active='No'),
    constraint ck_category check(category='Main Course' or category='Starters' or category='Dessert'),
    constraint ck_free_delivery check(free_delivery='Yes' or free_delivery='No')
    
    
);


-- 1.a  insert scripts to add data into menu_item table
insert into menu_table
values (1,'Sandwich',99.00,'Yes',str_to_date('15-03-2017', '%d-%m-%Y'),'Main Course','Yes'),
(2,'Burger',129.00,'Yes',str_to_date('23-12-2017', '%d-%m-%Y'),'Main Course','No'),
(3,'Pizza',149.00,'Yes',str_to_date('21-08-2017', '%d-%m-%Y'),'Main Course','No'),
(4,'French Fries',57.00,'No',str_to_date('02-07-2017', '%d-%m-%Y'),'Starters','Yes'),
(5,'Chocolate Brownie',32.00,'Yes',str_to_date('02-11-2022', '%d-%m-%Y'),'Dessert','Yes');

-- 1.b Frame SQL query to get all menu items
select * from menu_table;

-- 2.a Frame SQL query to get all menu items which after launch date and is active
select * from menu_table
where date_of_launch <= NOW() and item_active = 'Yes';

-- 3.a Frame SQL query to get a menu items based on Menu Item Id
select * from menu_table
where item_id=4;   -- id hard coded 

-- 3.b Frame SQL query to update values of all menu items based on Menu Item Id
update menu_table
set item_name="French Fry",
item_price=50.00,
item_active='Yes',
date_of_launch=str_to_date('02-07-2017', '%d-%m-%Y'),
category='Starters',
free_delivery='Yes'
where item_id=4;   -- id hard coded 

select * from menu_table;

-- 4. create User table and Cart table
create table users(
user_id int primary key,
user_name varchar(50),
user_password varchar(50)
);

insert into users
values (1,'user1','user1@123'),
(2,'user2','user2@123');  -- two users => user1 and user2

create table cart(
cart_id int primary key,
item_id int,
user_id int,

foreign key fk_item_id (item_id) references menu_table(item_id),
foreign key fk_user_id (user_id) references users(user_id)
);

-- 4.a  Once user will not have any entries in cart, while the other will have at least 3 items in the cart
insert into cart
values (1,1,1),
(2,4,1),
(3,3,1);   -- user1 have 3 items in cart, user2 do not have any items in cart



-- 5.a Frame SQL query to get all menu items in a particular user’s cart
select * from cart,users
where cart.user_id=users.user_id;

-- 5.b Frame SQL query to get the total price of all menu items in a particular user’s cart
select sum(item_price) from menu_table
join cart on menu_table.item_id=cart.item_id
where cart.user_id=1;

-- 6.a Frame SQL query to remove a menu items from Cart based on User Id and Menu Item Id
delete from cart
where cart.user_id=1 and cart.item_id=1;

select * from cart 
join menu_table 
on menu_table.item_id=cart.item_id
where user_id=1;

select * from menu_table;

alter table cart
modify column cart_id int auto_increment;

alter table cart
auto_increment=1;