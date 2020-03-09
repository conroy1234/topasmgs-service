package org.tms.mgm.sys.torPasMgsservice.repository;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tms.mgm.sys.torPasMgsservice.model.Pass;

@Repository
@NamedQuery(name = "findByPassNo",  query = "from pass where passNo = :passNo")
public interface PassRepository extends JpaRepository<Pass, Long> {
	public Pass findByPassNo(String passNo);
}
