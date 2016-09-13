CREATE TABLE userVO(
account varchar(50) NOT NULL ,
pwd varchar(20) DEFAULT NULL,
joindate DATETIME DEFAULT now(),
grade INT DEFAULT 1,
isAccountNonExpired boolean DEFAULT TRUE,
isAccountNonLocked boolean DEFAULT TRUE,
isCredentialsNonExpired boolean DEFAULT TRUE,
isEnabled boolean DEFAULT TRUE,
PRIMARY KEY (account)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE userRoleVO (
  account_role_idx INT NOT NULL AUTO_INCREMENT,
  account varchar(45) NOT NULL,
  userRole varchar(45) NOT NULL,
  PRIMARY KEY (account_role_idx),
  UNIQUE KEY uni_username_role (userRole,account),
  KEY fk_account_idx (account),
  CONSTRAINT fk_username FOREIGN KEY (account) REFERENCES userVO (account)
) ENGINE=InnoDB, AUTO_INCREMENT=1, DEFAULT CHARSET=utf8;

CREATE TABLE boardVO(
boardno INT NOT NULL AUTO_INCREMENT,
account varchar(50) DEFAULT NULL,
subject varchar(250) DEFAULT NULL,
content Longtext,
regdate DATETIME DEFAULT now(),
hit INT DEFAULT 0,
blike INT  DEFAULT 0,
depth INT  DEFAULT 0,
  PRIMARY KEY (boardno),
  FOREIGN KEY (account) REFERENCES userVO(account)
) ENGINE=InnoDB, AUTO_INCREMENT=1, DEFAULT CHARSET=utf8;

CREATE TABLE boardReplyVO(
  boardReplyNo Int NOT NULL AUTO_INCREMENT,
  reBoardNo INT,
  reAccount varchar(50) NOT NULL,
  replyContent LONGTEXT NOT NULL,
  replyRegDate DATETIME DEFAULT now(),
  boardLikeNum INT DEFAULT 0,
  PRIMARY KEY (boardReplyNo)
) ENGINE=InnoDB, AUTO_INCREMENT=1, DEFAULT CHARSET=utf8;

CREATE TABLE boardFileVO
(
  fileNo INT PRIMARY KEY,
  fileBoardNo INT NOT NULL,
  originFileName VARCHAR(260) NOT NULL,
  storeFileName VARCHAR(36) NOT NULL,
  fileSize INT,
  fileRegdate DATETIME DEFAULT now() NOT NULL,
  fileRegAccount VARCHAR(30) NOT NULL
);

SELECT * FROM boardVO
  WHERE boardVO.content LIKE concat('%','두개','%') OR boardVO.subject LIKE concat('%','두개','%')
			ORDER BY boardno DESC
			LIMIT 0,10;

INSERT INTO userVO VALUES ('3333' ,'3333',now(), DEFAULT,DEFAULT ,DEFAULT ,DEFAULT ,DEFAULT);

INSERT INTO boardVO VALUES(DEFAULT,'1111','검색 설훈이당 설훈','검색 두개기능 구현하기',DEFAULT,DEFAULT,DEFAULT,DEFAULT);

INSERT INTO userRoleVO (account, userRole)
VALUES ('1111', 'ROLE_USER');
INSERT INTO userRoleVO (account, userRole)
VALUES ('2222', 'ROLE_ADMIN');
INSERT INTO userRoleVO (account, userRole)
VALUES ('3333', 'ROLE_USER');

SELECT * FROM boardVO
ORDER BY boardno DESC LIMIT 0,10;

UPDATE boardVO SET subject='되는거냐',content='되는거냐',regdate=now() WHERE boardno=138;
