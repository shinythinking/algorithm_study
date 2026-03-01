-- 코드를 입력하세요
SELECT  ugb.TITLE,ugb.BOARD_ID, ugr.REPLY_ID,  ugr.WRITER_ID, ugr.CONTENTS,
date_format(ugr.created_date, "%Y-%m-%d") created_date
from USED_GOODS_BOArD ugb join USED_GOODS_REPLY ugr on ugb.board_id = ugr.board_id
where ugb.created_date between ('2022-10-01') and ('2022-10-31')
order by created_date asc, ugb.title asc