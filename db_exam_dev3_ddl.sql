-- Project Name : noname
-- Date/Time    : 2020/08/20 13:58:16
-- Author       : axiz
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- 商品
--* RestoreFromTempTable
create table product (
  product_id integer not null
  , product_name character varying(50)
  , price numeric
) ;

create unique index product_PKI
  on product(product_id);

alter table product
  add constraint product_PKC primary key (product_id);

-- 売上
--* RestoreFromTempTable
create table sales (
  sales_id integer not null
  , store_id integer not null
  , sales_date timestamp(6) without time zone
  , amount numeric
) ;

create unique index sales_PKI
  on sales(sales_id);

alter table sales
  add constraint sales_PKC primary key (sales_id);

-- 売上明細
--* RestoreFromTempTable
create table sales_details (
  sales_id integer not null
  , sales_detail_id integer not null
  , product_id integer not null
  , quantity integer
  , amount numeric
) ;

create unique index sales_details_PKI
  on sales_details(sales_id,sales_detail_id);

alter table sales_details
  add constraint sales_details_PKC primary key (sales_id,sales_detail_id);

-- 店舗
--* RestoreFromTempTable
create table store (
  store_id integer not null
  , store_name character varying(50)
  , postal_code character varying(10)
  , address character varying(60)
) ;

create unique index store_PKI
  on store(store_id);

alter table store
  add constraint store_PKC primary key (store_id);

comment on table product is '商品';
comment on column product.product_id is '商品番号';
comment on column product.product_name is '商品名';
comment on column product.price is '販売単価';

comment on table sales is '売上';
comment on column sales.sales_id is '売上番号';
comment on column sales.store_id is '店舗番号';
comment on column sales.sales_date is '売上日時';
comment on column sales.amount is '売上合計金額';

comment on table sales_details is '売上明細';
comment on column sales_details.sales_id is '売上番号';
comment on column sales_details.sales_detail_id is '売上明細番号';
comment on column sales_details.product_id is '商品番号';
comment on column sales_details.quantity is '売上数量';
comment on column sales_details.amount is '売上金額';

comment on table store is '店舗';
comment on column store.store_id is '店舗番号';
comment on column store.store_name is '店舗名';
comment on column store.postal_code is '郵便番号';
comment on column store.address is '住所';

