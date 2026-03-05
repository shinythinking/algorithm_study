-- 코드를 작성해주세요
select a.dept_id, dept_name_en, a.avg_sal
from (select dept_id, round(avg(sal)) avg_sal
from hr_employees
group by dept_id) a
join HR_DEPARTMENT
using (dept_id)
order by 3 desc