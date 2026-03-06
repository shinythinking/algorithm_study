-- 코드를 입력하세요
SELECT animal_id, ao.name
from animal_outs ao
join animal_ins ai
using(animal_id)
where ao.datetime < ai.datetime
order by ai.datetime