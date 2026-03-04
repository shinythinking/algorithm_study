-- 코드를 입력하세요
SELECT  year(sales_date) as year, month(sales_date) as month,  gender, count(distinct user_id) as users
from user_info
join online_sale o
using(user_id)
group by year(sales_date) , month(sales_date) ,  gender
having gender is not null
order by 1,2,3