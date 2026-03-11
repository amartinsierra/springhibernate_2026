package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private int idItem;
	private String url;
	private String tematica;
	private String descripcion;

	public ItemDto(String url, String tematica, String descripcion) {
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}

}
