-- 코드를 작성해주세요

select
    (case
        when (skill_code & (select sum(code) from skillcodes where category = 'Front End') )> 0
        and (skill_code & (select code from skillcodes where name = 'python')) > 0
        then 'A'
        when (skill_code & (select code from skillcodes where name = 'c#')) > 0
        then 'B'
        when (skill_code & (select sum(code) from skillcodes where category = 'Front End') )> 0
        then 'C'
     
    end) as grade, id, email
from developers
having grade is not null
order by 1, 2