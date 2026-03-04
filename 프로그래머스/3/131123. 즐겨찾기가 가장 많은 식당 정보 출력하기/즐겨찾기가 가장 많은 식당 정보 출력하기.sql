-- 코드를 입력하세요
# select * 
# from rest_info

    SELECT food_type, rest_id, rest_name, favorites
    from rest_info
    where (food_type, favorites) in (SELECT food_type, max(favorites) as favorites
    from rest_info
    group by food_type)
    
    order by 1 desc