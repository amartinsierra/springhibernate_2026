package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.model.Tema;
import init.repository.TemaRepository;

@Service
public class TemaServiceImpl implements TemaService{

	@Autowired
	private TemaRepository temaRepository;
	
	public List<Tema> findThemes() {
		return temaRepository.findAll();
	}

}
