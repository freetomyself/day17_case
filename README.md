# day17_case
这个项目包括了登录、验证码、对数据库的增、删、改、查；以及批量删除、复杂查询、以及分页功能
This project includes login, authentication code, database addition, deletion, alteration, check, and batch deletion, complex query, and paging functions.

/***********************************
mysql使用的数据数据库表：
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4;

************************************/

2019-6-27添加了Filter，对未登录用户过滤，对非法敏感字符过滤
