-- 코드를 작성해주세요

with a as (select id, ntile(4) over (order by size_of_colony) qu
from ecoli_data)

select id, 
case  
    when qu = 1 then 'LOW'
    when qu = 2 then 'MEDIUM'
    when qu = 3 then 'HIGH'
    else 'CRITICAL'
end as colony_name
from a
order by 1