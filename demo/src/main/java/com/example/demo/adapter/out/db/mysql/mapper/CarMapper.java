package com.example.demo.adapter.out.db.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.adapter.out.db.mysql.Car;

@Mapper
public interface CarMapper {
	void insertCar(Car car);
	List<Car> selectCar();
}
