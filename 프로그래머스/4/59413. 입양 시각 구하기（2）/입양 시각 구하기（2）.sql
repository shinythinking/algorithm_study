-- 코드를 입력하세요
with recursive hours as (
    select 0 as hour
    union all
    select (hour + 1) as hour from hours where hour < 23
)

SELECT h.hour as hour, count(a.datetime) as count
from hours h
left join animal_outs a
on hour(a.datetime) = h.hour
group by h.hour
order by 1