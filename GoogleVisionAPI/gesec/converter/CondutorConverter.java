package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Condutor;
import br.com.gesec.rn.CondutorRN;

@FacesConverter(forClass = Condutor.class)
public class CondutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		CondutorRN condutorRN = new CondutorRN();
		Long id = Long.parseLong(value);
		return condutorRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Condutor condutor = (Condutor) value;
		return String.valueOf(condutor.getId());
	}

}
