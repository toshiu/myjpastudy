package apl.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAMILY database table.
 * 
 */
@Entity
@NamedQuery(name="Family.findAll", query="SELECT f FROM Family f")
public class Family implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FamilyPK id;

	private String address;

	public Family() {
	}

	public FamilyPK getId() {
		return this.id;
	}

	public void setId(FamilyPK id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}