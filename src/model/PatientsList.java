package model;

public class PatientsList {
	private long adharNumber;
	private String name;
	private String bloodGroup;
	private String status;
	private String district;
	private long mobile;
	public PatientsList() {
		
	}
	public PatientsList(Long adharNumber, String status, long mobile) {
		super();
		this.adharNumber = adharNumber;
		this.status = status;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "ListOfPatients [ adharNumber="+ adharNumber+"name=" + name + ", bloodGroup=" + bloodGroup + ", status=" + status + ", district="
				+ district + ", mobile=" + mobile + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public PatientsList(Long adharNumber,String name, String bloodGroup, String status, String district, long mobile) {
		super();
		this.adharNumber=adharNumber;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.status = status;
		this.district = district;
		this.mobile = mobile;
	}
	public long getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}

}
