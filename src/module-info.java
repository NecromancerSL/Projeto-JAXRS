/**
 * 
 */
/**
 * @author Gustavo Nunes
 *
 */
module ProjetoJAXRS {
	exports app;
	exports xml;
	exports xml.lista;
	exports entities;

	requires java.json;
	requires java.xml;
	requires java.xml.bind;
	
	opens xml;
	opens xml.lista;
}	
