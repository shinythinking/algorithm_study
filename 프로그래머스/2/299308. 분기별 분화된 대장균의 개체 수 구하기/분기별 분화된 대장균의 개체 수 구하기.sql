-- 코드를 작성해주세요
select concat(quarter(differentiation_date),'Q') as quarter, count(id) ecoli_count
from ecoli_data
group by quarter
order by 1
