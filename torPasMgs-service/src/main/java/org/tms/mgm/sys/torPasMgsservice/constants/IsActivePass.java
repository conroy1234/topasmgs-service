package org.tms.mgm.sys.torPasMgsservice.constants;

import javax.persistence.Embeddable;

@Embeddable
public enum IsActivePass {
	
YES("YES"),NO("NO");

String value;
	
	IsActivePass(String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
