package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.TemaDto;
import init.mapper.Mappeador;
import init.repository.TemaRepository;

@Service
public class TemaServiceImpl implements TemaService{

	@Autowired
	private TemaRepository temaRepository;
	
	@Autowired
	private Mappeador mappeador;
	
	public List<TemaDto> findThemes() {
		return temaRepository.findAll().stream().map(t -> mappeador.entityTemaToDto(t)).toList();
	}

}
