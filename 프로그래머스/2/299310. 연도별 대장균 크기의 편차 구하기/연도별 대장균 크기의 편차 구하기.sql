-- 코드를 작성해주세요

with yearMax as (
    select YEAR(DIFFERENTIATION_DATE) as yy, max(size_of_colony) as mm
    from ecoli_data
    group by  YEAR(DIFFERENTIATION_DATE)
)

select YEAR(DIFFERENTIATION_DATE) as year, (y.mm - e.SIZE_OF_COLONY)as Year_dev, e.id
from ecoli_data e
join yearMax y
on YEAR(e.DIFFERENTIATION_DATE) = y.yy
order by 1 asc, 2 asc



# WITH yearMax AS (
#     SELECT 
#         YEAR(DIFFERENTIATION_DATE) AS YR, -- 연도만 추출해서 SELECT
#         MAX(SIZE_OF_COLONY) AS MAX_SIZE
#     FROM ECOLI_DATA
#     GROUP BY YEAR(DIFFERENTIATION_DATE)   -- 연도별로 그룹화
# )
# SELECT * FROM yearMax;
# select year, as year_dev, id
# from date_format(ecoli_data.differentiation_date, %Y)
