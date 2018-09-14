package com.sanqing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sanqing.bean.Commodity;
import com.sanqing.util.DBConnection;

public class CommodityDAOImpl implements CommodityDAO {
	// 实现添加商品的方法
	/* (non-Javadoc)
	 * @see com.sanqing.dao.CommodityDAO#addCommodity(com.sanqing.bean.Commodity)
	 */
	@Override
	public void addCommodity(Commodity commodity) {
		Connection conn = (Connection) DBConnection.getConnection(); // 获得连接对象
		String addSQL = "insert into commodity(name,price) values(?,?)";
		PreparedStatement pstmt = null; // 声明预处理对象
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(addSQL); // 获得预处理对象并赋值
			pstmt.setString(1, commodity.getName()); // 设置第一个参数
			pstmt.setDouble(2, commodity.getPrice()); // 设置第二个参数

			pstmt.executeUpdate(); // 执行更新
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt); // 关闭预处理对象
			DBConnection.close(conn); // 关闭连接对象
		}
	}
	// 实现更新商品的方法
		/* (non-Javadoc)
		 * @see com.sanqing.dao.CommodityDAO#updateCommodity(com.sanqing.bean.Commodity)
		 */
		@Override
		public void updateCommodity(Commodity commodity) {
			Connection conn = (Connection) DBConnection.getConnection(); // 获得连接对象
			String updateSQL = "update commodity set ?=? where ?=?)";
			PreparedStatement pstmt = null; // 声明预处理对象
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(updateSQL); // 获得预处理对象并赋值
				pstmt.setString(1, "price"); // 设置第一个参数
				pstmt.setDouble(2, 350.00); // 设置第二个参数
				pstmt.setString(3, "name"); // 设置第三个参数
				pstmt.setString(4, "电视机"); // 设置第四个参数
				pstmt.executeUpdate(); // 执行更新
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(pstmt); // 关闭预处理对象
				DBConnection.close(conn); // 关闭连接对象
			}
		}
		// 实现删除商品的方法
				/* (non-Javadoc)
				 * @see com.sanqing.dao.CommodityDAO#deleteCommodity(com.sanqing.bean.Commodity)
				 */
				@Override
				public void deleteCommodity(Commodity commodity) {
					Connection conn = (Connection) DBConnection.getConnection(); // 获得连接对象
					String deleteSQL = "delete * commodity where ?=?)";
					PreparedStatement pstmt = null; // 声明预处理对象
					try {
						pstmt = (PreparedStatement) conn.prepareStatement(deleteSQL); // 获得预处理对象并赋值
						pstmt.setString(1, "name"); // 设置第一个参数
						pstmt.setString(2, "电视机"); // 设置第二个参数
						pstmt.executeUpdate(); // 执行更新
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						DBConnection.close(pstmt); // 关闭预处理对象
						DBConnection.close(conn); // 关闭连接对象
					}
				}
				
				public  List<Commodity>  findAllCommodity() {
					 List<Commodity> newsList=new ArrayList<Commodity>();
					 
					 Connection conn = (Connection) DBConnection.getConnection();
					 String findallSQL = "select * form shop";
					 PreparedStatement pstmt = null;
					 try {
						 pstmt = (PreparedStatement) conn.prepareStatement(findallSQL); 
						 ResultSet rs = pstmt.executeQuery();
						 while (rs!=null && rs.next()) {
							Commodity news=new Commodity(); 
							news.setName(rs.getString("name"));
							news.setPrice(rs.getDouble("price"));
							newsList.add(news);
							}
						 return newsList; 
					 }catch (SQLException e) {
							e.printStackTrace();
							return null;
						} finally {
							DBConnection.close(pstmt);  // 关闭预处理对象
							DBConnection.close(conn); // 关闭连接对象
						}
					 
				}
}
