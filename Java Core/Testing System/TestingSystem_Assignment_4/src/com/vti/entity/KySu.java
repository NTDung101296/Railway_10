package com.vti.entity;

public class KySu extends CanBo{
	private String nganhDaoTao;

	
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
	
	public KySu() {
	}
	
	public KySu(short id, String name, byte age, Gender gender, String address, String nganhDaoTao) {
		super(id, name, age, gender, address);
		this.nganhDaoTao = nganhDaoTao;
	}
	
	public String toString() {
		return "Ky Su [" + super.toString() + "Nganh Dao Tao= " + nganhDaoTao + "]"; 
	}
	

}
