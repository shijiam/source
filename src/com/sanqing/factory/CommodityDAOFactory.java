package com.sanqing.factory;
import com.sanqing.dao.CommodityDAO;
import com.sanqing.dao.CommodityDAOImpl;
public class CommodityDAOFactory {
	public static CommodityDAO createCommodityDAOImpl() {
		return new CommodityDAOImpl();
	}
}
