
import java.util.List;
import java.util.stream.Collectors;

/**
 * Nomeado variáveis com nomes mais amigáveis e de fácil compreensão.
 * Foi criado uma nova constante com o conteúdo: "Fatura das notas fiscais de simples remessa: " afim de organizar e centralizar a troca do conteúdo caso necessário.
 * 
 * @author Graziela
 *
 */
public class GeradorObservacao {

	static final String umoNota = "Fatura da nota fiscal de simples remessa: ";
	static final String variasNotas = "Fatura das notas fiscais de simples remessa: ";

	/**
	 * Utilizado a comparação ternária do Java para diminuir o tamanho do método e facilitar a compreensão conforme abordagens do clean code.
	 * 
	 * @param listaInteiros lista dos valores inteiros pré definidos.
	 * @return a observação.
	 */
	public String geraObservacao(List<Integer> listaInteiros) {
		return !listaInteiros.isEmpty() ? retornaCodigos(listaInteiros) + "." : "";
	}

	/**
	 * Este método foi refatorado para ficar o mais simples e claro o possível. 
	 * 
	 * @param listaInteiros lista dos valores inteiros pré definidos.
	 * @return a observação.
	 */
	private String retornaCodigos(List<Integer> listaInteiros) {
		String observacao = (listaInteiros.size() >= 2 ? variasNotas : umoNota);
		return observacao + getConteucoComSeparadores(listaInteiros);
	}

	/**
	 * Este método foi criado com base na técnica do clean code de criar funções simples, pequenas e claras.
	 * Neste método utilizei alguns facilitadores de String presentes no Java 8.
	 * Bem como o StringBuffer, pois com ele posso localizar a posição da última vírgula e trocar pelo "e", conforme esperado.
	 * 
	 * @param listaInteiros lista dos valores inteiros pré definidos.
	 * @return o conteúdo com os separadores.
	 */
	private String getConteucoComSeparadores(List<Integer> listaInteiros) {
		if(listaInteiros.size() > 1) {
			StringBuffer sb = new StringBuffer((String) listaInteiros.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
			int posicao = sb.toString().lastIndexOf(",");
			return sb.replace(posicao, posicao + 1, " e").toString();
		}
		return listaInteiros.get(0).toString();
	}
}