
-- 코드를 입력하세요
with author_book as (
    select a.author_id, a.author_name, b.category, b.book_id, b.price
    from book b 
    join author  a
    on b.author_id = a.author_id
)

, full_join as (
    select a.book_id, a.AUTHOR_ID, a.AUTHOR_NAME, a.CATEGORY, b.sales_date, b.sales, a.price
    from author_book a
    join book_sales b
      using (book_id)
    where date_format(b.sales_date, '%Y-%m') = '2022-01'
    
) 

select AUTHOR_ID, AUTHOR_NAME, CATEGORY, Sum(sales * price)	as total_sales
from full_join
group by author_id, category
order by 1 asc, 3 desc

# SELECT AUTHOR_ID, AUTHOR_NAME, CATEGORY, TOTAL_SALES
# from 

# 