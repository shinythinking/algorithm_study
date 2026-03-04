-- 코드를 입력하세요
# with recursive prices as (
#     select 0 as price
#     union all
#     select price + 10000 from prices where price <100000
# )

SELECT truncate(price, -4) as price_group, count(truncate(price, -4)) as products
from product
group by truncate(price, -4)
order by 1
