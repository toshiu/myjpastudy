package apl.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="CITY_MAN")
	private String cityMan;

	@Column(name="CITY_NAME")
	private String cityName;

	//bi-directional one-to-one association to Province
	@OneToOne(mappedBy="city")
	private Province province;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityMan() {
		return this.cityMan;
	}

	public void setCityMan(String cityMan) {
		this.cityMan = cityMan;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}