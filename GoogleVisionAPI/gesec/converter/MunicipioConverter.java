package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Municipio;
import br.com.gesec.rn.MunicipioRN;

@FacesConverter(forClass = Municipio.class)
public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		MunicipioRN municipioRN = new MunicipioRN();
		Long id = Long.parseLong(value);
		return municipioRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Municipio municipio = (Municipio) value;
		return String.valueOf(municipio.getId());
	}
}
