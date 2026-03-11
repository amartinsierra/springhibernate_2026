package init.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idItem",nullable=false)
	private int idItem;
	
	@Column(name="url")
	private String url;
	
	@Column(name="tematica")
	private String tematica;
	
	@Column(name="descripcion")
	private String descripcion;


	public Item(String url, String tematica, String descripcion) {
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	
	
}
