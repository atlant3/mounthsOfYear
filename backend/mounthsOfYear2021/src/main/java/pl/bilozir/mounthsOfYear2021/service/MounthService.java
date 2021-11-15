package pl.bilozir.mounthsOfYear2021.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bilozir.mounthsOfYear2021.dao.MounthRepository;
import pl.bilozir.mounthsOfYear2021.domain.Mounth;


@Service
public class MounthService {

	@Autowired
	private MounthRepository mounthRepository;
	
	public MounthService(MounthRepository mounthRepository) {
		this.mounthRepository = mounthRepository;
	}

	public Mounth addMounth(String name, int number) {
		Mounth mounth = new Mounth(number, name, true);
		return mounthRepository.save(mounth);
	}
	
	public Mounth updateMounth(Mounth mounth) {
		return mounthRepository.save(mounth);
		
	}

	public List<Mounth> findAllMounths() {
		return mounthRepository.findAll();
	}

	public Mounth getById(Long id) {
		System.out.println("finf");
		return mounthRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		Mounth m = mounthRepository.getById(id);
		m.setActive(false);
		mounthRepository.save(m);
	}

	@PostConstruct
	public void init() throws IOException {
		Mounth m1 = new Mounth(4, "April", true);
		Mounth m2 = new Mounth(5, "May", true);
		Mounth m3 = new Mounth(12, "December", false);
		mounthRepository.save(m1);
		mounthRepository.save(m2);
		mounthRepository.save(m3);

	}
}
