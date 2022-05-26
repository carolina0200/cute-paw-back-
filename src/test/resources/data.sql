CREATE TABLE IF NOT EXISTS usuario (
  id INT NOT NULL,
  clave varchar(255) DEFAULT NULL,
  usuario varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS rol_usuario (
  id INT NOT NULL,
  rol varchar(255) DEFAULT NULL,
  id_usuario INT DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_ROL_USUARIO
    FOREIGN KEY (id_usuario)
        REFERENCES usuario(id)
);
INSERT INTO usuario(id, usuario, clave) VALUES (1, 'carolina', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f');
INSERT INTO rol_usuario(id, rol, id_usuario) VALUES (1, 'USER', 1);