package com.david.car.util;

public class test {
	public static void main(String[] args) throws Exception {
		BaseDataEntity row = new BaseDataEntity();
		BaseDataEntities rows = new BaseDataEntities();
		row.spsv("dwei", "26");
		rows.add(row);
		System.out.println(rows.get(0).gpsv("dwei"));
	}
}
