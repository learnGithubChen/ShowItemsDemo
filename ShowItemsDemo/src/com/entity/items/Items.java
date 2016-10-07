package com.entity.items;

public class Items {
	private int id;// ��Ʒ���
	private String name;// ��Ʒ����
	private String city;// ����

	private int price;// ��Ʒ�۸�
	private int number;// ���
	private String picture;// ���ͼƬ

	public Items() {
	}

	public Items(int id, String name, String city, int price, int number,
			String picture) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Items) {
			Items it = (Items) obj;
			if (this.getId() == it.getId()) {
				return true;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id + this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "��Ʒ����:" + this.getName() + ",��Ʒ���:" + this.getId();
	}

}
