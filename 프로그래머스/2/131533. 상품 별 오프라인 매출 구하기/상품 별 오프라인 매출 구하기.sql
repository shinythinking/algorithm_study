-- 코드를 입력하세요
SELECT product_code, sum(sales_amount *  price)
from offline_sale
join product
using(product_id)
group by product_code
order by 2 desc, 1 asc