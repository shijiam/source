package com.sanqing.test;
import com.sanqing.bean.Commodity;
import com.sanqing.dao.CommodityDAO;
import com.sanqing.factory.CommodityDAOFactory;
public class Test {
	public static void main(String[] args) {
		CommodityDAO commodityDAOImpl =
		CommodityDAOFactory.createCommodityDAOImpl();
		Commodity commodity = new Commodity();
		commodity.setName("food");
		commodity.setPrice(58.50);
		commodityDAOImpl.addCommodity(commodity);
		}
}
