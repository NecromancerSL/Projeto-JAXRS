package app;

import java.io.*;
import java.net.*;
import entities.Endereco;
import xml.*;

public class BuscaEnderecoXML {
	public static void main(String[] args) {
		try {
			URL url = new
				URL("http://viacep.com.br/ws/18705860/xml/");
			HttpURLConnection conn = (HttpURLConnection) 
					url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/xml");
			BufferedReader br = new BufferedReader(new 		
					InputStreamReader((conn.getInputStream())));
				String output;
				StringBuilder xml = new StringBuilder();
				while ((output = br.readLine()) != null) {
					xml.append(output);
				}
				conn.disconnect();
				Xmlcep enderecoXML = (Xmlcep) XmlcepJAXB.unmarshal
						(Xmlcep.class, 	xml.toString());
					Endereco e = new Endereco();
					e.setLogradouro(enderecoXML.getLogradouro());
					e.setComplemento(enderecoXML.getComplemento());
					e.setBairro(enderecoXML.getBairro());
					e.setCidade(enderecoXML.getLocalidade());
					e.setUf(enderecoXML.getUf());
					e.setCep(enderecoXML.getCep());
					System.out.println(e);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
