/* �f�[�^�쐬�pSQL */

-- �X��
INSERT INTO store (store_id, store_name, postal_code, address) VALUES
	(1, '�p�[���[�Ă��̂���', '103-0024', '�����s��������{�����`�n��13-1'),
	(2, '�ʎ���AxiZ', '160-0005', '�����s�V�h�戤�Z��1-1 AxiZ�r��'),
	(3, 'fruits-technocore', '170-0011', '�����s�L����r�ܖ{��5-1')
;

--- ���i
INSERT INTO product (product_id, product_name, price) VALUES
	(1, '���', 150),
	(2, '�Ԃǂ�', 250),
	(3, '����', 300)
;
-- ����
INSERT INTO sales (sales_id, store_id, sales_date, amount) VALUES
	(1, 1, '2020/03/01 16:01:05', 3250),
	(2, 2, '2020/03/02 10:50:00', 10600),
	(3, 3, '2020/03/02 11:11:15', 30000),
	(4, 1, '2020/03/05 14:20:52', 24500),
	(5, 2, '2020/03/05 15:30:20', 8350)
;

-- ���㖾��
INSERT INTO sales_details (sales_id, sales_detail_id, product_id, quantity, amount) VALUES
	(1, 1, 1, 5, 750),
	(1, 2, 2, 10, 2500),
	(2, 1, 1, 4, 600),
	(2, 2, 2, 16, 4000),
	(2, 3, 3, 20, 6000),
	(3, 1, 3, 100, 30000),
	(4, 1, 1, 10, 1500),
	(4, 2, 2, 20, 5000),
	(4, 3, 3, 60, 18000),
	(5, 1, 2, 1, 250),
	(5, 2, 3, 27, 8100)
;


