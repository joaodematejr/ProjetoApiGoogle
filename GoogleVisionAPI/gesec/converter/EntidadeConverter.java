package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Entidade;
import br.com.gesec.rn.EntidadeRN;

@FacesConverter(forClass = Entidade.class)
public class EntidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		EntidadeRN entidadeRN = new EntidadeRN();
		Long id = Long.parseLong(value);
		return entidadeRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Entidade entidade = (Entidade) value;
		return String.valueOf(entidade.getId());
	}

}
