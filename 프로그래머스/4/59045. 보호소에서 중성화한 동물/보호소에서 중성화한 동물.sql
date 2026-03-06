-- 코드를 입력하세요
SELECT animal_id, ai.animal_type, ai.name
from animal_ins ai
join animal_outs ao
using(animal_id)
where ai.SEX_UPON_INTAKE regexp 'Intact' and ao.SEX_UPON_OUTCOME regexp 'Spayed|Neutered'