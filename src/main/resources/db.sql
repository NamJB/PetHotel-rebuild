-- 펫호텔 데이터베이스
--2026.04.08




--회원


CREATE TABLE `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `pwd` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'USER',
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 |




--게시판--
CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유 번호',
    board_type VARCHAR(10) NOT NULL COMMENT 'B01: 공지사항, B02: 질문(QnA)',
    title VARCHAR(255) NOT NULL COMMENT '게시글 제목',
    content TEXT NOT NULL COMMENT '게시글 내용',
    writer_id INT NOT NULL COMMENT '작성자 회원 번호 (member 테이블과 연결)',
    view_count INT DEFAULT 0 COMMENT '조회수',
    secret_yn CHAR(1) DEFAULT 'N' COMMENT '비밀글 여부 (Y/N - QnA용)',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
);
ALTER TABLE board 
ADD COLUMN del_yn CHAR(1) DEFAULT 'N' NOT NULL COMMENT '삭제 여부 (Y:삭제, N:미삭제)';

--예약

CREATE TABLE `reservation` (
  `res_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `check_in` date NOT NULL,
  `check_out` date NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `status` varchar(20) DEFAULT '완료',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8






--예약된펫

reservation_pet | CREATE TABLE `reservation_pet` (
  `respet_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_id` int(11) NOT NULL,
  `pet_id` int(11) NOT NULL,
  PRIMARY KEY (`respet_id`)
)



--펫
CREATE TABLE `pet` (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`pet_id`)
)

ALTER TABLE pet ADD COLUMN note TEXT; --메모 추가 26
ALTER TABLE pets ADD COLUMN is_deleted TINYINT(1) NOT NULL DEFAULT 0; 