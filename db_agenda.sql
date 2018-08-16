-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-08-2018 a las 08:00:15
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE IF NOT EXISTS `contacto` (
  `id_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `direccion` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `alias` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_contacto`),
  KEY `fk_contacto_usuario_idx` (`usuario_id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id_contacto`, `nombre`, `telefono`, `direccion`, `alias`, `usuario_id_usuario`) VALUES
(17, 'luis', '091607561', 'direc', 'argem', 6),
(18, 'a', '099', 'd', 'a', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE IF NOT EXISTS `grupo` (
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`id_grupo`, `nombre`) VALUES
(1, 'Amigos'),
(2, 'Compañeros'),
(3, 'Conocidos'),
(4, 'Familia'),
(5, 'Otros'),
(6, 'Trabajo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo_contacto`
--

CREATE TABLE IF NOT EXISTS `grupo_contacto` (
  `id_gc` int(11) NOT NULL AUTO_INCREMENT,
  `id_grupo` int(11) NOT NULL,
  `id_contacto` int(11) NOT NULL,
  PRIMARY KEY (`id_gc`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=38 ;

--
-- Volcado de datos para la tabla `grupo_contacto`
--

INSERT INTO `grupo_contacto` (`id_gc`, `id_grupo`, `id_contacto`) VALUES
(33, 1, 17),
(34, 5, 17),
(37, 4, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE IF NOT EXISTS `imagen` (
  `id_imagen` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` mediumblob,
  `comentario` varchar(250) CHARACTER SET latin1 NOT NULL,
  `contacto_id_contacto` int(11) NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `fk_imagen_contacto1_idx` (`contacto_id_contacto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id_imagen`, `imagen`, `comentario`, `contacto_id_contacto`) VALUES
(11, 0x5b424033636435666236, 'coment', 17),
(12, 0x5b424065393136666466, 'v', 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `apellido` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `clave` varchar(64) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `correo` varchar(50) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `clave`, `correo`) VALUES
(6, 'luis e', 'vinamagua', 'b59c67bf196a4758191e42f76670ceba', 'luis.aries992@gmail.com'),
(9, 'clara', 'vinamagua', '81dc9bdb52d04dc20036dbd8313ed055', '@@');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `fk_contacto_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `fk_imagen_contacto1` FOREIGN KEY (`contacto_id_contacto`) REFERENCES `contacto` (`id_contacto`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
