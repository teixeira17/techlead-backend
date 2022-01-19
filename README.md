# techlead-backend
Analista Desenvolvedor Java Jr\n\n
Foi realizado o desafio na linguaguem Java, para o back-end, utilizando o framework Spring Boot. Foi escolhido a linguagem java pois é a que mais tenho identificação, com a ajuda do Spring Boot, aonde é facilitado o desenvolvimento do projeto Web.
DUMP do banco de dados POSTGRESS ABAIXO

PGDMP     :    $                  z            techlead    12.6    12.6     &           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            '           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            (           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            )           1262    24822    techlead    DATABASE        CREATE DATABASE techlead WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE techlead;
                postgres    false            Ë            1259    24981 	   tb_livros    TABLE     À   CREATE TABLE public.tb_livros (
    id bigint NOT NULL,
    data_cadastro timestamp without time zone,
    autor character varying(255),
    nome character varying(255),
    id_user bigint
);
    DROP TABLE public.tb_livros;
       public         heap    postgres    false            Ê            1259    24979    tb_livros_id_seq    SEQUENCE     y   CREATE SEQUENCE public.tb_livros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.tb_livros_id_seq;
       public          postgres    false    203            *           0    0    tb_livros_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.tb_livros_id_seq OWNED BY public.tb_livros.id;
          public          postgres    false    202            Í            1259    24992    tb_role    TABLE     ^   CREATE TABLE public.tb_role (
    id bigint NOT NULL,
    authority character varying(255)
);
    DROP TABLE public.tb_role;
       public         heap    postgres    false            Ì            1259    24990    tb_role_id_seq    SEQUENCE     w   CREATE SEQUENCE public.tb_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.tb_role_id_seq;
       public          postgres    false    205            +           0    0    tb_role_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.tb_role_id_seq OWNED BY public.tb_role.id;
          public          postgres    false    204            Ï            1259    25000    tb_user    TABLE         CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255)
);
    DROP TABLE public.tb_user;
       public         heap    postgres    false            Î            1259    24998    tb_user_id_seq    SEQUENCE     w   CREATE SEQUENCE public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.tb_user_id_seq;
       public          postgres    false    207            ,           0    0    tb_user_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;
          public          postgres    false    206            Ð            1259    25009    tb_user_role    TABLE     _   CREATE TABLE public.tb_user_role (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);
     DROP TABLE public.tb_user_role;
       public         heap    postgres    false            ‘
           2604    24984    tb_livros id    DEFAULT     l   ALTER TABLE ONLY public.tb_livros ALTER COLUMN id SET DEFAULT nextval('public.tb_livros_id_seq'::regclass);
 ;   ALTER TABLE public.tb_livros ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            ’
           2604    24995 
   tb_role id    DEFAULT     h   ALTER TABLE ONLY public.tb_role ALTER COLUMN id SET DEFAULT nextval('public.tb_role_id_seq'::regclass);
 9   ALTER TABLE public.tb_role ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            “
           2604    25003 
   tb_user id    DEFAULT     h   ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);
 9   ALTER TABLE public.tb_user ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207                      0    24981 	   tb_livros 
   TABLE DATA           L   COPY public.tb_livros (id, data_cadastro, autor, nome, id_user) FROM stdin;
    public          postgres    false    203   )!                  0    24992    tb_role 
   TABLE DATA           0   COPY public.tb_role (id, authority) FROM stdin;
    public          postgres    false    205   Á!       "          0    25000    tb_user 
   TABLE DATA           <   COPY public.tb_user (id, email, name, password) FROM stdin;
    public          postgres    false    207   "       #          0    25009    tb_user_role 
   TABLE DATA           8   COPY public.tb_user_role (user_id, role_id) FROM stdin;
    public          postgres    false    208   ð&       -           0    0    tb_livros_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.tb_livros_id_seq', 31, true);
          public          postgres    false    202            .           0    0    tb_role_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tb_role_id_seq', 4, true);
          public          postgres    false    204            /           0    0    tb_user_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.tb_user_id_seq', 41, true);
          public          postgres    false    206            •
           2606    24989    tb_livros tb_livros_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT tb_livros_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.tb_livros DROP CONSTRAINT tb_livros_pkey;
       public            postgres    false    203            —
           2606    24997    tb_role tb_role_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tb_role
    ADD CONSTRAINT tb_role_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tb_role DROP CONSTRAINT tb_role_pkey;
       public            postgres    false    205            ™
           2606    25008    tb_user tb_user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tb_user DROP CONSTRAINT tb_user_pkey;
       public            postgres    false    207            ›
           2606    25013    tb_user_role tb_user_role_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT tb_user_role_pkey PRIMARY KEY (user_id, role_id);
 H   ALTER TABLE ONLY public.tb_user_role DROP CONSTRAINT tb_user_role_pkey;
       public            postgres    false    208    208            œ
           2606    25014 %   tb_livros fk44mreky8dmjw09bb9msyfvu8r 
   FK CONSTRAINT     †   ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT fk44mreky8dmjw09bb9msyfvu8r FOREIGN KEY (id_user) REFERENCES public.tb_user(id);
 O   ALTER TABLE ONLY public.tb_livros DROP CONSTRAINT fk44mreky8dmjw09bb9msyfvu8r;
       public          postgres    false    203    207    2713            ž
           2606    25024 (   tb_user_role fk7vn3h53d0tqdimm8cp45gc0kl 
   FK CONSTRAINT     ‰   ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT fk7vn3h53d0tqdimm8cp45gc0kl FOREIGN KEY (user_id) REFERENCES public.tb_user(id);
 R   ALTER TABLE ONLY public.tb_user_role DROP CONSTRAINT fk7vn3h53d0tqdimm8cp45gc0kl;
       public          postgres    false    208    2713    207            
           2606    25019 (   tb_user_role fkea2ootw6b6bb0xt3ptl28bymv 
   FK CONSTRAINT     ‰   ALTER TABLE ONLY public.tb_user_role
    ADD CONSTRAINT fkea2ootw6b6bb0xt3ptl28bymv FOREIGN KEY (role_id) REFERENCES public.tb_role(id);
 R   ALTER TABLE ONLY public.tb_user_role DROP CONSTRAINT fkea2ootw6b6bb0xt3ptl28bymv;
       public          postgres    false    2711    208    205               ˆ   xœ3´à4202Ò50Ô54Q00°#N/o… üòœÌ¼tN…àÔ¼Œü"…”üb…ÌªÄ¤ÔNC.C„>#„¾Ò‚”Ä’T…¤ü|#S#Ó$Ä-*­LÌKLâ4â2¥D³¡%V'—¤—¤BIC.#BŠŠA¤Ô”RCC#C Â=... ÌMÒ          3   xœ3äò÷qwöñtõqå2‚p]|=ý<ƒC‚]üƒ¸ŒQÕ˜`S£ÇÅÅ j­      "   Ü  xœ¥ÕÉÒ›F à³xŠ|Fb !Ý,v„X„Ø+—a_…ØOý¶ÿŠË¹¤Š¢˜>|ÝÓÓ5`› 	¾¦5Ì+4lê
Ý›/ ~Áv_âÃxª‰\ëNñJŽyPG\/×¡¡¶œP3,oM”+Ø´”ù‡A@ÀÞáOàéÿHlòqõ“)}|²k{/>¶û*I<4-«òtÖrÈØÙvž5ödŒkNZ-G›¤T¸9Bþ`±ßºwÓ—Ëª\Æ²âc'Q—YŠicŠZiÅë}]-b:³Ußùœ$R¶VšŒì¸à·nôÒ'ôS·CC"ÛÄÀi-¸'©¹Ývjò¸lcÉÕ-qÀ…G}>DG¡>Ýßb)èâãq`À°ÌÃ–}ˆÞ§·åq’î¶6¸Z†ŸËÐÝ™]^æëq? vÜô°ïaôz`ÿþŠÂþÓféþxtÈ4¾ã¡X¦VmÚF›©@eSf[ëR ßxI°é®«‘íÒ×0ì6¿Ÿ¢%ß©[ß9i$Ú¥VswŠ£Ñ\8Š¸¹Ä¥o‡Æ‘Õz]®ÓÅ¡E ¶‰>êì£¯›(ú(úÓ0 HžÆ¤Â+;Î‚sfP-Ü×$Ñ¡J’½ÅÝÍÕ¡çÂç%	*K‰ 6]SÅ_?^›!î‡øoŸŸÛ^ÊÇ8×ât”•8S(ã©qrTfPoŸÓ³(ûˆ…fØÅŸ}"öÜ=ðÍØÇÝ7ôÛ¾?Vÿp‹;AM‚(“Šð\%OVa¢5=S`;>¡hö‰"²¢X^\¬i½2±™‹† âŸ.ö+|£A¶”jìæÆîã™Ríƒ¡Ñóê¥ÿ”ÛÜÈM—zj·ÚLÛN%Ž†¯.ÿ‚ßÈÖ\é½îeÎæ)ŒV6y£¢9‹Ùgg­ÊÊï"ßi%­ç^­Øÿ[~C—ÞŽuÔ6÷ 5…Ýhkô='âB#®SF 2‘×à®v¤ì3gO±ÂW@F õýÆ–UÎÌf@€—‰å³þ½öm‚Mp9b|3•ÛPÄÝ½€ù¡¸ÜrãÙ™5¿ÚopÈ§ý-6+¯9•Òâ &u½Jg»}ìÆÛq·œîx¥ÐÂf8Ÿq†¡8¾Áßè,=“¦âÛ|ÊŠNVäG¿×"
‹wÌEÇëJ<Òzö<}?÷­L}òJ1‚ïÞéïŠo’a=Æ˜dN”ä¬MUœ½‚œ™%¨ÜFŽ¼
ZG?Û
{°˜5ß{Ë¿ñE(È'ñ¤úÖ¬\P˜]Fi|.tÔ±µ¬MS%Æ¯˜ôªú¹ñF€àoNû}’Ñ×W'B¹T»ò–‚AVSqT_ˆrÌ(ÆpœC@<”« ¥}Šp^IÞïdYíI³÷ír”r
ÖŠª®œ«PÎÉ‹Á<µÜŠ‹Î/U‰vÂrì’›e?n6Ÿ‚¶×]2EÓrKw#Í4ŒSëÅ³SóQ³ß­)’SX¢+ã¥‹¯¿šMì6E›¦Ê§8ï~þ­ž_á?´ñÏ$R¢â£å;ŒÏšbŠV•ïâèn2ÅÉÂò º®}ö¨¼­ÙÝ¤<¾¢1B`ß/¾W7ˆþâûm}\ˆü{&sÊ½—É¦ï-Ÿ8  A¥»;§Àº=Og§±¨ò[TˆKáq*@þDùvŠ­Ð      #   6   xœ3ä4ä2â4â2bS ÛH›ƒÄÌ@„%06  1c3‰™‰=... 2fÝ     

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
