-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPERS
where skill_code & (select sum(code) from skillcodes where name = 'python' or name = 'C#') > 0
order by 1