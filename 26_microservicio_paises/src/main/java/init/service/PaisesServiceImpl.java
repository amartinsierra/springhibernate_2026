package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.clients.CountriesFeign;
import init.dtos.PaisDto;
import init.mappers.Mapeador;
@Service
public class PaisesServiceImpl implements PaisesService {
	@Autowired
	Mapeador mapeador;
	@Autowired
	CountriesFeign countriesFeign;
	@Override
	public List<String> continentes() {
		return countriesFeign.paises().stream()
				.map(c->c.getRegion())
				.distinct()
				.toList();
	}

	@Override
	public List<PaisDto> paisesPorContinente(String continente) {
		return countriesFeign.paises().stream()
				.map(c->mapeador.countryToPais(c))//Stream<PaisDto>
				.filter(p->p.getContinente().equals(continente))
				.toList();
	}

}
