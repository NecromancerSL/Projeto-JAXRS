package xml.lista;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Enderecos {
	private List<Endereco> endereco = new ArrayList<Endereco>();

	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}