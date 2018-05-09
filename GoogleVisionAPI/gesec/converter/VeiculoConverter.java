package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Veiculo;
import br.com.gesec.rn.VeiculoRN;

@FacesConverter(forClass = Veiculo.class)
public class VeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		VeiculoRN veiculoRN = new VeiculoRN();
		Long id = Long.parseLong(value);
		return veiculoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Veiculo veiculo = (Veiculo) value;
		return String.valueOf(veiculo.getId());
	}

}
