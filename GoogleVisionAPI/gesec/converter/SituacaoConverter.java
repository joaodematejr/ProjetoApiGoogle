package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Situacao;
import br.com.gesec.rn.SituacaoRN;

@FacesConverter(forClass = Situacao.class)
public class SituacaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		SituacaoRN situacaoRN = new SituacaoRN();
		Long id = Long.parseLong(value);
		return situacaoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Situacao situacao = (Situacao) value;
		return String.valueOf(situacao.getId());
	}

}
