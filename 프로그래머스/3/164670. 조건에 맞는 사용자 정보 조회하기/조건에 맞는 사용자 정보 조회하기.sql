-- 코드를 입력하세요
SELECT ugu.USER_ID,	ugu.NICKNAME,	concat(ugu.city,' ', ugu.street_address1,' ', ugu.street_address2) as '전체주소', concat(
    substring(ugu.tlno,1,3), '-',
    substring(ugu.tlno,4,4), '-',
    substring(ugu.tlno,8,4)
) as '전화번호'
from used_goods_user ugu
where ugu.user_id in (
    select writer_id
from used_goods_board
group by writer_id
having count(*) >= 3
)
order by 1 desc

