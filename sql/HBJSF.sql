-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema HBJSF
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `HBJSF` ;

-- -----------------------------------------------------
-- Schema HBJSF
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HBJSF` DEFAULT CHARACTER SET utf8 ;
USE `HBJSF` ;

-- -----------------------------------------------------
-- Table `HBJSF`.`Answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HBJSF`.`Answer` ;

CREATE TABLE IF NOT EXISTS `HBJSF`.`Answer` (
  `AnswerId` INT NOT NULL AUTO_INCREMENT,
  `QuestionId` INT NOT NULL,
  `Answer` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`AnswerId`),
  CONSTRAINT `fk_QuestionId`
    FOREIGN KEY (`QuestionId`)
    REFERENCES `HBJSF`.`Question` (`QuestionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_QuestionId_INDEX` ON `HBJSF`.`Answer` (`QuestionId` ASC);


-- -----------------------------------------------------
-- Table `HBJSF`.`Question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HBJSF`.`Question` ;

CREATE TABLE IF NOT EXISTS `HBJSF`.`Question` (
  `QuestionId` INT NOT NULL AUTO_INCREMENT,
  `CorrectAnswerId` INT NOT NULL,
  `Question` VARCHAR(255) NOT NULL,
  `Level` TINYINT NOT NULL,
  PRIMARY KEY (`QuestionId`),
  CONSTRAINT `fk_CorrectAnswerId`
    FOREIGN KEY (`CorrectAnswerId`)
    REFERENCES `HBJSF`.`Answer` (`AnswerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `fk_CorrectAnswerId_UNIQUE` ON `HBJSF`.`Question` (`CorrectAnswerId` ASC);

CREATE INDEX `Level_INDEX` ON `HBJSF`.`Question` (`Level` ASC);


-- -----------------------------------------------------
-- Data for table `HBJSF`.`Answer`
-- -----------------------------------------------------
START TRANSACTION;
USE `HBJSF`;
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (1, 1, 'Emman');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (2, 1, 'Peterin');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (3, 1, 'Timothyn');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (4, 1, 'Oscarin');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (5, 2, 'nuorallatanssija');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (6, 2, 'joulutonttu');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (7, 2, 'tirehtööri');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (8, 2, 'taikuri');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (9, 3, 'vehnäjauhoja');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (10, 3, 'kananmunia');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (11, 3, 'hiivaa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (12, 3, 'sokeria');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (13, 4, 'hevonen');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (14, 4, 'koira');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (15, 4, 'lisko');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (16, 4, 'lammas');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (17, 5, 'leijona');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (18, 5, 'Zyskowicz');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (19, 5, 'väärin');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (20, 5, 'kvaternäärinen');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (21, 6, 'makkaraa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (22, 6, 'orvokkia');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (23, 6, 'orpoa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (24, 6, 'makua');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HBJSF`.`Question`
-- -----------------------------------------------------
START TRANSACTION;
USE `HBJSF`;
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (1, 4, 'Minkä palkinnon näyttelijät saavat Amerikassa?', 1);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (2, 6, 'Mitä seuraavista et yleensä tapaa sirkuksessa?', 2);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (3, 11, 'Mitä ei tarvita lättytaikinaan?', 3);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (4, 14, 'Mikä on buldoggi?', 1);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (5, 19, 'Minkä sanan jokainen suomalainen kirjoittaa \"väärin\" kirjoittaessaan sen oikein?', 2);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (6, 21, 'Mitä tarkoittaa ruotsinkielinen sana korv?', 3);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
