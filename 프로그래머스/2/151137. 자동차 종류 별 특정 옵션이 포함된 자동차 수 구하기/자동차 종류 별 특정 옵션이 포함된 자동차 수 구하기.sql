-- 코드를 입력하세요
SELECT car_type, count(car_type) as cars
from CAR_RENTAL_COMPANY_CAR
where  options regexp '통풍시트|열선시트|가죽시트' 
group by car_type
order by 1

    