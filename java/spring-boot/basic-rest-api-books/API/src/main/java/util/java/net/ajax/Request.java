package util.java.net.ajax;

import java.util.ArrayList;

public class Request {

	String action = "request_wait";
	int UUID ;
	ArrayList reqjson= new ArrayList();
	
	
	
	public Request() {
		ArrayList regimenData= new ArrayList();
		

		regimenData.add(new Requestb(10,200));
		regimenData.add(new Requestb(20,50));
		regimenData.add(new  Requestc(30,120,13));
		regimenData.add(new Requestc(40,120,13));
		int forceShl =28;
		ArrayList OtherData= new ArrayList();
		OtherData.add(forceShl);
		reqjson.add(regimenData);
		reqjson.add(OtherData);
	}



	public int getUUID() {
		return UUID;
	}



	public void setUUID(int uUID) {
		UUID = uUID;
	}



	public Request(String action, int uUID, ArrayList reqjson, ArrayList regimenData, Requestb kk1, Requestb kk2,
			Requestc kk3, Requestc kk4) {
		super();
		this.action = action;
		UUID = uUID;
		this.reqjson = reqjson;
		
		
		

		regimenData.add(kk1);
		regimenData.add(kk2);
		regimenData.add(kk3);
		regimenData.add(kk4);
	}
	
	
	
}
