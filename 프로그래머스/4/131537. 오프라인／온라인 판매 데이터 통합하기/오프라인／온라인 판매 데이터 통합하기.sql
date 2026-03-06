-- 코드를 입력하세요
select  date_format(a.sales_date, '%Y-%m-%d') sales_date, a.product_id, a.user_id, a.sales_amount
from (
    select sales_date, product_id, user_id, sales_amount
    from online_sale

union all

    select sales_date, product_id, null, sales_amount
    from offline_sale
) a
where date_format(a.sales_date, '%Y-%m') = '2022-03'
order by 1, 2, 3
