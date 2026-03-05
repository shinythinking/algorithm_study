-- 코드를 입력하세요
with recursive m as (
    select 9 as h
    union all
    select h + 1 from m where h <19
)
SELECT h, count(*) as count
from m
join animal_outs
on hour(datetime) = h
group by h
order by 1