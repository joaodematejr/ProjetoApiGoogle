package br.com.gesec.mb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

import br.com.gesec.entity.AnaliseForense;
import br.com.gesec.rn.AnaliseForenseRN;

@ViewScoped
@ManagedBean
public class AnaliseForenseMB {
	private AnaliseForense analiseForense;
	private AnaliseForenseRN analiseForenseRN;

	@PostConstruct
	public void init() {
		analiseForense = new AnaliseForense();
		analiseForenseRN = new AnaliseForenseRN();
	}

	public AnaliseForense getAnaliseForense() {
		return analiseForense;
	}

	public void setAnaliseForense(AnaliseForense analiseForense) {
		this.analiseForense = analiseForense;
	}

	public AnaliseForenseRN getAnaliseForenseRN() {
		return analiseForenseRN;
	}

	public void setAnaliseForenseRN(AnaliseForenseRN analiseForenseRN) {
		this.analiseForenseRN = analiseForenseRN;
	}

	// BOTÃO DE BUSCAR
	public String consultar() throws Throwable {
		requisicaoImagem(analiseForense.getTipo());
		analiseForenseRN.salvar(analiseForense);
		System.out.println();
		return "analiseForense.xhtml";

	}

	// API DA GOOGLE
	public void requisicaoImagem(String getTipo) throws Exception {
		// Instantiates a client
		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
			// The path to the image file to annotate
			String fileName = "C:\\pjj9889.png";
			// Reads the image file into memory
			Path path = Paths.get(fileName);
			byte[] data = Files.readAllBytes(path);
			ByteString imgBytes = ByteString.copyFrom(data);
			// Builds the image annotation request
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
			requests.add(request);
			// Performs label detection on the image file
			BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.printf("Error: %s\n", res.getError().getMessage());
					return;
				}
				String tipo = getTipo;
				String resultados = popularResultados(tipo, res);
				analiseForense.setImagem(fileName);
				analiseForense.setTipo(tipo);
				analiseForense.setResultados(resultados);
			}
		}
	}

	public String popularResultados(String tipo, AnnotateImageResponse res) {
		String resultados = "";
		if (tipo.equals("LABEL_DETECTION")) {
			for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
				resultados = resultados + annotation.getDescription() + ": " + annotation.getScore() + ";";
			}

		}
		if (tipo.equals("TEXT_DETECTION")) {
			for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
				resultados = resultados + annotation.getDescription() + ";";
				FacesContext.getCurrentInstance().addMessage("Mensagem", new FacesMessage(annotation.getDescription()));
			}
			String[] splitResultado = resultados.split(";");
			for (String resultado : splitResultado) {
				System.out.println(resultado);

			}

		}
		return resultados;
	}

}