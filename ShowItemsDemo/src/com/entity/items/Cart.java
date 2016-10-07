package com.entity.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 购物车类主要实现添加商品，删除商品以及计算商品总金额
 */
public class Cart {
	private HashMap<Items, Integer> goods;// 用来存储商品
	private double price;// 统计购物车里所有商品总金额

	public Cart() {
		goods = new HashMap<Items, Integer>();
		price = 0.0;
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// 添加商品进购物车
	public boolean addGoodsToCart(Items item, int number) {
		if (goods.containsKey(item)) {// 查看购物车里是否已经存在该种商品
			goods.put(item, goods.get(item) + number);// 如果存在则和原来的数量相加
		} else {
			goods.put(item, number);
		}
		getTotalPrice();
		return true;
	}

	// 删除购物车的某种商品
	public boolean deleteGoodsFromCart(Items item) {
		goods.remove(item);
		getTotalPrice();
		return true;
	}

	// 计算购物车商品的总金额
	public double getTotalPrice() {
		double sum = 0.0;
		Set<Items> set = goods.keySet();
		Iterator<Items> it = set.iterator();
		while (it.hasNext()) {
			Items item = it.next();
			sum += item.getPrice() * goods.get(item);
		}
		this.setPrice(sum);
		return this.getPrice();
	}

	public static void main(String[] args) {
		Items item1 = new Items(1, "沃特篮球鞋", "佛山", 180, 500, "001.jpg");
		Items item2 = new Items(2, "安踏运动鞋", "福州", 120, 800, "002.jpg");
		Items item3 = new Items(1, "沃特篮球鞋", "佛山", 180, 500, "001.jpg");
		Cart cart = new Cart();
		cart.addGoodsToCart(item1, 2);
		cart.addGoodsToCart(item2, 4);
		cart.addGoodsToCart(item3, 12);
		Set<Items> set = cart.getGoods().keySet();
		Iterator<Items> iterator = set.iterator();
		while (iterator.hasNext()) {
			Items it = iterator.next();
			System.out.println("商品编号为:" + it.getId() + " ,的商品" + "数量为:"+cart.getGoods().get(it));
		}
		System.out.println("商品总金额为:" + cart.getPrice());
	}
}
