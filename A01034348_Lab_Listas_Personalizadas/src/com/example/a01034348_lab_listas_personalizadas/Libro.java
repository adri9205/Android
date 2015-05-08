package com.example.a01034348_lab_listas_personalizadas;

public class Libro {
	
public String titulo;
public String isbn;
public String fecha_publicacion;

public Libro(){
	
	super();
}
public Libro (String titulo, String isbn, String fecha_publicacion)
{
	this.titulo=titulo;
	this.isbn=isbn;
	this.fecha_publicacion=fecha_publicacion;

}

public String getTitulo(){
	return titulo;
}

public String getFecha_publicacion(){
	return fecha_publicacion;
}

public String getIsbn(){
	return isbn;
	
}

public void setTitulo(String titulo){
	this.titulo=titulo;
}

public void setIsbn(String isbn){
	this.isbn=isbn;
}

public void setFecha_publicacion(String fecha_publicacion){
	this.fecha_publicacion=fecha_publicacion;
}

}
