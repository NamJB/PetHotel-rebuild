/*
=========================================================
프로젝트 : PetHotel-rebuild
파일명   : V002_add_reservation.sql
작성자   : 남정범
작성일   : 2026-07-31
목적     : reservation 컬럼변경및 추가 
=========================================================
*/

ALTER TABLE reservation
CHANGE COLUMN status reservation_status VARCHAR(20)
COMMENT '예약 상태 (CONFIRMED: 예약확정, CANCELLED: 예약취소)';

ALTER TABLE reservation
ADD COLUMN stay_status VARCHAR(20)
NOT NULL DEFAULT 'NOT_STARTED'
COMMENT '투숙 상태 (NOT_STARTED: 입실전, CHECKED_IN: 이용중, CHECKED_OUT: 퇴실완료)';