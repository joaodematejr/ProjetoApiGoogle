package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Estado;
import br.com.gesec.rn.EstadoRN;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		EstadoRN estadoRN = new EstadoRN();
		Long id = Long.parseLong(value);
		return estadoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Estado estado = (Estado) value;
		return String.valueOf(estado.getId());
	}

}
