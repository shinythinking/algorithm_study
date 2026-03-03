-- 코드를 입력하세요
SELECT PRODUCT_ID,	PRODUCT_NAME,	PRODUCT_CD,	CATEGORY,	PRICE
From food_product
where price = (
    select max(price)
    from food_product
)