package org.tms.mgm.sys.torPasMgsservice.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.mgm.sys.torPasMgsservice.constants.ApiConstants;
import org.tms.mgm.sys.torPasMgsservice.exception.BadRequestException;
import org.tms.mgm.sys.torPasMgsservice.model.Pass;
import org.tms.mgm.sys.torPasMgsservice.repository.PassRepository;

@Service
public class PassService implements ApiConstants {

	private Logger logger = LoggerFactory.getLogger(PassService.class);

	@Autowired
	PassRepository passRepository;

	public List<Pass> fingAllPassess() {
		return passRepository.findAll();
	}

	public Pass savePass(Pass pass) {
		pass.setCustomerNo(UUID.randomUUID().toString());
		logger.info(" pass has saved >> " + pass);
		return passRepository.save(pass);
	}

	public Pass fingById(long id) {

		return passRepository.findById(id).get();
	}

	public Pass remove(Pass pass, String passNo) {
		passRepository.delete(pass);
		if (pass.isActive(pass.getPassActive())) {
			throw new BadRequestException(VALID_PASS_CANNOT_BE_DELETED);
		}
		logger.info(" pass with pess number " + passNo + " has been removed  >> " + pass);
		return pass;
	}

	public Pass findByPassNo(String passNo) {
		return passRepository.findByPassNo(passNo);
	}

	public Pass updatePass(Pass pass) {
		Pass entity = passRepository.findByPassNo(pass.getPassNo());
		if (entity.getId() != pass.getId()) {
			entity.setId(pass.getId());
			entity.setCustomerNo(pass.getCustomerNo());
			entity.setCity(pass.getCity());
			entity.setExpiraryDate(pass.getExpiraryDate());
			entity.setPassActive(pass.getPassActive());
			entity.setPassNo(pass.getPassNo());
			System.out.println("pass >>>>>>>> " + entity);
		}
		if (!pass.isActive(pass.getPassActive())) {
			pass.setCustomerNo(UUID.randomUUID().toString());
			passRepository.save(pass);
			logger.info(" pass with pass numebr " + pass.getPassNo() + " has been renewed >> " + pass);
		} else {
			throw new BadRequestException(VALID_PASS_CANNOT_BE_DELETED);
		}
		return pass;
	}
}
