-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') as FREEZER_YN
from food_warehouse
where substring(address,1,2) = '경기'