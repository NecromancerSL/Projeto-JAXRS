package app;

import java.io.*;
import java.net.*;
import xml.*;

public class BuscaCepXML {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://viacep.com.br/ws/SP/Avare/Arlindo/xml/");
			HttpURLConnection conn = (HttpURLConnection) 
					url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/xml");
			if (conn.getResponseCode() != 200) { // 200 = HTTP OK
				throw new RuntimeException(
						"Falha : HTTP error code : " 
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(
					new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder xml = new StringBuilder();
			while ((output = br.readLine()) != null) {
				xml.append(output);
			}
			conn.disconnect();

			xml.lista.Xmlcep listaXML = (xml.lista.Xmlcep) 
					XmlcepJAXB.unmarshal(xml.lista.Xmlcep.class, 
							xml.toString());
			for (xml.lista.Endereco enderecoXML 
					: listaXML.getEnderecos().getEndereco()) {
				String logradouro = enderecoXML.getLogradouro();
				String complemento = enderecoXML.getComplemento();
				String bairro = enderecoXML.getBairro();
				String cep = enderecoXML.getCep();
				System.out.println(cep + " - " + logradouro + " - " 
						+ complemento + " - " + bairro);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
