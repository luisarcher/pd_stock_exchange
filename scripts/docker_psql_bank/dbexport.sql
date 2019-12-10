--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1 (Debian 12.1-1.pgdg100+1)
-- Dumped by pg_dump version 12.1 (Debian 12.1-1.pgdg100+1)

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

--
-- Name: sequence_account; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_account
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_account OWNER TO pguser;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.account (
    id_account integer DEFAULT nextval('public.sequence_account'::regclass) NOT NULL,
    id_user integer,
    balance double precision,
    id_status integer,
    created_at date
);


ALTER TABLE public.account OWNER TO pguser;

--
-- Name: account_id_account_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.account_id_account_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_account_seq OWNER TO pguser;

--
-- Name: account_id_account_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.account_id_account_seq OWNED BY public.account.id_account;


--
-- Name: sequence_admin; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_admin
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_admin OWNER TO pguser;

--
-- Name: administration; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.administration (
    id_admin integer DEFAULT nextval('public.sequence_admin'::regclass) NOT NULL,
    username character varying(255),
    passwd character varying(255)
);


ALTER TABLE public.administration OWNER TO pguser;

--
-- Name: sequence_movement; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_movement
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_movement OWNER TO pguser;

--
-- Name: movements; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.movements (
    id_movement integer DEFAULT nextval('public.sequence_movement'::regclass) NOT NULL,
    id_account integer,
    description character varying(255),
    val double precision,
    final_balance double precision,
    created_at date
);


ALTER TABLE public.movements OWNER TO pguser;

--
-- Name: movements_id_movement_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.movements_id_movement_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movements_id_movement_seq OWNER TO pguser;

--
-- Name: movements_id_movement_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.movements_id_movement_seq OWNED BY public.movements.id_movement;


--
-- Name: sequence_status; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_status
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_status OWNER TO pguser;

--
-- Name: sequence_user; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_user OWNER TO pguser;

--
-- Name: users; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.users (
    id_user integer DEFAULT nextval('public.sequence_user'::regclass) NOT NULL,
    username character varying(128) NOT NULL,
    passwd character varying(128) NOT NULL,
    name character varying(255) NOT NULL,
    nif character varying(9),
    created_at date
);


ALTER TABLE public.users OWNER TO pguser;

--
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.users_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_user_seq OWNER TO pguser;

--
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.users_id_user_seq OWNED BY public.users.id_user;


--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.account (id_account, id_user, balance, id_status, created_at) FROM stdin;
1000	1	540.97	1	\N
\.


--
-- Data for Name: administration; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.administration (id_admin, username, passwd) FROM stdin;
1	admin	admin
\.


--
-- Data for Name: movements; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.movements (id_movement, id_account, description, val, final_balance, created_at) FROM stdin;
1	1000	descricao movimento	50	450.97	\N
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.users (id_user, username, passwd, name, nif, created_at) FROM stdin;
1	ljordao	123	luis	122233454	\N
\.


--
-- Name: account_id_account_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.account_id_account_seq', 1, false);


--
-- Name: movements_id_movement_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.movements_id_movement_seq', 1, false);


--
-- Name: sequence_account; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_account', 1000, true);


--
-- Name: sequence_admin; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_admin', 1, true);


--
-- Name: sequence_movement; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_movement', 1, true);


--
-- Name: sequence_status; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_status', 1, false);


--
-- Name: sequence_user; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_user', 1, true);


--
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.users_id_user_seq', 1, false);


--
-- Name: account pk_account; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT pk_account PRIMARY KEY (id_account);


--
-- Name: administration pk_administration; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.administration
    ADD CONSTRAINT pk_administration PRIMARY KEY (id_admin);


--
-- Name: movements pk_movements; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.movements
    ADD CONSTRAINT pk_movements PRIMARY KEY (id_movement);


--
-- Name: users pk_users; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT pk_users PRIMARY KEY (id_user);


--
-- Name: account fk_account_reference_users; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk_account_reference_users FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: movements fk_movement_reference_account; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.movements
    ADD CONSTRAINT fk_movement_reference_account FOREIGN KEY (id_account) REFERENCES public.account(id_account) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

