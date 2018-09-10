package apl.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FAMILY database table.
 * 
 */
@Embeddable
public class FamilyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String man;

	private String woman;

	public FamilyPK() {
	}
	public String getMan() {
		return this.man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	public String getWoman() {
		return this.woman;
	}
	public void setWoman(String woman) {
		this.woman = woman;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FamilyPK)) {
			return false;
		}
		FamilyPK castOther = (FamilyPK)other;
		return 
			this.man.equals(castOther.man)
			&& this.woman.equals(castOther.woman);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.man.hashCode();
		hash = hash * prime + this.woman.hashCode();
		
		return hash;
	}
}