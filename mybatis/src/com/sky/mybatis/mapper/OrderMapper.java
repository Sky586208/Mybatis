package com.sky.mybatis.mapper;

import java.util.List;

import com.sky.mybatis.pojo.Orders;

public interface OrderMapper {

	//��ѯ������������
	public List<Orders> selectOrderList();
}
