-- Table: wo_user

-- DROP TABLE wo_user;

CREATE TABLE wo_user
(
  user_id integer NOT NULL,
  username character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  email character varying(255),
  role character varying(32),
  paswword character varying(64),
  CONSTRAINT wo_user_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wo_user
  OWNER TO tomek;
