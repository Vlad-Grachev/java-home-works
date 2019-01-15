CREATE database hw9;

CCREATE TABLE public.buyers
(
    id integer NOT NULL,
    second_name character varying(20),
    district character varying(20),
    discount integer,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.buyers
    OWNER to postgres;