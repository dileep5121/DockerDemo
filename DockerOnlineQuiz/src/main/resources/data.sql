insert into USERS
(username,enabled,firstname,lastname,password,type)
values
('roger@gmail.com',1,'Roger','Kutcher','{noop}wipro@123','admin'),
('steve@gmail.com',1,'Steve','Martin','{noop}wipro@123','admin');


insert into AUTHORITIES(username,authority)
values
('roger@gmail.com','ROLE_admin'),
('steve@gmail.com','ROLE_admin');


