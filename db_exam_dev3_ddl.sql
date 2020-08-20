-- Project Name : noname
-- Date/Time    : 2020/08/20 13:58:16
-- Author       : axiz
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable�^�����߂��t������Ă��܂��B
  ����ɂ��Adrop table, create table ����f�[�^���c��܂��B
  ���̋@�\�͈ꎞ�I�� $$TableName �̂悤�Ȉꎞ�e�[�u�����쐬���܂��B
*/

-- ���i
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

-- ����
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

-- ���㖾��
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

-- �X��
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

comment on table product is '���i';
comment on column product.product_id is '���i�ԍ�';
comment on column product.product_name is '���i��';
comment on column product.price is '�̔��P��';

comment on table sales is '����';
comment on column sales.sales_id is '����ԍ�';
comment on column sales.store_id is '�X�ܔԍ�';
comment on column sales.sales_date is '�������';
comment on column sales.amount is '���㍇�v���z';

comment on table sales_details is '���㖾��';
comment on column sales_details.sales_id is '����ԍ�';
comment on column sales_details.sales_detail_id is '���㖾�הԍ�';
comment on column sales_details.product_id is '���i�ԍ�';
comment on column sales_details.quantity is '���㐔��';
comment on column sales_details.amount is '������z';

comment on table store is '�X��';
comment on column store.store_id is '�X�ܔԍ�';
comment on column store.store_name is '�X�ܖ�';
comment on column store.postal_code is '�X�֔ԍ�';
comment on column store.address is '�Z��';

