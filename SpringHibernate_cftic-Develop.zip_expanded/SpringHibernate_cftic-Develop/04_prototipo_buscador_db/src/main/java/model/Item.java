package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_item",nullable=false)
	private int id_item;
	
	@Column(name="url")
	private String url;
	
	@Column(name="tematica")
	private String tematica;
	
	@Column(name="descripcion")
	private String descripcion;

	
	public Item() {
		
	}
	public Item(int id_item, String url, String tematica, String descripcion) {
		super();
		this.id_item = id_item;
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	public Item(String url, String tematica, String descripcion) {
		super();
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
	

}
