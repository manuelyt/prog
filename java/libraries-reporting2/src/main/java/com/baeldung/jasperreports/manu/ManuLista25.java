package com.baeldung.jasperreports.manu;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ManuLista25 implements JRDataSource{

    private static final String[][] nameArray = {new String[]{"aaa","2022","oioioiooi oi oi oi o","22"},
    		new String[]{"aaa","2023","ygygygyg g yg yg ","23"},
    		new String[]{"aaa","2024","aassas asa sas a","24"},
    		new String[]{"bbb","2055","tyty t","55"},
    		new String[]{"ccc","2066","rrereer","66"},
    		new String[]{"ccc","2067","lolol","67"},
    		new String[]{"ccc","2068","dededed","68"}
    		};
    
    public static JRDataSource getDataSource(){
        return new ManuLista25();
    }	

    private int counter = -1;

    public Object getFieldValue(JRField jrField) throws JRException {
        if (jrField.getName().equals("Name")) return nameArray[counter];
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
