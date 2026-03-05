-- 코드를 입력하세요
select category, max(price) max_price, product_name
from food_product
where (price, category) in (SELECT max(price), category
from food_product
where category regexp '과자|국|김치|식용유'
group by category)

group by category
order by 2 desc