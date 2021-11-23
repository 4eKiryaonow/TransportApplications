PGDMP                     
    y         	   Transport    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    49153 	   Transport    DATABASE     h   CREATE DATABASE "Transport" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Transport";
                postgres    false            �            1259    49159    route    TABLE       CREATE TABLE public.route (
    route_id smallint NOT NULL,
    route_number character varying(5) NOT NULL,
    route_transporttype character varying(18) NOT NULL,
    route_distance integer NOT NULL,
    route_stationnum integer NOT NULL,
    transport_id smallint
);
    DROP TABLE public.route;
       public         heap    postgres    false            �            1259    49154 	   transport    TABLE     �   CREATE TABLE public.transport (
    transport_id smallint NOT NULL,
    transport_type character varying(21) NOT NULL,
    transport_vin character varying(45) NOT NULL,
    transport_number character varying(15),
    in_repair integer NOT NULL
);
    DROP TABLE public.transport;
       public         heap    postgres    false            �          0    49159    route 
   TABLE DATA           |   COPY public.route (route_id, route_number, route_transporttype, route_distance, route_stationnum, transport_id) FROM stdin;
    public          postgres    false    201   Y       �          0    49154 	   transport 
   TABLE DATA           m   COPY public.transport (transport_id, transport_type, transport_vin, transport_number, in_repair) FROM stdin;
    public          postgres    false    200   �       '           2606    49163    route route_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pkey PRIMARY KEY (route_id);
 :   ALTER TABLE ONLY public.route DROP CONSTRAINT route_pkey;
       public            postgres    false    201            %           2606    49158    transport transport_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY (transport_id);
 B   ALTER TABLE ONLY public.transport DROP CONSTRAINT transport_pkey;
       public            postgres    false    200            (           2606    49164    route fk_transport_route    FK CONSTRAINT     �   ALTER TABLE ONLY public.route
    ADD CONSTRAINT fk_transport_route FOREIGN KEY (transport_id) REFERENCES public.transport(transport_id);
 B   ALTER TABLE ONLY public.route DROP CONSTRAINT fk_transport_route;
       public          postgres    false    201    2853    200            �   z   x�M�;�@��z�0(�;Jj$N��H�!�(�=�.H)���� ��'T�!ҹ�&h@`���_*"��������i��������1 �~w��6���6��q���֞ܰ��(Ko�6�H~=e(�      �   �   x�u�A� E�p�T�.nj��@��X[oa<�g�
��jBB7����1T�ȓ�}x���4�L�8D��Q)A������KO)b�B�ɥ�4�Q�����
�����j��=T�_O8r�����ܢC_���$��ӹ�qg�I�6���8OE��%Gr�޻��"�gf�j_F����ٌoh     