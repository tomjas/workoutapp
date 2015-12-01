-- Table: wo_user

-- DROP TABLE wo_user;

CREATE TABLE wo_user
(
  user_id integer NOT NULL,
  email character varying(32),
  first_name character varying(255),
  last_name character varying(255),
  login character varying(255),
  paswword character varying(64),
  CONSTRAINT wo_user_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wo_user
  OWNER TO tomek;