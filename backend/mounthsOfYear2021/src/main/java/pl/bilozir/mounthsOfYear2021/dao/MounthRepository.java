package pl.bilozir.mounthsOfYear2021.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.bilozir.mounthsOfYear2021.domain.Mounth;


@Transactional
@Repository
public interface MounthRepository extends JpaRepository<Mounth, Long>, CrudRepository<Mounth, Long>{
	

}