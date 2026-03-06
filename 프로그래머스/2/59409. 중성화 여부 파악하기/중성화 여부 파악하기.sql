-- 코드를 입력하세요
SELECT animal_id, name, 
    (case when sex_upon_intake regexp 'Neutered|Spayed' then 'O'
    else 'X' end) as '중성화'
    
from animal_ins
order by 1