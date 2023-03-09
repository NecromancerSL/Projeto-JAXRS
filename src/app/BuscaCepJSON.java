package app;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.json.*;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class BuscaCepJSON {
	public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<String, String>();
		try {
			URL url = new URL("http://viacep.com.br/ws/SP/Avare/Arlindo/json/");
			InputStream is = url.openStream();
			JsonParser parser = Json.createParser(is);
            String logradouro = null, complemento = null;
			String bairro = null, cep = null;
			StringBuilder texto = new StringBuilder();

			while (parser.hasNext()) {
				Event e = parser.next();
				if (e == Event.KEY_NAME) {
					switch (parser.getString()) {
					case "cep":
						parser.next();
						cep = parser.getString();
						texto.append(cep);
						texto.append(" - ");
						break;
					case "logradouro":
						parser.next();
						logradouro = parser.getString();
						texto.append(logradouro);
						texto.append(" - ");
						break;
                        case "complemento":
						parser.next();
						complemento = parser.getString();
						texto.append(complemento);
						texto.append(" - ");
						break;
					case "bairro":
						parser.next();
						bairro = parser.getString();
						texto.append(bairro);
						System.out.println(texto);
						texto.delete(0, texto.length());
						break;
					}
				}
			}
            Set<String> chaves = mapa.keySet();
            for(String chave : chaves){
                System.out.println(chave);
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}