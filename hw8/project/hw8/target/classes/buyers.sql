CREATE TABLE public.books
(
    id integer NOT NULL,
    title character varying(30) COLLATE pg_catalog."default",
    price double precision,
    storage character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT books_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.books
    OWNER to postgres;

-- Filling the table

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (101, 'Petrov', 'Moskovsky', 15);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (102, 'Ivanov', 'Leninsky', 20);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (103, 'Orlova', 'Sormovsky', 50);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (104, 'Vasyn', 'Leninsky', 5);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (105, 'Komarova', 'Kanavinsky', 10);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (106, 'Kuvaev', 'Prioksky', 75);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (107, 'Nazarov', 'Avtozavodsky', 40);

INSERT INTO public.buyers(
	id, surname, district, discount)
	VALUES (108, 'Dolgova', 'Prioksky', 25);