-- ��Ŀ
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '��Ŀ����',
    `category_type` int not null comment '��Ŀ���',
    `create_time` timestamp not null default current_timestamp comment '����ʱ��',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '�޸�ʱ��',
    primary key (`category_id`),
    UNIQUE KEY `uqe_category_type` (`category_type`)
);

-- ��Ʒ
create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '��Ʒ����',
    `product_price` decimal(8,2) not null comment '����',
    `product_stock` int not null comment '���',
    `product_description` varchar(64) comment '����',
    `product_icon` varchar(512) comment 'Сͼ',
    `product_status` tinyint(3) DEFAULT '0' COMMENT '��Ʒ״̬,0����1�¼�',
    `category_type` int not null comment '��Ŀ���',
    `create_time` timestamp not null default current_timestamp comment '����ʱ��',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '�޸�ʱ��',
    primary key (`product_id`)
);

-- ����
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '�������',
    `buyer_phone` varchar(32) not null comment '��ҵ绰',
    `buyer_address` varchar(128) not null comment '��ҵ�ַ',
    `buyer_openid` varchar(64) not null comment '���΢��openid',
    `order_amount` decimal(8,2) not null comment '�����ܽ��',
    `order_status` tinyint(3) not null default '0' comment '����״̬, Ĭ��Ϊ���µ�',
    `pay_status` tinyint(3) not null default '0' comment '֧��״̬, Ĭ��δ֧��',
    `create_time` timestamp not null default current_timestamp comment '����ʱ��',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '�޸�ʱ��',
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

-- ������Ʒ
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '��Ʒ����',
    `product_price` decimal(8,2) not null comment '��ǰ�۸�,��λ��',
    `product_quantity` int not null comment '����',
    `product_icon` varchar(512) comment 'Сͼ',
    `create_time` timestamp not null default current_timestamp comment '����ʱ��',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '�޸�ʱ��',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

-- ����(��¼��̨ʹ��, ���ҵ�¼֮�����ֱ�Ӳ���΢��ɨ���¼����ʹ���˺�����)
create table `seller_info` (
    `seller_id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment '΢��openid',
    `create_time` timestamp not null default current_timestamp comment '����ʱ��',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '�޸�ʱ��',
    primary key (`seller_id`)
) comment '������Ϣ��';