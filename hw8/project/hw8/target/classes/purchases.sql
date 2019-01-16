CREATE TABLE public.purchases
(
    id integer NOT NULL,
    date date,
    shop_id integer,
    buyer_id integer,
    book_id integer,
    qty integer,
    sum double precision,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.purchases
    OWNER to postgres;

-- Filling the table

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (401, '2018-12-13', 302, 103, 205, 23, 57500);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (402, '2018-10-03', 304, 101, 206, 10, 14000);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (403, '2018-09-05', 301, 106, 201, 5, 6000);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (404, '2018-01-16', 302, 102, 202, 15, 30000);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (405, '2018-05-02', 302, 104, 202, 4, 8000);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (406, '2018-02-13', 303, 103, 207, 18, 10800);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (407, '2018-02-17', 302, 102, 208, 6, 13800);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (408, '2018-12-19', 302, 102, 201, 5, 6000);

INSERT INTO public.purchases(
	id, date, shop_id, buyer_id, book_id, qty, sum)
	VALUES (409, '2018-06-19', 301, 104, 211, 16, 3200);
