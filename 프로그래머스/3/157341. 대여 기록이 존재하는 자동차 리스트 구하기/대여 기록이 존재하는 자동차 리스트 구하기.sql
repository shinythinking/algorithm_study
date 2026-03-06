-- 코드를 입력하세요
SELECT distinct car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
join CAR_RENTAL_COMPANY_CAR
using (car_id)
where car_type = '세단' and month(start_date) =10
order by 1 desc