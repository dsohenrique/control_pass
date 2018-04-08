package br.com.etechoracio.jpa.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cepConverter")
public class CEPConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		String cep = value;
		if (cep != null && !cep.equals("")) {
			cep = value.replaceAll("[^0-9]", "");
		}
		return cep;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		String cep = (String) value;
		if (cep != null && cep.length() == 11) {
			cep = cep.substring(0, 5) + "-" + cep.substring(5);
		}
		return cep;
	}

}
