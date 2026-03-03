-- 코드를 입력하세요
SELECT CAR_ID, max(
    case 
    when  '2022-10-16' Between DATE(Start_date) and DATE(end_date)
    then '대여중'
    else '대여 가능'
    end
) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by 1 desc