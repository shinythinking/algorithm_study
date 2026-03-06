-- 코드를 작성해주세요

with recursive generations as (
    select 1 as generation, id, parent_id from ecoli_data where parent_id is null
    union all
    select generation + 1 as generation, c.id, c.parent_id
    from ecoli_data c
    join generations p
    on p.id = c.parent_id
)

select count(*) count, generation
from generations
where id not in (
    select parent_id
    from ecoli_data
    where parent_id is not null
)
group by generation
order by 2