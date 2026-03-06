-- 코드를 입력하세요
SELECT car_id, car_type, daily_fee, options
from CAR_RENTAL_COMPANY_CAR
where options regexp '네비게이션'
order by 1 desc