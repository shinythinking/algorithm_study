-- 코드를 작성해주세요

with ranked as (
select id, fish_type, length, rank() over (partition by fish_type order by length desc) as ra
from fish_info
)


select r.ID,	f.FISH_NAME,	r.LENGTH
from ranked r
join fish_name_info f
on r.fish_type = f.fish_type
where r.ra = 1
order by r.Id