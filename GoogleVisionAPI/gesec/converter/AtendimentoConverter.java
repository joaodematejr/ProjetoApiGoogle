package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Atendimento;
import br.com.gesec.rn.AtendimentoRN;

@FacesConverter(forClass = Atendimento.class)
public class AtendimentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AtendimentoRN atendimentoRN = new AtendimentoRN();
		Long id = Long.parseLong(value);
		return atendimentoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Atendimento atendimento = (Atendimento) value;
		return String.valueOf(atendimento.getId());
	}

}
