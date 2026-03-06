-- 코드를 작성해주세요
# from (select parent_id, sum(id) child_count
# from ecoli_data
# group by parent_id)
# join 
select id, ifnull(child_count,0)  child_count
from (select parent_id, count(id) child_count
from ecoli_data
group by parent_id) p
right join ecoli_data e
on p.parent_id = e.id
order by 1

# select * 
# from ecoli_data

# select id, count(id) over (partition by parent_id) child_count
# from ecoli_data