CREATE TABLE `orderx`
(
    `id`          bigint(11) IDENTITY NOT NULL,
    `no`          varchar(50)    DEFAULT NULL,
    `title`       varchar(50)    DEFAULT NULL,
    `totalAmount` decimal(18, 2) DEFAULT NULL,
    `createTime`  datetime       DEFAULT NULL,
    `status`      int(11)    DEFAULT NULL,
    PRIMARY KEY (`id`)
);