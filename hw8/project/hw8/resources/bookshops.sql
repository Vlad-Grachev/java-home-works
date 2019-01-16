CREATE TABLE public.bookshops
(
    id integer NOT NULL,
    name character varying(20) COLLATE pg_catalog."default",
    district character varying(20) COLLATE pg_catalog."default",
    commission integer,
    CONSTRAINT bookshops_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.bookshops
    OWNER to postgres;

-- Filling the table

INSERT INTO public.bookshops(
	id, name, district, commission)
	VALUES (301, 'CheapBooks', 'Prioksky', 38);

INSERT INTO public.bookshops(
	id, name, district, commission)
	VALUES (302, 'LuxuryBooks', 'Leninsky', 20);

INSERT INTO public.bookshops(
	id, name, district, commission)
	VALUES (303, 'Book4u', 'Moskovsky', 25);

INSERT INTO public.bookshops(
	id, name, district, commission)
	VALUES (304, 'NewestBooks', 'Sormovsky', 36);