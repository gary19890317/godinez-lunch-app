/*
Created: 06/01/2016
Modified: 07/01/2016
Model: Oracle 11g Release 1
Database: Oracle 11g Release 1
*/

--DROP TABLES
DROP TABLE COMENTARIO;
DROP TABLE SUSCRIPCION;
DROP TABLE PEDIDO_COMIDA;
DROP TABLE PEDIDO;
DROP TABLE MESERO;
DROP TABLE FONDA_CATEGORIA;
DROP TABLE CATEGORIA;
DROP TABLE FONDA_COMIDA;
DROP TABLE COMIDA;
DROP TABLE HORARIO_APERTURA;
DROP TABLE DIA_SEMANA;
DROP TABLE FONDA;

-- Create tables section -------------------------------------------------

-- Sequence for ID_FONDA
DROP SEQUENCE SEQ_ID_FONDA;

CREATE SEQUENCE SEQ_ID_FONDA INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;

-- Sequence for ID_FONDA
DROP SEQUENCE SEQ_ID_DIA;

CREATE SEQUENCE SEQ_ID_DIA INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;

-- Sequence for ID_HORARIO
DROP SEQUENCE SEQ_ID_HORARIO

CREATE SEQUENCE SEQ_ID_HORARIO INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;

-- Sequence for ID_COMENTARIO
DROP SEQUENCE SEQ_ID_COMENTARIO

CREATE SEQUENCE SEQ_ID_COMENTARIO INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;


-- Sequence for ID_CATEGORIA
DROP SEQUENCE SEQ_ID_CATEGORIA

CREATE SEQUENCE SEQ_ID_CATEGORIA INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;

-- Sequence for ID_USUARIO
DROP SEQUENCE SEQ_ID_USUARIO

CREATE SEQUENCE SEQ_ID_USUARIO INCREMENT BY 1 MAXVALUE 9999999999999990000000000000 MINVALUE 1 CACHE 20;

-- Table FONDA
CREATE TABLE "CATEGORIA"(
  "ID_CATEGORIA" NUMBER(19) NOT NULL,
  "DESCRIPCION" VARCHAR(100) NOT NULL,
  PRIMARY KEY("ID_CATEGORIA")
);

-- Table FONDA
CREATE TABLE "FONDA"(
  "ID_FONDA" NUMBER(19) NOT NULL,
  "NOMBRE" VARCHAR(30) NOT NULL,
  "LATITUD" VARCHAR(100) NOT NULL,
  "LONGITUD" VARCHAR(100) NOT NULL,
  "DIRECCION" VARCHAR(100) NOT NULL,
  "TELEFONO" VARCHAR(30),
  "HABILITADO" NUMBER(1) NOT NULL,
  PRIMARY KEY("ID_FONDA")
);

-- Table DIA_SEMANA
CREATE TABLE "DIA_SEMANA"(
  "ID_DIA" NUMBER(19) NOT NULL,
  "DESCRIPCION" VARCHAR(100) NOT NULL,
  PRIMARY KEY("ID_DIA")
);

-- Table HORARIO
CREATE TABLE "HORARIO_SERVICIO"(
  "ID_HORARIO" NUMBER(19) NOT NULL,
  "ID_FONDA" NUMBER(19) NOT NULL,
  "ID_DIA" NUMBER(19) NOT NULL,
  "HORARIO_APERTURA" VARCHAR(6) NOT NULL,
  "HORARIO_CIERRE" VARCHAR(6) NOT NULL,
  PRIMARY KEY("ID_HORARIO"),
  CONSTRAINT FK_ID_FONDA_HA
    FOREIGN KEY ("ID_FONDA")
    REFERENCES FONDA ("ID_FONDA"),
  CONSTRAINT FK_ID_DIA_HA
    FOREIGN KEY ("ID_DIA")
    REFERENCES DIA_SEMANA ("ID_DIA")
);

-- Table SUSCRIPCION
CREATE TABLE "SUSCRIPCION"(
  "ID_FONDA" NUMBER(19) NOT NULL,
  "FECHA_PAGO" TIMESTAMP(6) NOT NULL,
  "FECHA_TERMINO" TIMESTAMP(6) NOT NULL,
  "AL_CORRIENTE" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_FONDA"),
  CONSTRAINT FK_ID_FONDA_SUSCR
    FOREIGN KEY ("ID_FONDA")
    REFERENCES FONDA ("ID_FONDA")
);

-- Table COMIDA
CREATE TABLE "COMIDA"(
  "ID_COMIDA" NUMBER(19) NOT NULL,
  "DESCRIPCION" VARCHAR(50) NOT NULL,
  "PRECIO" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_COMIDA")
);

-- Table FONDA_COMIDA
CREATE TABLE "FONDA_COMIDA"(
  "ID_FONDA" NUMBER(19) NOT NULL,
  "ID_COMIDA" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_FONDA", "ID_COMIDA"),
  CONSTRAINT FK_ID_FONDA_FC
    FOREIGN KEY ("ID_FONDA")
    REFERENCES FONDA ("ID_FONDA"),
  CONSTRAINT FK_ID_COMIDA_FC
    FOREIGN KEY ("ID_COMIDA")
    REFERENCES COMIDA ("ID_COMIDA")  
);

-- Table MESERO
CREATE TABLE "MESERO"(
  "ID_MESERO" NUMBER(19) NOT NULL,
  "NOMBRE" VARCHAR(30) NOT NULL,
  "NOMBRE_CORTO" VARCHAR(30) NOT NULL,
  PRIMARY KEY("ID_MESERO")
);

-- Table PEDIDO
CREATE TABLE "PEDIDO"(
  "ID_PEDIDO" NUMBER(19) NOT NULL,
  "MESA" NUMBER(19) NOT NULL,
  "FECHA" TIMESTAMP(6) NOT NULL,
  "PROPINA" NUMBER(19),
  "TOTAL_PAGAR" NUMBER(19) NOT NULL,
  "ID_MESERO" NUMBER(19),
  PRIMARY KEY("ID_PEDIDO"),
  CONSTRAINT FK_ID_MESERO
    FOREIGN KEY ("ID_MESERO")
    REFERENCES MESERO ("ID_MESERO")  
);

-- Table PEDIDO_COMIDA
CREATE TABLE "PEDIDO_COMIDA"(
  "ID_PEDIDO" NUMBER(19) NOT NULL,
  "ID_COMIDA" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_PEDIDO", "ID_COMIDA"),
  CONSTRAINT FK_ID_PEDIDO_PC
    FOREIGN KEY ("ID_PEDIDO")
    REFERENCES PEDIDO ("ID_PEDIDO"),
  CONSTRAINT FK_ID_COMIDA_PC
    FOREIGN KEY ("ID_COMIDA")
    REFERENCES COMIDA ("ID_COMIDA")
);

-- Table COMENTARIO
CREATE TABLE "COMENTARIO"(
  "ID_COMENTARIO" NUMBER(19) NOT NULL,
  "ID_FONDA" NUMBER(19) NOT NULL,
  "CALIFICACION" NUMBER(19) NOT NULL,
  "COMENTARIO" VARCHAR(100) NOT NULL,
  "FECHA" TIMESTAMP(6) NOT NULL,
  PRIMARY KEY("ID_COMENTARIO")
);

-- Table FONDA_CATEGORIA
CREATE TABLE "FONDA_CATEGORIA"(
  "ID_FONDA" NUMBER(19) NOT NULL,
  "ID_CATEGORIA" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_FONDA", "ID_CATEGORIA"),
  CONSTRAINT FK_ID_FONDA_FC
    FOREIGN KEY ("ID_FONDA")
    REFERENCES FONDA ("ID_FONDA"),
  CONSTRAINT FK_ID_CATEGORIA_FC
    FOREIGN KEY ("ID_CATEGORIA")
    REFERENCES CATEGORIA ("ID_CATEGORIA")
);

-- Table USUARIO
CREATE TABLE "USUARIO"(
  "ID_USUARIO" NUMBER(19) NOT NULL,
  "NOMBRE" VARCHAR(30) NOT NULL,
  "USUARIO" VARCHAR(30) NOT NULL,
  "CONTRASENA" VARCHAR(30) NOT NULL,
  PRIMARY KEY("ID_USUARIO")
);

-- Table FONDA_FAVORITO
CREATE TABLE "FONDA_FAVORITO"(
  "ID_FONDA" NUMBER(19) NOT NULL,
  "ID_USUARIO" NUMBER(19) NOT NULL,
  PRIMARY KEY("ID_FONDA", "ID_USUARIO"),
  CONSTRAINT FK_ID_FONDA_FF
    FOREIGN KEY ("ID_FONDA")
    REFERENCES FONDA ("ID_FONDA"),
  CONSTRAINT FK_ID_USUARIO_FF
    FOREIGN KEY ("ID_USUARIO")
    REFERENCES USUARIO ("ID_USUARIO")
);


