package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.AcompanhamentoVeiculo;
import br.com.gesec.rn.AcompanhamentoVeiculoRN;

@FacesConverter(forClass = AcompanhamentoVeiculo.class)
public class AcompanhamentoVeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		AcompanhamentoVeiculoRN acompanhamentoVeiculoRN = new AcompanhamentoVeiculoRN();
		Long id = Long.parseLong(value);
		return acompanhamentoVeiculoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		AcompanhamentoVeiculo acompanhamentoVeiculo = (AcompanhamentoVeiculo) value;
		return String.valueOf(acompanhamentoVeiculo.getId());
	}

}
