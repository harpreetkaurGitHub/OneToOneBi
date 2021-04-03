# OneToOneBi
This is One to One Bi-Directional Mapping through Hibernate
here I have provided MYSQL quries

DROP SCHEMA IF EXISTS `OneToOneBi`;

CREATE SCHEMA `OneToOneBi`;

use `OneToOneBi`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructorDetail`;

CREATE TABLE `instructorDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `youtubeChannel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructorDetailId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructorDetailId`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructorDetailId`) REFERENCES `instructorDetail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;



// THis is Bi-Directional
    //If you remove this part it will be Uni-Directional
    @OneToOne(mappedBy = "instructorDetailId",cascade = CascadeType.ALL)
    Instructor instructor;

    private Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
