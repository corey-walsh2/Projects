Create database it241_1_2021;
Create database it241_2_2021;

create user it241_1_2021 with encrypted password 'it241';
create user it241_2_2021 with encrypted password 'it241';

grant all privileges on database it241_1_2021 to it241_1_2021;
grant all privileges on database it241_2_2021 to it241_2_2021;

create user walshc30 with encrypted password 'it241';
create user nelsont5 with encrypted password 'it241';
create user carmadellaa2 with encrypted password 'it241';
create user gildeac2 with encrypted password 'it241';

grant connect on it241_1_2021 to walshc30
grant connect on it241_1_2021 to nelsont5
grant connect on it241_2_2021 to carmadellaa2;
grant connect on it241_2_2021 to gildeac2;

grant select, insert, update, delete on it241_1_2021 to walshc30;
grant select, insert, update, delete on it241_1_2021 to nelsont5;
grant select, insert, update, delete on it241_2_2021 to carmadellaa2;
grant select, insert, update, delete on it241_2_2021 to gildeac2;







