package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.TipoAcompanhamento;
import br.com.gesec.rn.TipoAcompanhamentoRN;

@FacesConverter(forClass = TipoAcompanhamento.class)
public class TipoAcompanhamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		TipoAcompanhamentoRN tipoAcompanhamentoRN = new TipoAcompanhamentoRN();
		Long id = Long.parseLong(value);
		return tipoAcompanhamentoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		TipoAcompanhamento tipoAcompanhamento = (TipoAcompanhamento) value;
		return String.valueOf(tipoAcompanhamento.getId());
	}

}
