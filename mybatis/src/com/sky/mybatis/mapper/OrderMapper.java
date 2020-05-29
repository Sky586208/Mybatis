package com.sky.mybatis.mapper;

import java.util.List;

import com.sky.mybatis.pojo.Orders;

public interface OrderMapper {

	//查询订单所有数据
	public List<Orders> selectOrderList();
}
