-- Table: Account

-- DROP TABLE Account;

CREATE TABLE Account
(
  id         BIGINT NOT NULL,
  first_name CHARACTER VARYING(255),
  last_name  CHARACTER VARYING(255),
  email      TEXT,
  CONSTRAINT Account_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE Account
OWNER TO admin;


-- Table: Guest

-- DROP TABLE Guest;

CREATE TABLE Guest
(
  id           BIGINT NOT NULL,
  name         TEXT,
  signing_date DATE,
  CONSTRAINT Guest_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE Guest
OWNER TO admin;


-- Table: Question

-- DROP TABLE Question;

CREATE TABLE Question
(
  id               BIGINT NOT NULL,
  question_content TEXT,
  question_type    CHARACTER VARYING(255),
  CONSTRAINT Question_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE Question
OWNER TO admin;

