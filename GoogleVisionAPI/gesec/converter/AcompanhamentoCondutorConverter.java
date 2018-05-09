package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.AcompanhamentoCondutor;
import br.com.gesec.rn.AcompanhamentoCondutorRN;

@FacesConverter(forClass = AcompanhamentoCondutor.class)
public class AcompanhamentoCondutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AcompanhamentoCondutorRN acompanhamentoCondutorRN = new AcompanhamentoCondutorRN();
		Long id = Long.parseLong(value);
		return acompanhamentoCondutorRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		AcompanhamentoCondutor condutor = (AcompanhamentoCondutor) value;
		return String.valueOf(condutor.getId());
	}

}
