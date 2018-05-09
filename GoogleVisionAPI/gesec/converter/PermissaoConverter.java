package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Permissao;
import br.com.gesec.rn.PermissaoRN;

@FacesConverter(forClass = Permissao.class)
public class PermissaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		PermissaoRN permissaoRN = new PermissaoRN();
		Long id = Long.parseLong(value);
		return permissaoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Permissao permissao = (Permissao) value;
		return String.valueOf(permissao.getId());
	}

}
