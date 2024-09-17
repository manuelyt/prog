package com.baeldung.jasperreports.manu;

public class ManuLista24 {

    public ManuLista24(String agno, String apell, int num) {
		super();
		this.agno = agno;
		this.apell = apell;
		this.num = num;
	}
	private String agno;
    private String apell;
    private int num;
    
	public String getAgno() {
		return agno;
	}
	public void setAgno(String agno) {
		this.agno = agno;
	}
	public String getApell() {
		return apell;
	}
	public void setApell(String apell) {
		this.apell = apell;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
    
}
