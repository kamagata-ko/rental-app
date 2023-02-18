CREATE TABLE "t_book" (
  "id" char PRIMARY KEY,
  "name" varchar NOT NULL,
  "status" integer NOT NULL,
  "arrival_date" timestamp NOT NULL DEFAULT (now()),
  "update_date" timestamp,
  "delete_flg" integer NOT NULL
);

CREATE TABLE "t_customer" (
  "id" char PRIMARY KEY,
  "password" varchar NOT NULL,
  "name" varchar,
  "sex" integer,
  "birthday" date,
  "register_date" timestamp NOT NULL DEFAULT (now()),
  "update_date" timestamp
);

CREATE TABLE "t_staff" (
  "id" char PRIMARY KEY,
  "name" varchar,
  "authority_flg" integer NOT NULL DEFAULT (0),
  "update_date" timestamp,
  "koushin_date" timestamp
);

CREATE TABLE "t_rental_history" (
  "id" char PRIMARY KEY,
  "customer_id" char NOT NULL,
  "book_id" char NOT NULL,
  "rental_start_date" timestamp NOT NULL DEFAULT (now()),
  "scheduled_return_date" timestamp NOT NULL,
  "return_completion_date" timestamp
);

CREATE TABLE "t_kubunti" (
  "id" char PRIMARY KEY,
  "kubun_code" char NOT NULL,
  "kubun_name" varchar NOT NULL
);

ALTER TABLE "t_rental_history" ADD FOREIGN KEY ("customer_id") REFERENCES "t_customer" ("id");

ALTER TABLE "t_rental_history" ADD FOREIGN KEY ("book_id") REFERENCES "t_book" ("id");
