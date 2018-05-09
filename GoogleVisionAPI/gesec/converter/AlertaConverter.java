package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Alerta;
import br.com.gesec.rn.AlertaRN;

@FacesConverter(forClass = Alerta.class)
public class AlertaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AlertaRN alertaRN = new AlertaRN();
		Long id = Long.parseLong(value);
		return alertaRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Alerta alerta = (Alerta) value;
		return String.valueOf(alerta.getId());
	}

}
