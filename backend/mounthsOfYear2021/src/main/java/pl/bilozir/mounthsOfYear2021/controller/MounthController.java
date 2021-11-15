package pl.bilozir.mounthsOfYear2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.bilozir.mounthsOfYear2021.domain.Mounth;
import pl.bilozir.mounthsOfYear2021.service.MounthService;


@RestController
@RequestMapping("/mounths")
public class MounthController {
	
	@Autowired
	private final MounthService mounthService;
	
	public MounthController(MounthService mounthService) {
		this.mounthService = mounthService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Mounth>> findAllMounths() {
		List<Mounth> mounths = mounthService.findAllMounths();
		return new ResponseEntity<>(mounths, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Mounth> getMounthById(@PathVariable("id") Long id) {
		Mounth mounth = mounthService.getById(id);
		return new ResponseEntity<>(mounth, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Mounth> addMounth(@RequestBody Mounth mounth) {
		Mounth newMounth = mounthService.addMounth(mounth.getName(), mounth.getNumber());
		return new ResponseEntity<>(newMounth, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Mounth> updateMounth(@RequestBody Mounth mounth) {
		Mounth updateMounth = mounthService.updateMounth(mounth);
		return new ResponseEntity<>(updateMounth, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMounth(@PathVariable("id") Long id) {
		mounthService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
}
