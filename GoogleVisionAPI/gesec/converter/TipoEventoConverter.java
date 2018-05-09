package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.TipoEvento;
import br.com.gesec.rn.TipoEventoRN;

@FacesConverter(forClass = TipoEvento.class)
public class TipoEventoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		TipoEventoRN tipoEventoRN = new TipoEventoRN();
		Long id = Long.parseLong(value);
		return tipoEventoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		TipoEvento tipoEvento = (TipoEvento) value;
		return String.valueOf(tipoEvento.getId());
	}

}
