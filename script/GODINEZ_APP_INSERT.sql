INSERT INTO FONDA(ID_FONDA, NOMBRE, LATITUD, LONGITUD, DIRECCION, TELEFONO, HABILITADO) 
VALUES(SEQ_ID_FONDA.NEXTVAL, 'Yenee Guendaroo', '19.4047527', '-99.1534128', 'Nicaragua 50, Colonia Buenos Aires Cuathemoc', 
'5527119309', 1);

INSERT INTO FONDA(ID_FONDA, NOMBRE, LATITUD, LONGITUD, DIRECCION, TELEFONO, HABILITADO) 
VALUES(SEQ_ID_FONDA.NEXTVAL, 'El buen Saz�n', '19.4047944', '-99.1471684', 'I Barajas Lozano, Colonia Buenos Aires Cuathemoc', 
'5527119309', 1);

INSERT INTO FONDA(ID_FONDA, NOMBRE, LATITUD, LONGITUD, DIRECCION, TELEFONO, HABILITADO) 
VALUES(SEQ_ID_FONDA.NEXTVAL, 'Tiendita de Barrio', '19.4102591', '-99.1490451', '357 Dr Jos� Mar�a Vertiz', 
'5527119309', 1);

SELECT * FROM FONDA;

----------------------------------------------------------------------------------------------------------------

INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'LUNES');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'MARTES');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'MIERCOLES');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'JUEVES');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'VIERNES');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'SABADO');
INSERT INTO DIA_SEMANA(ID_DIA, DESCRIPCION) VALUES(SEQ_ID_DIA.NEXTVAL, 'DOMINGO');

SELECT * FROM DIA_SEMANA;

----------------------------------------------------------------------------------------------------------------

INSERT INTO SUSCRIPCION(ID_FONDA, FECHA_PAGO, FECHA_TERMINO, AL_CORRIENTE) VALUES(1, '12-FEB-16', '12-FEB-17', 1);

SELECT * FROM SUSCRIPCION;

----------------------------------------------------------------------------------------------------------------

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 1, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 2, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 3, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 4, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 5, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 6, '09:00', '16:00');

INSERT INTO HORARIO_APERTURA(ID_HORARIO, ID_FONDA, ID_DIA, HORARIO_APERTURA, HORARIO_CIERRE) 
VALUES(SEQ_ID_HORARIO.NEXTVAL, 1, 6, '18:00', '23:00');

SELECT * FROM HORARIO_APERTURA;

----------------------------------------------------------------------------------------------------------------

