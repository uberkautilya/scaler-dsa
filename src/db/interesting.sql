-- Todo: Identify what this query does
select c.customer_id
from (
    select GROUP_CONCAT(product_key) products from product order by product_key
) p, (
    select t.customer_id, GROUP_CONCAT(distinct t.product_key) products from (
        select customer_id, product_key from customer c order by product_key
    ) t group by t.customer_id
) c 
where p.products = c.products;