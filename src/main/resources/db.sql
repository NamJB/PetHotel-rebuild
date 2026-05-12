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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
ALTER TABLE member
MODIFY pwd VARCHAR(255) NOT NULL; |




--게시판--
CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유 번호',
    board_type VARCHAR(10) NOT NULL COMMENT 'B01: 공지사항, B02: 질문(QnA),B03: 자유게시판'
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

ALTER TABLE reservation
ADD COLUMN amount INT NOT NULL COMMENT '예약 총 금액';

ALTER TABLE reservation
MODIFY status VARCHAR(30)
NOT NULL DEFAULT 'PENDING_PAYMENT'
COMMENT 'PENDING_PAYMENT: 결제대기, PAID: 결제완료, CANCEL: 예약취소, COMPLETED: 이용완료';




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



CREATE TABLE payment (

    pay_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '결제 PK',

    res_id BIGINT NOT NULL COMMENT '예약 번호 FK',

    member_id BIGINT NOT NULL COMMENT '결제한 회원 번호',

    imp_uid VARCHAR(100) NOT NULL COMMENT '포트원 결제 고유번호',

    merchant_uid VARCHAR(100) COMMENT '주문번호',

    amount INT NOT NULL COMMENT '실제 결제 금액',

    pay_method VARCHAR(30) COMMENT '결제 수단(card, kakaopay 등)',

    pay_status VARCHAR(30) DEFAULT 'paid' COMMENT '결제 상태(paid, cancel 등)',

    paid_at DATETIME COMMENT '실제 결제 완료 시간',

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간'

);