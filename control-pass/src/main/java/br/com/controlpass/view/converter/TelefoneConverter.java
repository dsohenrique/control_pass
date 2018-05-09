package br.com.etechoracio.jpa.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("foneConverter")
public class TelefoneConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		String fone = value;
		if (fone != null && !fone.equals("")) {
			fone = value.replaceAll("[^0-9]", "");
		}
		return fone;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		String fone = (String) value;
		if (fone != null && fone.length() == 11) {
			fone = "(" + fone.substring(0, 2) + ") " + fone.substring(2, 6) + "-" + fone.substring(6);
		}
		return fone;
	}

}
