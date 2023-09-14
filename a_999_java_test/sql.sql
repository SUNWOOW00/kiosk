select * from tbl_product_master;

create table tbl_product_master(
	pdt_id 				number(5) primary key,
	pdt_id_name 		varchar2(30),
	pdt_unit_price 		number(7),
	pdt_order_method 	number(1)
);

create table tbl_order_list(
    ord_no                        number(5),
    ord_count                    number(3),
    ord_pdt_id                    number(5),
    ord_buying_count            number(3),
    ord_pdt_unit_price        number(7),
    ord_price                    number(9),
    primary key  (ord_no,ord_count)
)

create table tbl_order_total(
    tot_ord_no             number(5) primary key,
    tot_ord_price         number(9),
    tot_buying_method         number(1),
    tot_in_money         number(7),
    tot_out_money         number(7),
    tot_system_date         date
);

select * from tbl_order_list;
select * from tbl_order_total;