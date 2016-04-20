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
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (25, 7, 'painoindeksi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (26, 7, 'Belgradin Moottoriurheiluliitto');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (27, 7, 'Mannerheimin lastensuojeluliitto');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (28, 7, 'vakava puutostila');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (29, 8, 'peltopyy');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (30, 8, 'turkinkyyhky');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (31, 8, 'tilhi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (32, 8, 'harjalintu');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (33, 9, 'Pohjanmaan');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (34, 9, 'Savon');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (35, 9, 'Lapin');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (36, 9, 'Satakunnan');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (37, 10, '26');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (38, 10, '34');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (39, 10, '24');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (40, 10, '22');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (41, 11, 'musiikista');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (42, 11, 'tauluista');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (43, 11, 'politiikasta');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (44, 11, 'tanssimisesta');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (45, 12, 'nahkatuoli');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (46, 12, 'lihansyöjäkasvi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (47, 12, 'hammaslanka');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (48, 12, 'puhuja');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (49, 13, 'sairaalassa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (50, 13, 'eläintarhassa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (51, 13, 'rämesoilla');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (52, 13, 'paperitehtaassa');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (53, 14, 'kolme');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (54, 14, 'yksi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (55, 14, 'kaksi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (56, 14, 'viisi');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (57, 15, 'kolmen hallitsijan liitto');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (58, 15, 'voittokulkue');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (59, 15, 'kolmivärinen lippu');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (60, 15, 'juhlavaakuna');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (61, 16, 'karoliinit');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (62, 16, 'hakkapeliitat');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (63, 16, 'sinisukat');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (64, 16, 'punatakit');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (65, 17, '7');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (66, 17, '15');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (67, 17, 'Kaikki');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (68, 17, 'Loput');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (69, 17, 'Scattered Mars');
INSERT INTO `HBJSF`.`Answer` (`AnswerId`, `QuestionId`, `Answer`) VALUES (70, 17, 'Restless Moose');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HBJSF`.`Question`
-- -----------------------------------------------------
START TRANSACTION;
USE `HBJSF`;
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (1, 4, 'Minkä palkinnon näyttelijät saavat Amerikassa?', 1);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (2, 6, 'Mitä seuraavista et yleensä tapaa sirkuksessa?', 1);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (3, 11, 'Mitä ei tarvita lättytaikinaan?', 2);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (4, 14, 'Mikä on buldoggi?', 2);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (5, 19, 'Minkä sanan jokainen suomalainen kirjoittaa \"väärin\" kirjoittaessaan sen oikein?', 3);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (6, 21, 'Mitä tarkoittaa ruotsinkielinen sana korv?', 3);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (7, 25, 'Mikä on BMI?', 4);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (8, 32, 'Millä seuraavista linnuista on pisin nokka?', 4);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (9, 34, 'Minkä maakunnan vaakunassa on jännitetty jousi?', 5);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (10, 37, 'Kuinka monta osa-aluetta Perussa on?', 5);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (11, 44, 'Mistä Isadora Duncan on tunnettu?', 6);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (12, 48, 'Mikä on oraattori?', 6);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (13, 50, 'Missä todennäköisimmin näet kulaanin?', 7);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (14, 53, 'Kuinka monta oikeaa savupiippua Titanicissa oli?', 7);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (15, 57, 'Mikä on triumviraatti?', 8);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (16, 61, 'Millä nimellä kutsuttiin Kaarle XII:n sotilaita?', 8);
INSERT INTO `HBJSF`.`Question` (`QuestionId`, `CorrectAnswerId`, `Question`, `Level`) VALUES (17, 1, 'Kuinka paljon pisteitä Vaadin Bittinääriksi peli saa?', 9);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
