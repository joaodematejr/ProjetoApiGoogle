package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.EventoCondutor;
import br.com.gesec.rn.EventoCondutorRN;

@FacesConverter(forClass = EventoCondutor.class)
public class EventoCondutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		EventoCondutorRN eventoCondutorRN = new EventoCondutorRN();
		Long id = Long.parseLong(value);
		return eventoCondutorRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		EventoCondutor eventoCondutor = (EventoCondutor) value;
		return String.valueOf(eventoCondutor.getId());
	}
}
