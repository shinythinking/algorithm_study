-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
CASE WHEN STATUS = 'DONE' THEN '거래완료'
when status = 'reserved' then '예약중'
ELSE '판매중'
END AS STATUS
FROM USED_GOODS_BOARD
WHERE date_format(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
ORDER BY 1 DESC