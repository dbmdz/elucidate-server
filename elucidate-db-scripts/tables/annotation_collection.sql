-- Table: public.annotation_collection

-- DROP TABLE public.annotation_collection;

CREATE TABLE public.annotation_collection
(
  collectionid character varying(100) NOT NULL,
  json jsonb NOT NULL,
  deleted boolean NOT NULL DEFAULT false,
  createddatetime timestamp without time zone NOT NULL,
  modifieddatetime timestamp without time zone,
  cachekey character(32) NOT NULL,
  id integer NOT NULL DEFAULT nextval('annotation_collection_id_seq'::regclass),
  CONSTRAINT pk_annotation_collection PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.annotation_collection
  OWNER TO postgres;
GRANT ALL ON TABLE public.annotation_collection TO postgres;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE public.annotation_collection TO annotations_role;
