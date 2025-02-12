-- DROP TABLE public.article;

CREATE TABLE public.article (
	id varchar(40) NOT NULL,
	nombre varchar(20) NOT NULL,
	descripcion varchar(200) NOT NULL,
	precio numeric(10,2) NOT NULL,
	modelo varchar(10) NOT NULL,
	CONSTRAINT article_pkey PRIMARY KEY (id)
);

INSERT INTO public.article
(id, nombre, descripcion, precio, modelo)
VALUES('1', 'PS5', 'Consola de Videojuegos de Sony', 200.55, 'NHVGBDCRS');

INSERT INTO public.article
(id, nombre, descripcion, precio, modelo)
VALUES('2', 'XBOX', 'Consola de Videojuegos de Microsoft', 210.49, 'NHVGRDGD');

INSERT INTO public.article
(id, nombre, descripcion, precio, modelo)
VALUES('3', 'Nintendo', 'Consola de Videojuegos de Nintendo', 215.84, 'NHVGFVCD');