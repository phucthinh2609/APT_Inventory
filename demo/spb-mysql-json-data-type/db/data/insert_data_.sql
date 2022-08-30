--
-- Dumping data for table `computer_configuration_parameters`
--

LOCK TABLES `computer_configuration_parameters` WRITE;
/*!40000 ALTER TABLE `computer_configuration_parameters` DISABLE KEYS */;
INSERT INTO `computer_configuration_parameters` VALUES
    (1,'Bộ vi xử lý','processor',0),
    (2,'RAM','memory',0),
    (3,'Bộ nhớ','capacity',0),
    (4,'Graphics card','graphicCard',0),
    (5,'Màn hình','monitor',0),
    (6,'Kích thước','size',0),
    (7,'Trọng lượng','weight',0),
    (8,'Cổng kết nối','connectorPort',1);
/*!40000 ALTER TABLE `computer_configuration_parameters` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;