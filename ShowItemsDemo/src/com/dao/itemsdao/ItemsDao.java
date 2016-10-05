package com.dao.itemsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.entity.items.Items;
import com.sql.util.DBHelper;

public class ItemsDao {
	/*
	 * 展示所有商品
	 */
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		String sql = "select * from items;";

		try {
			conn = DBHelper.getConnection();
			st = conn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setPrice(rs.getInt("price"));
				items.setNumber(rs.getInt("number"));
				items.setPicture(rs.getString("picture"));
				list.add(items);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 根据id获取单个商品的详细信息
	 */
	public Items getSingleItems(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from items where id=? ;";
		Items items = new Items();

		try {
			conn = DBHelper.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				items.setId(id);
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setPrice(rs.getInt("price"));
				items.setNumber(rs.getInt("number"));
				items.setPicture(rs.getString("picture"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	/*
	 * 获取浏览商品的前五条记录
	 */
	public ArrayList<Items> getLatestFive(String cookie) {

		String[] itemIds = cookie.split(",");
		ArrayList<Items> list = new ArrayList<Items>();
		int count = 0;// 统计商品个数
		if (itemIds.length <= 5) {
			for (int i = itemIds.length - 1; i >= 0; i--) {
				int id = Integer.parseInt(itemIds[i]);
				boolean isEqual = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getId() == id)
						isEqual = true;
				}
				if (!isEqual) {
					Items item = new Items();
					item = getSingleItems(id);
					list.add(item);
				}
			}
		} else {
			for (int i = itemIds.length - 1; i >= 0 && count <5; i--) {
				int id = Integer.parseInt(itemIds[i]);
				boolean isEqual = false;
				for (int j = 0; j < list.size(); j++) {
					if (id == list.get(j).getId())
						isEqual = true;
				}
				if (!isEqual) {
					Items item = new Items();
					item = getSingleItems(Integer.parseInt(itemIds[i]));
					list.add(item);
					count++;
				}
			}
		}
		return list;
	}
}
