CREATE TABLE transport
(
    transport_id smallint,
    transport_type character varying(21) NOT NULL,
    transport_vin character varying(45) NOT NULL,
    transport_number character varying(15),
    in_repair integer NOT NULL,
    CONSTRAINT transport_pkey PRIMARY KEY (transport_id)
)

CREATE TABLE route
(
    route_id smallint NOT NULL,
    route_number character varying(5) NOT NULL,
    route_transporttype character varying(18) NOT NULL,
    route_distance integer NOT NULL,
    route_stationnum integer NOT NULL,
    transport_id smallint,
    CONSTRAINT route_pkey PRIMARY KEY (route_id),
    CONSTRAINT fk_transport_route FOREIGN KEY (transport_id)
	REFERENCES transport (transport_id)
)