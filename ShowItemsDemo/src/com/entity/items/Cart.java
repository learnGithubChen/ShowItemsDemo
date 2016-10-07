package com.entity.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * ���ﳵ����Ҫʵ�������Ʒ��ɾ����Ʒ�Լ�������Ʒ�ܽ��
 */
public class Cart {
	private HashMap<Items, Integer> goods;// �����洢��Ʒ
	private double price;// ͳ�ƹ��ﳵ��������Ʒ�ܽ��

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

	// �����Ʒ�����ﳵ
	public boolean addGoodsToCart(Items item, int number) {
		if (goods.containsKey(item)) {// �鿴���ﳵ���Ƿ��Ѿ����ڸ�����Ʒ
			goods.put(item, goods.get(item) + number);// ����������ԭ�����������
		} else {
			goods.put(item, number);
		}
		getTotalPrice();
		return true;
	}

	// ɾ�����ﳵ��ĳ����Ʒ
	public boolean deleteGoodsFromCart(Items item) {
		goods.remove(item);
		getTotalPrice();
		return true;
	}

	// ���㹺�ﳵ��Ʒ���ܽ��
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
		Items item1 = new Items(1, "��������Ь", "��ɽ", 180, 500, "001.jpg");
		Items item2 = new Items(2, "��̤�˶�Ь", "����", 120, 800, "002.jpg");
		Items item3 = new Items(1, "��������Ь", "��ɽ", 180, 500, "001.jpg");
		Cart cart = new Cart();
		cart.addGoodsToCart(item1, 2);
		cart.addGoodsToCart(item2, 4);
		cart.addGoodsToCart(item3, 12);
		Set<Items> set = cart.getGoods().keySet();
		Iterator<Items> iterator = set.iterator();
		while (iterator.hasNext()) {
			Items it = iterator.next();
			System.out.println("��Ʒ���Ϊ:" + it.getId() + " ,����Ʒ" + "����Ϊ:"+cart.getGoods().get(it));
		}
		System.out.println("��Ʒ�ܽ��Ϊ:" + cart.getPrice());
	}
}
