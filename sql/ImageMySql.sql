// Create the Image table

CREATE TABLE image (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1024) NOT NULL,
  `title` VARCHAR(2048) NULL,
  `description` VARCHAR(4096) NULL,
  `extension` VARCHAR(160) NULL,
  `size` FLOAT NOT NULL,
  `caption` VARCHAR(1024) NULL,
  `altText` VARCHAR(512) NULL,
  `picture` LONGBLOB NOT NULL,
  `createdAt` DATETIME NULL,
  `modifiedAt` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_image_name` (`name` ASC),
  INDEX `idx_image_type` (`type` ASC)
) ENGINE = InnoDB;