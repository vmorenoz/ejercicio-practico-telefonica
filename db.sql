create table customer
(
    id              serial       not null primary key,
    full_name       varchar(200) not null,
    document_type   char(1)      not null,
    document_number varchar(20)  not null unique,
    birthday_date   date         null,
    created_at      timestamp    not null default current_timestamp,
    updated_at      timestamp    null
);

create table plan
(
    id         serial        not null primary key,
    name       varchar(50)   not null,
    price      decimal(5, 2) not null,
    created_at timestamp     not null default current_timestamp,
    updated_at timestamp     null
);

create table mobile_line
(
    id           serial      not null primary key,
    phone_number varchar(15) not null unique,
    line_status  bool        not null default true,
    line_type    char(1)     not null,
    plan_id      int         not null
        constraint fk_mobile_line_plan
            references plan (id),
    customer_id  int         not null
        constraint fk_mobile_line_customer
            references customer (id),
    created_at   timestamp   not null default current_timestamp,
    updated_at   timestamp   null
);

create table offer
(
    id          serial          not null primary key,
    code        char(10) unique not null,
    description varchar(250)    not null,
    valid_from  date            not null,
    valid_to    date            not null,
    created_at  timestamp       not null default current_timestamp,
    updated_at  timestamp       null
);

create table mobile_line_offer
(
    id             serial    not null primary key,
    mobile_line_id int       not null
        constraint fk_mobile_line_offer_mobile_line
            references mobile_line (id),
    offer_id       int       not null
        constraint fk_mobile_line_offer_offer
            references offer (id),
    created_at     timestamp not null default current_timestamp,
    updated_at     timestamp null
);

