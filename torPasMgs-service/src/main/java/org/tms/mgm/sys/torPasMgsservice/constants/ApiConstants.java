package org.tms.mgm.sys.torPasMgsservice.constants;

import java.util.UUID;

public interface ApiConstants {

	String VALID_PASS_CANNOT_BE_DELETED = "you cannot delete a valid pass";
	String ACTIVE_PASS = IsActivePass.YES.toString();
	String INACTIVE_PASS = IsActivePass.NO.toString();
	String RONDOMLY_GENERATED_ID = UUID.randomUUID().toString();
	String RONDOMLY_GENERATED_ID1 = UUID.randomUUID().toString();
	String RONDOMLY_GENERATED_ID2 = UUID.randomUUID().toString();
	String[] LIST_OF_CUSTOMER_NAMES = { "James Moley", "Thomas Cook", "Steve Jobs" };

}
