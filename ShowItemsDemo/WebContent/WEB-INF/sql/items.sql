drop table if exists items;
create table items(
  id int(11) not null auto_increment,
  name varchar(50) default null,
  city varchar(50) default null,
  price int(11) default null,
  number int(11) default null,
  picture varchar(50) default null,
  primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf-8;

INSERT INTO items VALUES ('1','��������Ь','��ɽ','180','500','001.jpg');
INSERT INTO items VALUES ('2','��̤�˶�Ь','����','120','800','002.jpg');
INSERT INTO items VALUES ('3','�Ϳ��˶�Ь','����','500','1000','003.jpg');
INSERT INTO items VALUES ('4','���ϴ�˹TѪ��','�Ϻ�','388','600','004.jpg');
INSERT INTO items VALUES ('5','�����Ļ���','����','180','900','005.jpg');
INSERT INTO items VALUES ('6','С��3','����','1999','3000','006.jpg');
INSERT INTO items VALUES ('7','С��2S','����','1499','500','007.jpg');
INSERT INTO items VALUES ('8','thinkpad�ʼǱ�','����','6990','500','008.jpg');
INSERT INTO items VALUES ('9','dell�ʼǱ�','�Ϻ�','3999','500','009.jpg');
INSERT INTO items VALUES ('10','ipad5','����','5999','500','010.jpg');