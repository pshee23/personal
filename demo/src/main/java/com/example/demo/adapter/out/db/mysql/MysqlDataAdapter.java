package com.example.demo.adapter.out.db.mysql;

import org.springframework.stereotype.Repository;

import com.example.demo.adapter.out.db.mysql.mapper.CarMapper;
import com.example.demo.application.port.out.RDBDataPort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MysqlDataAdapter implements RDBDataPort {
	
	private final CarMapper carMapper;
	
	@Override
	public void insertTestData() {
		Car car = new Car();
		car.setCarId(123);
		car.setCarName("asdasd");
		carMapper.insertCar(car);
	}

	@Override
	public void selectTestData() {
		System.out.print(carMapper.selectCar());
	}
	
}
