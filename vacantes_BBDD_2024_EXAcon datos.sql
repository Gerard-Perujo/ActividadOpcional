create database vacantes_BBDD_2024_EXA;
use vacantes_BBDD_2024_EXA;

CREATE TABLE `Categorias` (
  id_categoria int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  descripcion varchar(2000),
  PRIMARY KEY (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS `Perfiles`;
CREATE TABLE `Perfiles` (
  id_perfil int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  PRIMARY KEY (id_perfil)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS `Usuarios`;
CREATE TABLE `Usuarios` (
  username varchar(45) NOT NULL PRIMARY KEY,
  nombre varchar(45) NOT NULL,
  apellidos varchar(100) not null,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  enabled int NOT NULL DEFAULT 1,
  fecha_Registro date,
  UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS `Vacantes`;
CREATE TABLE `Vacantes` (
  id_vacante int NOT NULL AUTO_INCREMENT,
  nombre varchar(200) NOT NULL,
  descripcion text NOT NULL,
  fecha date NOT NULL,
  salario double NOT NULL,
  estatus enum('CREADA','CUBIERTA','CANCELADA') NOT NULL,
  destacado tinyint NOT NULL,
  imagen varchar(250) NOT NULL,
  detalles text NOT NULL,
  id_Categoria int NOT NULL,
  PRIMARY KEY (id_vacante),
  FOREIGN KEY (id_categoria) REFERENCES `Categorias` (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS `Solicitudes`;
CREATE TABLE `Solicitudes` (
  id_solicitud int NOT NULL AUTO_INCREMENT,
  fecha date NOT NULL,
  archivo varchar(250) NOT NULL,
  comentarios varchar(2000),
  estado  tinyint NOT NULL default 0,
  -- 0 presentada, 1 adjudicada
  id_Vacante int NOT NULL,
  username varchar(45) NOT NULL,
  PRIMARY KEY (id_solicitud),
  UNIQUE(id_Vacante,username),
  FOREIGN KEY (username) REFERENCES `Usuarios` (username),
  FOREIGN KEY (id_Vacante) REFERENCES `Vacantes` (id_vacante)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- DROP TABLE IF EXISTS `UsuarioPerfil`;
CREATE TABLE `UsuarioPerfil` (
  username varchar(45) NOT NULL,
  id_Perfil int NOT NULL,
  PRIMARY KEY(username,id_Perfil),
 FOREIGN KEY (username) REFERENCES `Usuarios` (username),
  FOREIGN KEY (id_Perfil) REFERENCES `Perfiles` (id_perfil)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `usuarios` (`USERNAME`,`NOMBRE`,`APELLIDOS`,`EMAIL`,`PASSWORD`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('Amalia','Amalia','Sanchez', 'amalia@edix.es','{noop}amalia',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`NOMBRE`,`APELLIDOS`,`EMAIL`,`PASSWORD`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('Evita','Eva','Garcia', 'evaG@edix.es','{noop}evitaG',1,'2021-06-03');
INSERT INTO `usuarios` (`USERNAME`,`NOMBRE`,`APELLIDOS`,`EMAIL`,`PASSWORD`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('Geri','Gerard','Perujo', 'gerP@edix.es','{noop}geriP',1,'2021-06-04');
INSERT INTO `usuarios` (`USERNAME`,`NOMBRE`,`APELLIDOS`,`EMAIL`,`PASSWORD`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('Noeli','Noelia','Villahermosa', 'NoeV@edix.es','{noop}noeliV',1,'2021-06-05');
INSERT INTO `usuarios` (`USERNAME`,`NOMBRE`,`APELLIDOS`,`EMAIL`,`PASSWORD`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('Mari','Maria','Isabel', 'MarIs@edix.es','{noop}mariIs',1,'2021-06-06');

INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (1,'ROLE_ADMINISTRADOR');
INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (2,'ROLE_GESTOR');
INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (3,'ROLE_CLIENTE');


INSERT INTO `usuarioperfil` (`USERNAME`,`ID_PERFIL`) VALUES ('Amalia',3);
INSERT INTO `usuarioperfil` (`USERNAME`,`ID_PERFIL`) VALUES ('Evita',3);
INSERT INTO `usuarioperfil` (`USERNAME`,`ID_PERFIL`) VALUES ('Geri',1);
INSERT INTO `usuarioperfil` (`USERNAME`,`ID_PERFIL`) VALUES ('Noeli',2);
INSERT INTO `usuarioperfil` (`USERNAME`,`ID_PERFIL`) VALUES ('Mari',3);

INSERT INTO `categorias` (`ID_CATEGORIA`,`NOMBRE`, `DESCRIPCION`) VALUES (1,'MARKETING', 'PUESTO PARA LA SECCION DE MARKETING');
INSERT INTO `categorias` (`ID_CATEGORIA`,`NOMBRE`, `DESCRIPCION`) VALUES (2,'FRONT-END', 'PUESTO PARA LA SECCION DE FRONT-END');
INSERT INTO `categorias` (`ID_CATEGORIA`,`NOMBRE`,`DESCRIPCION`) VALUES (3,'BACK-END', 'PUESTO PARA LA SECCION DE BACK-END');
INSERT INTO `categorias` (`ID_CATEGORIA`,`NOMBRE`,`DESCRIPCION`) VALUES (4,'SECRETARIA', 'PUESTO PARA SECRETARIA');

INSERT INTO `vacantes` (`ID_VACANTE`,`NOMBRE`,`DESCRIPCION`,`FECHA`,`SALARIO`,`ESTATUS`,`DESTACADO`,`IMAGEN`,`DETALLES`,`ID_CATEGORIA`) VALUES (1,'SECRETARIA', 'PUESTO DE SECRETARIA','2024-02-24',1200,'CREADA',1,'IMAGEN','GESTION DE FACTURAS',4);
INSERT INTO `vacantes` (`ID_VACANTE`,`NOMBRE`,`DESCRIPCION`,`FECHA`,`SALARIO`,`ESTATUS`,`DESTACADO`,`IMAGEN`,`DETALLES`,`ID_CATEGORIA`) VALUES (2,'MARKETING', 'PUESTO DE MARKETING','2024-02-24',1200,'CREADA',1,'IMAGEN','PROMOCIONAR NUESTROS PRODUCTOS',1);
INSERT INTO `vacantes` (`ID_VACANTE`,`NOMBRE`,`DESCRIPCION`,`FECHA`,`SALARIO`,`ESTATUS`,`DESTACADO`,`IMAGEN`,`DETALLES`,`ID_CATEGORIA`) VALUES (3,'FRONT-END', 'PUESTO DE FRONT-END','2024-02-24',1200,'CREADA',1,'IMAGEN','DISEÑAR PAGINAS CON HTML,CSS',2);
INSERT INTO `vacantes` (`ID_VACANTE`,`NOMBRE`,`DESCRIPCION`,`FECHA`,`SALARIO`,`ESTATUS`,`DESTACADO`,`IMAGEN`,`DETALLES`,`ID_CATEGORIA`) VALUES (4,'BACK-END', 'PUESTO DE BACK-END','2024-02-24',1200,'CREADA',1,'IMAGEN','GESTION DE APIREST CON SPRING',3);

