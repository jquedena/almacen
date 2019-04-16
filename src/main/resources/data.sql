INSERT INTO ALM_USUARIO(USU_LOGIN, USU_CLAVE, USU_NOMBRE, USU_ESTADO, USU_FEREG) VALUES('admin', 'admin', 'Administrador', 'A', sysdate );
INSERT INTO ALM_USUARIO(USU_LOGIN, USU_CLAVE, USU_NOMBRE, USU_ESTADO, USU_FEREG) VALUES('user', 'user', 'Usuario', 'A', sysdate );

INSERT INTO ALM_UNIDADES VALUES('m', 'Metro', 'A');
INSERT INTO ALM_UNIDADES VALUES('cm', 'Centimetro', 'A');
INSERT INTO ALM_UNIDADES VALUES('kg', 'Kilogramo', 'A');
INSERT INTO ALM_UNIDADES VALUES('g', 'Gramo', 'A');


INSERT INTO ALM_MARCA VALUES('1', 'Marca 1', 'A');
INSERT INTO ALM_MARCA VALUES('2', 'Marca 2', 'A');
INSERT INTO ALM_MARCA VALUES('3', 'Marca 3', 'A');
INSERT INTO ALM_MARCA VALUES('4', 'Marca 4', 'A');


INSERT INTO ALM_PROVEEDOR(PRV_CODIGO, PRV_NOMBRE, PRV_DIRECCION, PRV_RUC, PRV_CONTACTO, PRV_TELEFONO) VALUES('1', 'Proveedor 1', 'Av Sin Numero', '20123456789', 'Contacto 1', '5432198');
INSERT INTO ALM_PROVEEDOR(PRV_CODIGO, PRV_NOMBRE, PRV_DIRECCION, PRV_RUC, PRV_CONTACTO, PRV_TELEFONO) VALUES('2', 'Proveedor 2', 'Av Sin Numero', '20123456799', 'Contacto 2', '6432198');
INSERT INTO ALM_PROVEEDOR(PRV_CODIGO, PRV_NOMBRE, PRV_DIRECCION, PRV_RUC, PRV_CONTACTO, PRV_TELEFONO) VALUES('3', 'Proveedor 3', 'Av Sin Numero', '20123456729', 'Contacto 3', '7432198');
INSERT INTO ALM_PROVEEDOR(PRV_CODIGO, PRV_NOMBRE, PRV_DIRECCION, PRV_RUC, PRV_CONTACTO, PRV_TELEFONO) VALUES('4', 'Proveedor 4', 'Av Sin Numero', '20123456749', 'Contacto 4', '8432198');