package org.tms.mgm.sys.torPasMgsservice.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tms.mgm.sys.torPasMgsservice.exception.ResourceNotFoundException;
import org.tms.mgm.sys.torPasMgsservice.model.Pass;
import org.tms.mgm.sys.torPasMgsservice.service.CustomerService;
import org.tms.mgm.sys.torPasMgsservice.service.PassService;

@RestController
@RequestMapping("/")
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	PassService passService;

	@Autowired
	CustomerService customerService;
    

	@GetMapping( path="api/topas/mgm/v1",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Pass> findAllPasses() {
		List<Pass> passes = passService.fingAllPassess();
		logger.info(" return all passes >> "+passes);
		if (passes == null) {
			throw new ResourceNotFoundException("resource not found =" + passes);
		}
		return new ResponseEntity(passes, HttpStatus.OK);

	}

	@GetMapping(path = "api/topas/mgm/v1/{passNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pass findByPassNum(@PathVariable String passNo) {
		Pass pass = passService.findByPassNo(passNo);
		logger.info(" find by id "+passNo +" >> "+pass);
		if (pass == null) {
			throw new ResourceNotFoundException("resource not found =" + passNo);
		}
		return pass;
	}

	@PostMapping(path="api/topas/mgm/v1/",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pass> saveOnePass(@RequestBody Pass pass) {
		Pass save = passService.savePass(pass);
		logger.info( pass +" fhas saved >> ");
		if (save == null) {
			throw new ResourceNotFoundException("resource not found =" + pass);
		}
		return new ResponseEntity<Pass>(save, HttpStatus.CREATED);
	}

	@PutMapping(path = "api/topas/mgm/v1/{passNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pass> updateOnePass(@RequestBody Pass pass, @PathVariable(value = "passNo") String passNo) {
		Pass save = passService.updatePass(pass);
		logger.info( pass +" fhas saved >> ");
		if (save == null) {
			throw new ResourceNotFoundException("resource not found =" + pass.getPassNo());
		}
		return new ResponseEntity<Pass>(save, HttpStatus.OK);
	}
	
	@PostMapping(path = "api/topas/mgm/v1/{passNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pass> updateOnePassPost(@RequestBody Pass pass, @PathVariable(value = "passNo") String passNo) {
		Pass save = passService.updatePass(pass);
		logger.info( pass +" fhas updated >> ");
		if (save == null) {
			throw new ResourceNotFoundException("resource not found =" + pass.getPassNo());
		}
		return new ResponseEntity<Pass>(save, HttpStatus.OK);
	}
	

	@DeleteMapping(path = "api/topas/mgm/v1/{passNo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteOnePass(@RequestBody Pass pass, @PathVariable(value = "passNo") String passNo) {
		passService.remove(pass, passNo);
		logger.info( pass +" with passNumber >> "+passNo+ "  has been deleted  ");

	}

}
