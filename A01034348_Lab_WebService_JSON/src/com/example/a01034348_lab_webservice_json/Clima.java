package com.example.a01034348_lab_webservice_json;

public class Clima {

	private double temp;
	private double temp_min;
	private double temp_max;
	
	public Clima(){
		super();
	}
	
	public Clima (double temp, double temp_min, double temp_max){
		this.temp=temp;
		this.temp_min=temp_min;
		this.temp_max=temp_max;
		
	}
	//Getters
	public double getTemp(){
		return temp;
	}
	
	public double getTemp_max(){
		return temp_max;
	}
	public double getTemp_min(){
		return temp_min;
	}
	
	//Setters
	public void setTemp(double temp){
		this.temp=temp;
	}
	
	public void setTemp_min(double temp_min){
		this.temp_min=temp_min;
	}
	public void setTemp_max(double temp_max){
		this.temp_max=temp_max;
	}
	
	
}
