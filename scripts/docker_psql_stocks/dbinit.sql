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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: administration; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.administration (
    id_admin integer NOT NULL,
    username character varying(255),
    passwd character varying(255)
);


ALTER TABLE public.administration OWNER TO pguser;

--
-- Name: administration_id_admin_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.administration_id_admin_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.administration_id_admin_seq OWNER TO pguser;

--
-- Name: administration_id_admin_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.administration_id_admin_seq OWNED BY public.administration.id_admin;


--
-- Name: company; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.company (
    id_company integer NOT NULL,
    description character varying(200),
    area character varying(200),
    share_quant integer,
    share_price double precision
);


ALTER TABLE public.company OWNER TO pguser;

--
-- Name: company_id_company_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.company_id_company_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.company_id_company_seq OWNER TO pguser;

--
-- Name: company_id_company_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.company_id_company_seq OWNED BY public.company.id_company;


--
-- Name: messages; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.messages (
    id_message integer NOT NULL,
    id_to integer,
    id_from integer,
    msg_text character varying(1024),
    created_at date,
    isviewed boolean
);


ALTER TABLE public.messages OWNER TO pguser;

--
-- Name: messages_id_message_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.messages_id_message_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.messages_id_message_seq OWNER TO pguser;

--
-- Name: messages_id_message_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.messages_id_message_seq OWNED BY public.messages.id_message;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.orders (
    id_order integer NOT NULL,
    id_user integer
);


ALTER TABLE public.orders OWNER TO pguser;

--
-- Name: parcel; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.parcel (
    id_parcel integer NOT NULL,
    id_order integer,
    id_company integer,
    share_quant integer,
    price double precision
);


ALTER TABLE public.parcel OWNER TO pguser;

--
-- Name: portfolio; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.portfolio (
    id_portfolio integer NOT NULL,
    id_user integer,
    id_company integer,
    share_quant integer
);


ALTER TABLE public.portfolio OWNER TO pguser;

--
-- Name: portfolio_id_portfolio_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.portfolio_id_portfolio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.portfolio_id_portfolio_seq OWNER TO pguser;

--
-- Name: portfolio_id_portfolio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.portfolio_id_portfolio_seq OWNED BY public.portfolio.id_portfolio;


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
-- Name: sequence_administration; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_administration
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_administration OWNER TO pguser;

--
-- Name: sequence_company; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_company
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_company OWNER TO pguser;

--
-- Name: sequence_messages; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_messages
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_messages OWNER TO pguser;

--
-- Name: sequence_orders; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_orders
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_orders OWNER TO pguser;

--
-- Name: sequence_parcel; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_parcel
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_parcel OWNER TO pguser;

--
-- Name: sequence_portofolio; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_portofolio
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_portofolio OWNER TO pguser;

--
-- Name: sequence_users; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.sequence_users
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_users OWNER TO pguser;

--
-- Name: users; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.users (
    id_user integer NOT NULL,
    username character varying(200),
    passwd character varying(200)
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
-- Name: administration id_admin; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.administration ALTER COLUMN id_admin SET DEFAULT nextval('public.administration_id_admin_seq'::regclass);


--
-- Name: company id_company; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.company ALTER COLUMN id_company SET DEFAULT nextval('public.company_id_company_seq'::regclass);


--
-- Name: messages id_message; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.messages ALTER COLUMN id_message SET DEFAULT nextval('public.messages_id_message_seq'::regclass);


--
-- Name: portfolio id_portfolio; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.portfolio ALTER COLUMN id_portfolio SET DEFAULT nextval('public.portfolio_id_portfolio_seq'::regclass);


--
-- Name: users id_user; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users ALTER COLUMN id_user SET DEFAULT nextval('public.users_id_user_seq'::regclass);


--
-- Data for Name: administration; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.administration (id_admin, username, passwd) FROM stdin;
\.


--
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.company (id_company, description, area, share_quant, share_price) FROM stdin;
\.


--
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.messages (id_message, id_to, id_from, msg_text, created_at, isviewed) FROM stdin;
\.


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.orders (id_order, id_user) FROM stdin;
\.


--
-- Data for Name: parcel; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.parcel (id_parcel, id_order, id_company, share_quant, price) FROM stdin;
\.


--
-- Data for Name: portfolio; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.portfolio (id_portfolio, id_user, id_company, share_quant) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.users (id_user, username, passwd) FROM stdin;
\.


--
-- Name: administration_id_admin_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.administration_id_admin_seq', 1, false);


--
-- Name: company_id_company_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.company_id_company_seq', 1, false);


--
-- Name: messages_id_message_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.messages_id_message_seq', 1, false);


--
-- Name: portfolio_id_portfolio_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.portfolio_id_portfolio_seq', 1, false);


--
-- Name: sequence_admin; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_admin', 1, false);


--
-- Name: sequence_administration; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_administration', 1, false);


--
-- Name: sequence_company; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_company', 1, false);


--
-- Name: sequence_messages; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_messages', 1, false);


--
-- Name: sequence_orders; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_orders', 1, false);


--
-- Name: sequence_parcel; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_parcel', 1, false);


--
-- Name: sequence_portofolio; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_portofolio', 1, false);


--
-- Name: sequence_users; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.sequence_users', 1, false);


--
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.users_id_user_seq', 1, false);


--
-- Name: administration pk_administration; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.administration
    ADD CONSTRAINT pk_administration PRIMARY KEY (id_admin);


--
-- Name: company pk_company; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT pk_company PRIMARY KEY (id_company);


--
-- Name: messages pk_messages; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT pk_messages PRIMARY KEY (id_message);


--
-- Name: orders pk_orders; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT pk_orders PRIMARY KEY (id_order);


--
-- Name: parcel pk_parcel; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT pk_parcel PRIMARY KEY (id_parcel);


--
-- Name: portfolio pk_portfolio; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.portfolio
    ADD CONSTRAINT pk_portfolio PRIMARY KEY (id_portfolio);


--
-- Name: users pk_users; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT pk_users PRIMARY KEY (id_user);


--
-- Name: messages fk_messages_reference_users; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk_messages_reference_users FOREIGN KEY (id_to) REFERENCES public.users(id_user) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: messages fk_messages_reference_users2; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk_messages_reference_users2 FOREIGN KEY (id_from) REFERENCES public.users(id_user) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: orders fk_orders_reference_users; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk_orders_reference_users FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: parcel fk_parcel_reference_company; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT fk_parcel_reference_company FOREIGN KEY (id_company) REFERENCES public.company(id_company) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: parcel fk_parcel_reference_orders; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.parcel
    ADD CONSTRAINT fk_parcel_reference_orders FOREIGN KEY (id_order) REFERENCES public.orders(id_order) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: portfolio fk_portfoli_reference_company; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.portfolio
    ADD CONSTRAINT fk_portfoli_reference_company FOREIGN KEY (id_company) REFERENCES public.company(id_company) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: portfolio fk_portfoli_reference_users; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.portfolio
    ADD CONSTRAINT fk_portfoli_reference_users FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

