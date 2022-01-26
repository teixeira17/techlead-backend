# techlead-backend
Analista Desenvolvedor Java Jr


Foi realizado o desafio na linguaguem Java, para o back-end, utilizando o framework Spring Boot. Foi escolhido a linguagem java pois é a que mais tenho identificação, com a ajuda do Spring Boot, aonde é facilitado o desenvolvimento do projeto Web.


DUMP do banco de dados POSTGRESS ABAIXO

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.6
-- Dumped by pg_dump version 12.6

-- Started on 2022-01-25 22:05:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 24981)
-- Name: tb_livros; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_livros (
    id bigint NOT NULL,
    data_cadastro timestamp without time zone,
    autor character varying(255),
    nome character varying(255),
    id_user bigint
);


ALTER TABLE public.tb_livros OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24979)
-- Name: tb_livros_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_livros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_livros_id_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_livros_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_livros_id_seq OWNED BY public.tb_livros.id;


--
-- TOC entry 205 (class 1259 OID 24992)
-- Name: tb_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_role (
    id bigint NOT NULL,
    authority character varying(255)
);


ALTER TABLE public.tb_role OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24990)
-- Name: tb_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_role_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 204
-- Name: tb_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_role_id_seq OWNED BY public.tb_role.id;


--
-- TOC entry 207 (class 1259 OID 25000)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255)
);


ALTER TABLE public.tb_user OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24998)
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_user_id_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 206
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- TOC entry 208 (class 1259 OID 25009)
-- Name: tb_user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.tb_user_role OWNER TO postgres;

--
-- TOC entry 2705 (class 2604 OID 24984)
-- Name: tb_livros id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_livros ALTER COLUMN id SET DEFAULT nextval('public.tb_livros_id_seq'::regclass);


--
-- TOC entry 2706 (class 2604 OID 24995)
-- Name: tb_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_role ALTER COLUMN id SET DEFAULT nextval('public.tb_role_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 25003)
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- TOC entry 2846 (class 0 OID 24981)
-- Dependencies: 203
-- Data for Name: tb_livros; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_livros (id, data_cadastro, autor, nome, id_user) FROM stdin;
\.


--
-- TOC entry 2848 (class 0 OID 24992)
-- Dependencies: 205
-- Data for Name: tb_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_role (id, authority) FROM stdin;
\.


--
-- TOC entry 2850 (class 0 OID 25000)
-- Dependencies: 207
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_user (id, email, name, password) FROM stdin;
\.


--
-- TOC entry 2851 (class 0 OID 25009)
-- Dependencies: 208
-- Data for Name: tb_user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_user_role (user_id, role_id) FROM stdin;
\.


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_livros_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_livros_id_seq', 31, true);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 204
-- Name: tb_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_role_id_seq', 4, true);


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 206
-- Name: tb_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_user_id_seq', 41, true);


--
-- TOC entry 2709 (class 2606 OID 24989)
-- Name: tb_livros tb_livros_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT tb_livros_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 24997)
-- Name: tb_role tb_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_role
    ADD CONSTRAINT tb_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2713 (class 2606 OID 25008)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


--
-- TOC entry 2715 (class 2606 OID 25013)
-- Name: tb_user_role tb_user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT tb_user_role_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 2716 (class 2606 OID 25014)
-- Name: tb_livros fk44mreky8dmjw09bb9msyfvu8r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT fk44mreky8dmjw09bb9msyfvu8r FOREIGN KEY (id_user) REFERENCES public.tb_user(id);


--
-- TOC entry 2718 (class 2606 OID 25024)
-- Name: tb_user_role fk7vn3h53d0tqdimm8cp45gc0kl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT fk7vn3h53d0tqdimm8cp45gc0kl FOREIGN KEY (user_id) REFERENCES public.tb_user(id);


--
-- TOC entry 2717 (class 2606 OID 25019)
-- Name: tb_user_role fkea2ootw6b6bb0xt3ptl28bymv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT fkea2ootw6b6bb0xt3ptl28bymv FOREIGN KEY (role_id) REFERENCES public.tb_role(id);


-- Completed on 2022-01-25 22:05:30

--
-- PostgreSQL database dump complete
--




*********************************************************************************************
Carga Inicial do banco de dados

INSERT INTO public.tb_role(
	id, authority)
	VALUES (1, 'ROLE_CLIENTE');
	
INSERT INTO public.tb_role(
	id, authority)
	VALUES (2, 'ROLE_ADMINISTRADOR');

INSERT INTO public.tb_user(
	id, email, name, password)
	VALUES (1, 'bob@gmail.com', 'Bob', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
	
INSERT INTO public.tb_user(
	id, email, name, password)
	VALUES (2, 'ana@gmail.com', 'Ana', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO public.tb_user_role(
	user_id, role_id)
	VALUES (1, 1);
	
INSERT INTO public.tb_user_role(
	user_id, role_id)
	VALUES (2, 2);

INSERT INTO public.tb_livros(
	id, data_cadastro, autor, nome, id_user)
	VALUES (1, null, 'JK Rowling', 'Harry Potter 1', 1);
	
INSERT INTO public.tb_livros(
	id, data_cadastro, autor, nome, id_user)
	VALUES (2, null, 'JK Rowling', 'Harry Potter 2', 2);
	
INSERT INTO public.tb_livros(
	id, data_cadastro, autor, nome, id_user)
	VALUES (3, null, 'JK Rowling', 'Harry Potter 3', 2);
