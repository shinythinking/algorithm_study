-- 코드를 작성해주세요
select round(avg(ifnull(length,10)),2) average_length
from fish_info
