package br.com.gesec.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gesec.entity.Camera;
import br.com.gesec.rn.CameraRN;

@FacesConverter(value="cameraConverter")
public class CameraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		CameraRN cameraRN = new CameraRN();
		Long id = Long.parseLong(value);
		return cameraRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Camera camera = (Camera) value;
		return String.valueOf(camera.getId());
	}

}
