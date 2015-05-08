package com.example.a01034348_lab_sqlite;

public class Pelicula {
	private int id;
	private String name;
	private int ranking;
	
	public Pelicula(){
		
	}
	public Pelicula(int id, String name, int ranking){
		this.id=id;
		this.name=name;
		this.ranking=ranking;
	}
	public Pelicula(String name, int ranking){
		this.name=name;
		this.ranking=ranking;
	}
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setRanking(int ranking){
		this.ranking=ranking;
	}
	public int getRanking(){
		return this.ranking;
	}

}
