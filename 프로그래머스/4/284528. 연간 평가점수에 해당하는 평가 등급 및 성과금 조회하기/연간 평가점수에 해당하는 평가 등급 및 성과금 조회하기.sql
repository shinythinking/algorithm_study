-- 코드를 작성해주세요
select e.emp_no, e.emp_name, n.grade, (e.sal /100 * n.percent) as bonus
from hr_employees e
join
(select emp_no,  case when sum(score)  >= 192 then 'S' when sum(score)  >= 180 then 'A' when sum(score)  >= 160 then 'B' else 'C' end as grade, case when sum(score)  >= 192 then 20 when sum(score)  >= 180 then 15 when sum(score)  >= 160 then 10 else 0 end as percent
from hr_grade
group by emp_no) n
using (emp_no)
order by 1