package apl.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROVINCE database table.
 * 
 */
@Entity
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROVINCE_ID")
	private int provinceId;

	@Column(name="PROVINCE_MAN")
	private String provinceMan;

	@Column(name="PROVINCE_NAME")
	private String provinceName;

	//bi-directional one-to-one association to City
	@OneToOne
	@JoinColumn(name="PROVINCE_ID", referencedColumnName="PROVINCE_ID")
	private City city;

	public Province() {
	}

	public int getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceMan() {
		return this.provinceMan;
	}

	public void setProvinceMan(String provinceMan) {
		this.provinceMan = provinceMan;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}