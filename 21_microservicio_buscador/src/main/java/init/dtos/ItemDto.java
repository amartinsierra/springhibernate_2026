package init.dtos;

import init.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
	private String url;
	private String tematica;
	private String descripcion;
}
