-- Table: account

-- DROP TABLE account;

CREATE TABLE account
(
  id       BIGINT  NOT NULL,
  username TEXT    NOT NULL,
  password TEXT    NOT NULL,
  fullname TEXT    NOT NULL,
  address  TEXT    NOT NULL,
  mobile   TEXT    NOT NULL,
  role     INTEGER NOT NULL,
  active   INTEGER NOT NULL,
  CONSTRAINT account_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE account
OWNER TO admin;


-- Table: article

-- DROP TABLE article;

CREATE TABLE article
(
  id        BIGINT  NOT NULL,
  tittle    TEXT    NOT NULL,
  content   TEXT    NOT NULL,
  type      INTEGER NOT NULL,
  active    INTEGER NOT NULL,
  thumbnail TEXT    NOT NULL,
  address   INTEGER NOT NULL,
  CONSTRAINT article_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE article
OWNER TO admin;


-- Table: bill

-- DROP TABLE bill;

CREATE TABLE bill
(
  id           BIGINT  NOT NULL,
  serialnumber TEXT    NOT NULL,
  type         TEXT    NOT NULL,
  sendform     TEXT    NOT NULL,
  senddate     TEXT    NOT NULL,
  sendto       TEXT    NOT NULL,
  service      TEXT    NOT NULL,
  status       INTEGER NOT NULL,
  CONSTRAINT bill_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE bill
OWNER TO admin;


-- Table: billdetail

-- DROP TABLE billdetail;

CREATE TABLE billdetail
(
  id     BIGINT  NOT NULL,
  billid INTEGER NOT NULL,
  date   TEXT    NOT NULL,
  detail TEXT    NOT NULL,
  CONSTRAINT billdetail_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE billdetail
OWNER TO admin;


-- Table: feedback

-- DROP TABLE feedback;

CREATE TABLE feedback
(
  id      BIGINT  NOT NULL,
  name    TEXT    NOT NULL,
  email   TEXT    NOT NULL,
  phone   TEXT    NOT NULL,
  title   TEXT    NOT NULL,
  content TEXT    NOT NULL,
  status  INTEGER NOT NULL,
  CONSTRAINT feedback_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE feedback
OWNER TO admin;



-- Table: partner

-- DROP TABLE partner;

CREATE TABLE partner
(
  id          BIGINT  NOT NULL,
  name        TEXT    NOT NULL,
  link        TEXT    NOT NULL,
  logo        TEXT    NOT NULL,
  description TEXT    NOT NULL,
  active      INTEGER NOT NULL,
  CONSTRAINT partner_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE partner
OWNER TO admin;


-- Table: pricelist

-- DROP TABLE pricelist;

CREATE TABLE pricelist
(
  id            BIGINT  NOT NULL,
  address       INTEGER NOT NULL,
  title         TEXT    NOT NULL,
  linkgoogledoc TEXT    NOT NULL,
  linkpdf       TEXT    NOT NULL,
  linkword      TEXT    NOT NULL,
  linkimage     TEXT    NOT NULL,
  active        INTEGER NOT NULL,
  CONSTRAINT pricelist_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE pricelist
OWNER TO admin;


-- Table: statistic

-- DROP TABLE statistic;

CREATE TABLE statistic
(
  id     BIGINT NOT NULL,
  date   TEXT   NOT NULL,
  amount BIGINT NOT NULL,
  CONSTRAINT statistic_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE statistic
OWNER TO admin;


-- Table: support

-- DROP TABLE support;

CREATE TABLE support
(
  id     BIGINT  NOT NULL,
  type   INTEGER NOT NULL,
  name   TEXT    NOT NULL,
  phone  TEXT    NOT NULL,
  email  TEXT    NOT NULL,
  value  TEXT    NOT NULL,
  active INTEGER NOT NULL,
  CONSTRAINT support_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE support
OWNER TO admin;
