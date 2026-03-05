-- 코드를 작성해주세요
with mm as (select emp_no, sum(score) as score
from hr_grade
group by emp_no
order by 2 desc
limit 1 )

select SCORE, emp_no,	EMP_NAME,	POSITION,	EMAIL
from mm
join hr_employees
using (emp_no)