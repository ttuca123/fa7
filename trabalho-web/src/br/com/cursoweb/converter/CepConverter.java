package br.com.cursoweb.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cursoweb.util.Cep;
/**
 * 
 * @author Artur
 *
 */

@FacesConverter("converters.CepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		String cepp;
		String regiao = null;
		String sufixo = null;

		Cep cep = new Cep();
		if (value != null && !value.equals("")) {
			try {

				if (value.length() >= 8) {
					cepp = value.replaceAll("\\-", "");

					regiao = cepp.substring(0, 5);
					sufixo = cepp.substring(5, 8);

				}else{
					throw new Exception();
				}

			} catch (Exception e) {

				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro de conversão",
						"O valor informado não é um cep válido!");
				throw new ConverterException(message);

			}
		}

		cep = new Cep();
		cep.setRegiao(regiao);
		cep.setSufixo(sufixo);

		return cep;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {

		Cep cep;

		if (value != null) {
			cep = (Cep) value;

		} else {

			return null;
		}
		
		
		
		return cep.getRegiao() + "-" + cep.getSufixo();

	}

}
