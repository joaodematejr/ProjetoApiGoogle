package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Abordagem;
import br.com.gesec.rn.AbordagemRN;

@FacesConverter(forClass = Abordagem.class)
public class AbordagemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AbordagemRN abordagemRN = new AbordagemRN();
		Long id = Long.parseLong(value);
		return abordagemRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Abordagem abordagem = (Abordagem) value;
		return String.valueOf(abordagem.getId());
	}

}
