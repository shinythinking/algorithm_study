-- 코드를 입력하세요
SELECT BOOK_ID,	AUTHOR_NAME, date_format( PUBLISHED_DATE, '%Y-%m-%d') as published_date
from book
join author
using(author_id)
where category = '경제'
order by 3