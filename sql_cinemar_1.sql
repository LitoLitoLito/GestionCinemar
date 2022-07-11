USE `cinecine` ;

-- -----------------------------------------------------
-- Table `cinecine`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`salas` (
  `IdSala` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Filas` INT NULL DEFAULT NULL,
  `Butacasporfila` INT NULL DEFAULT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`IdSala`));
  
INSERT INTO `salas` (`IdSala`, `Nombre`, `Filas`, `Butacasporfila`, `Estado`) VALUES
(1, 'Sala 2D', 5, 5, 1),
(2, 'Sala 3D', 5, 5, 1);
  

-- -----------------------------------------------------
-- Table `cinecine`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`peliculas` (
  `IdPelicula` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(50) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Director` VARCHAR(50) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Descripcion` VARCHAR(1000) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Genero` VARCHAR(50) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Duracion` FLOAT NOT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`IdPelicula`));

INSERT INTO `peliculas` (`IdPelicula`, `Titulo`, `Director`,  `Descripcion`, `Genero`, `Duracion`, `Estado`) VALUES
(1, 'EL GABINETE DEL DR. CALIGARI (1920)','ROBERT WIENE.','*******************************************************************
*  Uno de las películas más representativas del expresionismo alemán, una joya    
*  del cine de terror más primitivo.                                                                            
*  En una feria de un pueblo alemán, el Dr Caligari exhibe en su espectáculo a un   
*  personaje sonámbulo llamado Cesare, quien tiene un aspecto turbador. También 
*  tiene el don de poder augurar el futuro. Cuando dos amigos, Francis y Alan deciden 
*  visitar el espectáculo, Cesare advierte sobre la inminente muerte de uno de ellos.
*********************************************************************', 'TERROR', 60, 1),
(2, 'NOSFERATU (1922).', 'FRIEDRICH W. MURNAU', '**********************************************************************
*  Basada en el libro Drácula de Bram Stoker, Nosferatu es un clásico del expresionismo 
*  alemán. Un corredor inmobiliario llamado Hutter debe vender el castillo del conde 
*  Graf Orlock. Hutter no ha advertido que es, en realidad, un vampiro. El conde Orlock 
*  se interesa en Ellen, la mujer de Hutter.
*********************************************************************', 'TERROR', 60, 1);
-- -----------------------------------------------------
-- Table `cinecine`.`horarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`horarios` (
  `Horario` TIME NOT NULL,
  `Precio` DOUBLE(8,2) NULL DEFAULT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`Horario`));
  
INSERT INTO `horarios` (`Horario`, `Precio`, `Estado`) VALUES
('16:00:00', 500, 1),
('21:00:00', 900, 1);


-- -----------------------------------------------------
-- Table `cinecine`.`funciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`funciones` (
  `IdFuncion` INT NOT NULL AUTO_INCREMENT,
  `IdSala` INT NOT NULL,
  `IdPelicula` INT NOT NULL,
  `Horario` TIME NOT NULL,
  `Fecha` DATE NOT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`IdFuncion`, `IdSala`, `IdPelicula`, `Horario`, `Fecha`),
  INDEX `IdSala` (`IdSala` ASC),
  INDEX `IdPelicula` (`IdPelicula` ASC),
  INDEX `Horario` (`Horario` ASC) ,
  CONSTRAINT `funciones_ibfk_1`
    FOREIGN KEY (`IdSala`)
    REFERENCES `cinecine`.`salas` (`IdSala`),
  CONSTRAINT `funciones_ibfk_2`
    FOREIGN KEY (`IdPelicula`)
    REFERENCES `cinecine`.`peliculas` (`IdPelicula`),
  CONSTRAINT `funciones_ibfk_3`
    FOREIGN KEY (`Horario`)
    REFERENCES `cinecine`.`horarios` (`Horario`));
INSERT INTO `funciones` (`IdFuncion`, `IdSala`, `IdPelicula`, `Horario`, `Fecha`, `Estado`) VALUES
(1, 1, 1, '16:00:00', '2022-08-1', 1),
(2, 2, 2, '16:00:00', '2022-08-1', 1),
(3, 1, 1, '21:00:00', '2022-08-1', 1),
(4, 2, 2, '21:00:00', '2022-08-1', 1),
(5, 1, 1, '16:00:00', '2022-08-2', 1),
(6, 2, 2, '16:00:00', '2022-08-2', 1),
(7, 1, 1, '21:00:00', '2022-08-2', 1),
(8, 2, 2, '21:00:00', '2022-08-2', 1);


-- -----------------------------------------------------
-- Table `cinecine`.`butacas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`butacas` (
  `IdButaca` INT NOT NULL AUTO_INCREMENT,
  `IdFuncion` INT NULL DEFAULT NULL,
  `Fila` INT NULL DEFAULT NULL,
  `Columna` INT NULL DEFAULT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`IdButaca`),
  INDEX `IdFuncion` (`IdFuncion` ASC),
  CONSTRAINT `butacas_ibfk_1`
    FOREIGN KEY (`IdFuncion`)
    REFERENCES `cinecine`.`funciones` (`IdFuncion`)
    ON DELETE CASCADE);
    
    INSERT INTO `butacas` (`IdButaca`, `IdFuncion`, `Fila`, `Columna`, `Estado`) VALUES
(1, 1, 1, 4, 1);



-- -----------------------------------------------------
-- Table `cinecine`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`usuarios` (
  `IdUsuario` VARCHAR(70) NOT NULL,
  `clave` VARCHAR(10) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Nombre` VARCHAR(60) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Apellido` VARCHAR(50) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Estado` INT NULL DEFAULT '1',
  `FechaNacimiento` DATE NOT NULL,
  `Celular` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`));
  
  INSERT INTO `usuarios` (`IdUsuario`, `clave`, `Nombre`, `Apellido`, `Estado`, `FechaNacimiento`, `Celular`) VALUES
  ('lititosalta@gmail.com', '123456', 'Julio', 'Acuña', 1, '1965-12-05', '3874892337');


-- -----------------------------------------------------
-- Table `cinecine`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinecine`.`reservas` (
  `IdReserva` INT NOT NULL AUTO_INCREMENT,
  `Horario` TIME NOT NULL,
  `IdFuncion` INT NOT NULL,
  `IdSala` INT NOT NULL,
  `IdPelicula` INT NOT NULL,
  `IdUsuario` VARCHAR(70) NOT NULL,
  `Nombre` VARCHAR(60) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Fecha` DATE NOT NULL,
  `Precio` DOUBLE NULL DEFAULT NULL,
  `Estado` INT NULL DEFAULT '1',
  PRIMARY KEY (`IdReserva`),
  INDEX `IdUsuario` (`IdUsuario` ASC),
  INDEX `IdFuncion` (`IdFuncion` ASC, `IdSala` ASC, `IdPelicula` ASC, `Horario` ASC, `Fecha` ASC),
  CONSTRAINT `reservas_ibfk_1`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `cinecine`.`usuarios` (`IdUsuario`),
  CONSTRAINT `reservas_ibfk_2`
    FOREIGN KEY (`IdFuncion` , `IdSala` , `IdPelicula` , `Horario` , `Fecha`)
    REFERENCES `cinecine`.`funciones` (`IdFuncion` , `IdSala` , `IdPelicula` , `Horario` , `Fecha`));

INSERT INTO `reservas` (`IdReserva`, `Horario`, `IdFuncion`, `IdSala`, `IdPelicula`, `IdUsuario`, `Nombre`, `Fecha`, `Precio`, `Estado`) VALUES
(1,'16:00:00', 1, 1, 1, 'lititosalta@gamil.com', 'Julio', '2022-08-01', 1);


