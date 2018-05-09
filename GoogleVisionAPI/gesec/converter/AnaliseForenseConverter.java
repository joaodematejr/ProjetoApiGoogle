package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.AnaliseForense;
import br.com.gesec.rn.AnaliseForenseRN;

@FacesConverter(forClass = AnaliseForense.class)
public class AnaliseForenseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AnaliseForenseRN analiseForenseRN = new AnaliseForenseRN();
		Long id = Long.parseLong(value);
		return analiseForenseRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		AnaliseForense analiseForense = (AnaliseForense) value;
		return String.valueOf(analiseForense.getId());
	}

}
