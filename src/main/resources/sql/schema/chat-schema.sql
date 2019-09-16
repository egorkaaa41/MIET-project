begin;

drop schema if exists service cascade;
create schema service;

drop table if exists service.codes;
create table service.codes (
  id    serial            not null,
  code  INTEGER  unique   not null,

  primary key (id)
);

drop table if exists service.transactions;
create table service.transactions (
  code       INTEGER      unique not null,
  status     varchar(8)          not null,
  time       timestamp           not null,
  contractnumber  INTEGER unique not null,

  FOREIGN KEY (code) REFERENCES service.codes(code)
);

commit;
