package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Passagem;
import br.com.gesec.rn.PassagemRN;

@FacesConverter(forClass = Passagem.class)
public class PassagemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		PassagemRN passagemRN = new PassagemRN();
		Long id = Long.parseLong(value);
		return passagemRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Passagem passagem = (Passagem) value;
		return String.valueOf(passagem.getId());
	}

}
