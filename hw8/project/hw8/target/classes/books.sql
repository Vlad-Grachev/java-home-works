CREATE TABLE public.books
(
    id integer NOT NULL,
    title character varying(30),
    price double precision,
    storage character varying(20),
    qty integer,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.books
    OWNER to postgres;

ALTER TABLE public.books
    OWNER to postgres;

-- Filling the table

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (201, 'The Cather in the Rye', 1200.00, 'Moskovsky', 10);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (202, 'A Wild Sheep Chase', 2000.00, 'Leninsky', 8);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (203, 'Fahrenheit 451', 800.00, 'Prioksky', 17);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (204, 'To Kill a Mockingbird', 1900.00, 'Leninsky', 3);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (205, 'The Help', 2500.00, 'Prioksky', 4);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (206, 'Misery', 1400.00, 'Moskovsky', 7);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (207, 'Animal Farm', 600.00, 'Moskovsky', 20);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (208, 'Dandelion Wine', 2500.00, 'Moskovsky', 16);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (209, 'The Help', 2500.00, 'Moskovsky', 7);

INSERT INTO public.books(
	id, title, price, storage, qty)
	VALUES (210, 'Animal Farm', 800.00, 'Prioksky', 12);