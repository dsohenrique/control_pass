package br.com.etechoracio.jpa.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cpfConverter")
public class CPFConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		String cpf = value;
		if (cpf != null && !cpf.equals("")) {
			cpf = value.replaceAll("[^0-9]", "");
		}
		return cpf;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		String cpf = String.valueOf(value);
		if (cpf != null && cpf.length() == 11) {
			cpf = cpf.substring(0, 3) + "." + 
				cpf.substring(3, 6) + "." + 					
				cpf.substring(6, 9) + "-" +
				cpf.substring(9, 11);
		}
		return cpf;

	}

}
