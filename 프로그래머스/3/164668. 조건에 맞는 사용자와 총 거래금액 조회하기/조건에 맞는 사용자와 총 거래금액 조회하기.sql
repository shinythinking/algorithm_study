-- 코드를 입력하세요
select user_id, nickname, a.total_sales
from (SELECT writer_id as user_id,  sum(price) total_sales
from used_goods_board 
where status = 'DONE'
group by writer_id
having sum(price) >= 700000) a
join used_goods_user
using(user_id)
order by 3