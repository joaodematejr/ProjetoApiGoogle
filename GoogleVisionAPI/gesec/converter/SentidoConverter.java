package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Sentido;
import br.com.gesec.rn.SentidoRN;

@FacesConverter(forClass = Sentido.class)
public class SentidoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		SentidoRN sentidoRN = new SentidoRN();
		Long id = Long.parseLong(value);
		return sentidoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Sentido sentido = (Sentido) value;
		return String.valueOf(sentido.getId());
	}

}
