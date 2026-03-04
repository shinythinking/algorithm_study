-- 코드를 입력하세요
with more as (

    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
    group by car_id
    having count(car_id) >=5
)

SELECT month(c.start_date) month, m.car_id, count(m.car_id) as records
from more m
 join CAR_RENTAL_COMPANY_RENTAL_HISTORY c
using (car_id)

    where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
    group by month(c.start_date), m.car_id
    having records > 0
    order by 1,2 desc