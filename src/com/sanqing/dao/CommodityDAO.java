package com.sanqing.dao;

import java.util.List;

import com.sanqing.bean.Commodity;

public interface CommodityDAO {

	// 实现添加商品的方法
	void addCommodity(Commodity commodity);

	// 实现更新商品的方法
	void updateCommodity(Commodity commodity);

	// 实现删除商品的方法
	void deleteCommodity(Commodity commodity);
	
	public abstract List<Commodity> findAllCommodity();

}