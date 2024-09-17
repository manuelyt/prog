package com.baeldung.jasperreports.manu;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ManuLista23 implements JRDataSource{

    public static JRDataSource getDataSource(){
        return new ManuLista23();
    }

    private static final String[] nameArray = {"Frank", "Joseph", "Marco"};
//    private static final String[] nameArray = {"Frank", "Joseph", "Marco", "Carl", "Lenny", "Homer", "Teodor", "Leopold"};

    private static final ManuLista24 age1 = new ManuLista24("2022","iefjifeijefi efi fe iefj iefj",22);
    private static final ManuLista24 age2 = new ManuLista24("2023","apapafpffsf sssasaadpap ",23);
    private static final ManuLista24 age3 = new ManuLista24("2024","qwq wqwq wq   q",24);
    		
    private static final ManuLista24[] ageArray = {age1,age2,age3};
    
    private int counter = -1;

    public Object getFieldValue(JRField jrField) throws JRException {
        if (jrField.getName().equals("Name")) return nameArray[counter];
        else if (jrField.getName().equals("Age")) return ageArray[counter];
        return "";
    }
    
	@Override
	public boolean next() throws JRException {
        if (counter<nameArray.length-1) {
            counter++;
            return true;
        }
        return false;
	}

}
