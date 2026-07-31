/*
=========================================================
프로젝트 : PetHotel-rebuild
파일명   : V001_init.sql
작성자   : 남정범
작성일   : 2026-07-31
목적     : 프로젝트 초기 데이터베이스 생성
=========================================================
*/


--member

CREATE TABLE `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 고유 번호',
  `userid` varchar(50) DEFAULT NULL COMMENT '로그인 아이디',
  `pwd` varchar(255) NOT NULL COMMENT '암호화된 비밀번호',
  `username` varchar(50) NOT NULL COMMENT '회원 이름',
  `nickname` varchar(50) DEFAULT NULL COMMENT '닉네임',
  `phone` varchar(20) DEFAULT NULL COMMENT '전화번호',
  `role` varchar(20) NOT NULL DEFAULT 'USER' COMMENT '회원 권한',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '가입일시',
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `uk_member_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




--board

REATE TABLE `board` (
  `board_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '게시글 고유 번호',
  `board_type` varchar(10) NOT NULL COMMENT 'B01: 공지사항, B02: 질문, B03: 자유게시판',
  `title` varchar(255) NOT NULL COMMENT '게시글 제목',
  `content` text NOT NULL COMMENT '게시글 내용',
  `writer_id` bigint(20) NOT NULL COMMENT '작성자 회원 번호',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '조회수',
  `secret_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '비밀글 여부(Y/N)',
  `del_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제 여부(Y: 삭제, N: 미삭제)',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '작성일시',
  `updated_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`board_id`),
  KEY `fk_board_member` (`writer_id`),
  CONSTRAINT `fk_board_member` FOREIGN KEY (`writer_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




--pet

CREATE TABLE `pet` (
  `pet_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '펫 고유 번호',
  `member_id` bigint(20) NOT NULL COMMENT '소유 회원 번호',
  `name` varchar(50) NOT NULL COMMENT '펫 이름',
  `type` varchar(50) DEFAULT NULL COMMENT '펫 종류',
  `age` int(11) DEFAULT NULL COMMENT '나이',
  `gender` varchar(10) DEFAULT NULL COMMENT '성별',
  `weight` double DEFAULT NULL COMMENT '몸무게',
  `note` text DEFAULT NULL COMMENT '특이사항 및 메모',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '삭제 여부',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '등록일시',
  PRIMARY KEY (`pet_id`),
  KEY `fk_pet_member` (`member_id`),
  CONSTRAINT `fk_pet_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




--reservation

CREATE TABLE `reservation` (
  `res_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '예약 고유 번호',
  `member_id` bigint(20) NOT NULL COMMENT '예약 회원 번호',
  `check_in` date NOT NULL COMMENT '체크인 날짜',
  `check_out` date NOT NULL COMMENT '체크아웃 날짜',
  `amount` int(11) NOT NULL COMMENT '예약 총 금액',
  `status` varchar(30) NOT NULL DEFAULT 'PENDING_PAYMENT' COMMENT 'PENDING_PAYMENT: 결제대기, PAID: 결제완료, CANCEL: 예약취소, COMPLETED: 이용완료',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '예약 생성일시',
  PRIMARY KEY (`res_id`),
  KEY `fk_reservation_member` (`member_id`),
  CONSTRAINT `fk_reservation_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



--reservation_pet

CREATE TABLE `reservation_pet` (
  `respet_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '예약 펫 고유 번호',
  `res_id` bigint(20) NOT NULL COMMENT '예약 번호',
  `pet_id` bigint(20) NOT NULL COMMENT '펫 번호',
  PRIMARY KEY (`respet_id`),
  UNIQUE KEY `uk_reservation_pet` (`res_id`,`pet_id`),
  KEY `fk_reservation_pet_pet` (`pet_id`),
  CONSTRAINT `fk_reservation_pet_pet` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`pet_id`),
  CONSTRAINT `fk_reservation_pet_reservation` FOREIGN KEY (`res_id`) REFERENCES `reservation` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



--payment

CREATE TABLE `payment` (
  `pay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '결제 고유 번호',
  `res_id` bigint(20) NOT NULL COMMENT '예약 번호',
  `member_id` bigint(20) NOT NULL COMMENT '결제 회원 번호',
  `imp_uid` varchar(100) NOT NULL COMMENT '포트원 결제 고유번호',
  `merchant_uid` varchar(100) DEFAULT NULL COMMENT '주문번호',
  `amount` int(11) NOT NULL COMMENT '실제 결제 금액',
  `pay_method` varchar(30) DEFAULT NULL COMMENT '결제 수단(card, kakaopay 등)',
  `pay_status` varchar(30) NOT NULL DEFAULT 'paid' COMMENT '결제 상태(paid, cancel 등)',
  `paid_at` datetime DEFAULT NULL COMMENT '실제 결제 완료 시간',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성 시간',
  PRIMARY KEY (`pay_id`),
  UNIQUE KEY `uk_payment_imp_uid` (`imp_uid`),
  KEY `fk_payment_reservation` (`res_id`),
  KEY `fk_payment_member` (`member_id`),
  CONSTRAINT `fk_payment_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `fk_payment_reservation` FOREIGN KEY (`res_id`) REFERENCES `reservation` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

