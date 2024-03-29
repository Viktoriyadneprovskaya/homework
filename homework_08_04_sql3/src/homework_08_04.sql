--#1 List the top 10 customers with the highest total order value for orders placed in the last month, including their name, email, and total order value.
-- #2 List return the top 5 most viewed products on the website, including their name, price, and number of views.
-- #3 List return the total revenue generated by each salesperson in the company for the previous quarter, including their name and email.
-- #4 List return the top 3 customers who have placed orders for the most unique products, including their name, email, and number of unique products ordered.
-- #5 List return the list of all products that have not been ordered in the last month, including their name and price.
-- #6 List the top 5 customers with the highest total order amount and their corresponding salespeople's name.
-- #7 List the customers who have viewed all the products.
-- #8 List the products that have been viewed by all customers and the total number of times they have been viewed.
--#9 List the customers who have placed an order in every month of the year 2022
--Todo #10 List the salespeople who have at least two customers who have placed an order of the same product.


CREATE schema storage;

CREATE TABLE storage.customers
(
    ID    SERIAL NOT NULL primary key,
    name  varchar(50),
    email varchar(50)
);

CREATE TABLE storage.product
(
    ID    SERIAL NOT NULL primary key,
    name  varchar(50),
    price double precision
);

CREATE TABLE storage.salespersons
(
    ID    SERIAL NOT NULL primary key,
    name  varchar(50),
    email varchar(50)
);

CREATE TABLE storage.orders
(
    ID_order        SERIAL NOT NULL primary key,
    customer_id     int references storage.customers (ID),
    product_id      int references storage.product (ID),
    salespersons_id int references storage.salespersons (ID),
    quantity        int,
    unit_price      double precision,
    order_date      date
);

CREATE TABLE storage.product_view
(
    ID         SERIAL NOT NULL primary key,
    product_id int references storage.product (ID),
    view_date  date
);

insert into storage.customers (name, email)
values ('John', 'john@test.com'),
       ('Jane', 'jane@test.com'),
       ('Bob', 'bob@test.com');

insert into storage.salespersons(name, email)
values ('Jack', 'jack@test.com'),
       ('Jill', 'jill@test.com'),
       ('Sam', 'sam@test.com');

insert into storage.product(name, price)
values ('Apple', 1.00),
       ('Orange', 2.00),
       ('Banana', 0.50),
       ('Grape', 0.25);

insert into storage.orders(customer_id, product_id, salespersons_id, quantity, unit_price, order_date)
values (1, 1, 2, 1, 10.00, '2023-03-15'),
       (1, 2, 1, 2, 20.00, '2023-02-05'),
       (2, 3, 3, 3, 15.00, '2023-03-06'),
       (3, 4, 1, 1, 5.00, '2023-03-25'),
       (2, 3, 1, 1, 15.00, '2023-03-06'),
       (3, 4, 2, 3, 5.00, '2023-03-25');

insert into storage.product_view(product_id, view_date)
values (1, '2022-01-01'),
       (1, '2022-01-02'),
       (2, '2022-01-01'),
       (3, '2022-01-02'),
       (3, '2022-01-03'),
       (3, '2022-01-03'),
       (4, '2022-01-02'),
       (4, '2022-01-04'),
       (4, '2022-01-04');
------------------------------------------------------------------------------------------
ALTER TABLE storage.product_view
    ADD COLUMN customer_id int references storage.customers (ID);

UPDATE storage.product_view
SET customer_id = 1
WHERE ID = 1;
UPDATE storage.product_view
SET customer_id = 1
WHERE ID = 3;
UPDATE storage.product_view
SET customer_id = 1
WHERE ID = 4;
UPDATE storage.product_view
SET customer_id = 1
WHERE ID = 7;
UPDATE storage.product_view
SET customer_id = 2
WHERE ID = 2;
UPDATE storage.product_view
SET customer_id = 3
WHERE ID = 5;
UPDATE storage.product_view
SET customer_id = 2
WHERE ID = 6;
UPDATE storage.product_view
SET customer_id = 2
WHERE ID = 8;
UPDATE storage.product_view
SET customer_id = 3
WHERE ID = 9;

insert into storage.orders(customer_id, product_id, salespersons_id, quantity, unit_price, order_date)
values (2, 3, 1, 1, 10.00, '2023-03-15');
--#1
SELECT storage.orders.unit_price as the_highest_total_order_value,
       customers.name            as customer_name,
       customers.email           as customer_email
FROM storage.orders
         LEFT JOIN storage.customers on orders.customer_id = customers.ID
WHERE date_trunc('MONTH', order_date) = date_trunc('month', current_date - interval '1' month)
ORDER BY unit_price desc
LIMIT 10;

--#2
select quantity_view,
       storage.product.name  as product_name,
       storage.product.price as price
from (SELECT COUNT(product_id) as quantity_view,
             product_id
      FROM storage.product_view
      group by product_id) as Rez
         LEFT JOIN storage.product ON Rez.product_id = storage.product.ID
order by Rez.quantity_view desc
LIMIT 5;

select count(storage.product_view.product_id) as amount, storage.product.name, storage.product.price
from storage.product_view
         join storage.product on storage.product_view.product_id = storage.product.id
group by storage.product_view.product_id, storage.product.name, storage.product.price
order by amount desc
limit 5;


--#3
select s.name,
       s.email,
       res.revenue
from (SELECT sum(unit_price) as revenue, salespersons_id
      FROM "storage".orders
      where date_trunc('MONTH', storage.orders.order_date) = date_trunc('month', current_date - interval '1' month)
      group by salespersons_id) as res
         left join "storage".salespersons s on salespersons_id = s.id;
--#3 var.2
select storage.salespersons."name"
     , storage.salespersons.email
     , Sum(storage.orders.unit_price) as revenue
from storage.orders
         left join storage.salespersons on storage.orders.salespersons_id = storage.salespersons.id
where date_trunc('MONTH', storage.orders.order_date) = date_trunc('month', current_date - interval '1' month)
group by storage.salespersons."name"
       , storage.salespersons.email
order by revenue desc;

--#4
select c.name,
       c.email
        ,
       uni_goods.quantity
from (select storage.orders.product_id,
             storage.orders.customer_id   as customer_id,
             sum(storage.orders.quantity) as quantity
      FROM storage.orders
      Group by storage.orders.product_id,
               storage.orders.customer_id
      order by quantity
      limit 3) as uni_goods
         left join storage.customers c on c.id = uni_goods.customer_id
order by quantity;

--#5 var 1
select p.name,
       p.price
from (SELECT id
      FROM storage.product
      except
      select id
      from (SELECT product_id as id
            FROM storage.orders
            where date_trunc('MONTH', storage.orders.order_date) =
                  date_trunc('month', current_date - interval '1' month))
               as saled) as not_saled
         left join storage.product p on p.id = not_saled.id;
--#5 var 2
select p."name", p.price
from (SELECT product_id as id, storage.orders.quantity
      FROM storage.orders
      where date_trunc('MONTH', storage.orders.order_date) = date_trunc('month', current_date - interval '1' month))
         as sold
         full outer join "storage".product p on p.id = sold.id
where sold.quantity is null;
--#5 var 3
select "storage".product."name", "storage".product.price
from "storage".product
         left join "storage".orders on storage.product.id = storage.orders.product_id
    and date_trunc('MONTH', storage.orders.order_date) = date_trunc('month', current_date - interval '1' month)
where storage.orders.id_order is null;

-- #6
SELECT sp.name as salesman,
       c.name  as customer,
       res.orders_sum
FROM (SELECT SUM(storage.orders.unit_price) as orders_sum,
             customer_id,
             salespersons_id
      FROM storage.orders
      group by customer_id,
               salespersons_id
      LIMIT 5) as res
         LEFT JOIN storage.salespersons sp ON res.salespersons_id = sp.id
         left join storage.customers c on res.customer_id = c.id
Limit 5;
-- #7
select c.name, c.email
from (select distinct count(storage.product_view.product_id) as viewed
                    , storage.product_view.customer_id       as customer_id
      from storage.product_view
      group by storage.product_view.customer_id) as viewed_products
         left join storage.customers c on c.id = viewed_products.customer_id
where viewed_products.viewed = (select count(id)
                                from storage.product);
--#7 var 2
select storage.customers."name"
from "storage".customers
         inner join "storage".product_view on storage.customers.id = storage.product_view.customer_id
group by storage.customers."name"
having count(distinct "storage".product_view.product_id) = (select count(storage.product.id)
                                                            from "storage".product);

--#8
--var 1
SELECT storage.product."name", storage.product.id, count(distinct storage.product_view.customer_id) as q_views
from storage.product
         inner join "storage".product_view on storage.product_view.product_id = storage.product.id
group by storage.product."name", storage.product.id
having count(distinct storage.product_view.customer_id) = (select count(storage.customers.id) from "storage".customers);

--var 2
SELECT storage.product."name", sss.rrr
from "storage".product
         inner join (select storage.product_view.product_id
                          , count(storage.product_view.product_id) as rrr
                     from "storage".customers
                              inner join "storage".product_view
                                         on storage.product_view.customer_id = storage.customers.id
                     group by storage.product_view.product_id
                     having count(distinct storage.product_view.customer_id) = (select count(storage.customers.id)
                                                                                from "storage".customers)) as sss
                    on storage.product.id = sss.product_id;


--#9
select c."name", uni_orders
from (select count(res.order_month) as uni_orders
           , res.customer_id        as customer
      from (SELECT distinct customer_id, date_trunc('MONTH', order_date) as order_month--, count( date_trunc('MONTH',order_date))
            FROM "storage".orders
            where order_date between '2023-01-01' and '2023-12-31') as res
      group by res.customer_id) as orders_per_month
         left join storage.customers c on c.id = customer
where uni_orders = 12;

--#10
select s
from (select salespersons_id, q_goods, count(customer_id) as customer_count
      from (SELECT customer_id, product_id, sum(quantity) as q_goods, salespersons_id
            FROM "storage".orders
            group by customer_id, product_id, salespersons_id) as sold
      where q_goods > 1
      group by salespersons_id, q_goods) as sales_rate
         left join storage.salespersons s on s.id = sales_rate.salespersons_id
where customer_count > 1;


select name, email from storage.salespersons join (select storage.orders.salespersons_id from storage.orders
join (
select storage.orders.product_id
from storage.orders
group by storage.orders.product_id
having sum(storage.orders.customer_id) > 1) as ppp on orders.product_id = ppp.product_id
group by salespersons_id
having count(customer_id) > 1) rrr on storage.salespersons.id = rrr.salespersons_id;

--#11
select storage.customers.name, storage.customers.email, sum_quntity from storage.customers
inner join (select storage.orders.customer_id, sum(storage.orders.quantity) as sum_quntity
            from storage.orders
            where date_trunc('year',storage.orders.order_date) = date_trunc('YEAR',current_date)
            group by storage.orders.customer_id) amount ON amount.customer_id = storage.customers.ID
order by sum_quntity desc
limit 5;

--#12
select storage.product.name, sum_quntity from storage.product
inner join(select storage.orders.product_id, sum(storage.orders.quantity) as sum_quntity
        from storage.orders
        where date_trunc('year',storage.orders.order_date) = date_trunc('YEAR',current_date)
        group by storage.orders.product_id) amount ON amount.product_id=storage.product.ID
order by sum_quntity desc
limit 10;

--#13
select storage.product.name, sum_quntity from storage.product
inner join (select storage.orders.product_id, sum(storage.orders.quantity) as sum_quntity
            from storage.orders
            where date_trunc('month',storage.orders.order_date) = date_trunc('month',current_date - interval '1' month)
            group by storage.orders.product_id) amount ON amount.product_id=storage.product.ID
order by sum_quntity desc
limit 3;

--#14
ALTER TABLE storage.customers  ADD COLUMN data_reg date;

UPDATE storage.customers  SET data_reg = '2023-01-02' WHERE ID=1;
UPDATE storage.customers  SET data_reg = '2023-03-08' WHERE ID=2;
UPDATE storage.customers  SET data_reg = '2022-08-23' WHERE ID=3;

select storage.salespersons."name", storage.salespersons.email, revenue_sum
from "storage".salespersons
inner join
(select sum(storage.orders.unit_price) as revenue_sum, storage.orders.customer_id,storage.orders.salespersons_id
from "storage".orders
inner join "storage".customers on storage.customers.id  = storage.orders.customer_id
group by storage.orders.customer_id, storage.orders.salespersons_id,storage.customers.data_reg,storage.orders.order_date
having date_trunc('year',storage.customers.data_reg) = date_trunc('year',current_date - interval '1' year)
and date_trunc('quarter',storage.orders.order_date) = date_trunc('quarter',current_date - interval '3' month)) ppp on ppp.salespersons_id = storage.salespersons.id
order by revenue_sum desc
limit 5;

--#15
select storage.customers.name, storage.customers.email, average_order from storage.customers
inner join (select storage.orders.customer_id, AVG(storage.orders.unit_price) as average_order  from storage.orders
            where date_trunc('year',storage.orders.order_date) = date_trunc('YEAR',current_date)
            group by customer_id) ord_aver ON ord_aver.customer_id = storage.customers.ID
order by average_order desc
limit 10;


