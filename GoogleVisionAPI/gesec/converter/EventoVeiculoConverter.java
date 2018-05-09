package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.EventoVeiculo;
import br.com.gesec.rn.EventoVeiculoRN;

@FacesConverter(forClass = EventoVeiculo.class)
public class EventoVeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		EventoVeiculoRN eventoVeiculoRN = new EventoVeiculoRN();
		Long id = Long.parseLong(value);
		return eventoVeiculoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		EventoVeiculo eventoVeiculo = (EventoVeiculo) value;
		return String.valueOf(eventoVeiculo.getId());
	}
}
