package jogador;

public class Card {

	private int processo;

	private int diasAnalise;
	private int diasImplem;
	private int diasQA;

	private int diasAnaliseRestantes;
	private int diasImplemRestantes;
	private int diasQARestantes;

	public Card(int diasAnalise, int diasImplem, int diasQA) {
		super();
		this.diasAnalise = diasAnalise;
		this.diasImplem = diasImplem;
		this.diasQA = diasQA;
		
		this.diasAnaliseRestantes = diasAnalise;
		this.diasImplemRestantes = diasImplem;
		this.diasQARestantes = diasQA;
	}

	public int getProcesso() {
		return processo;
	}

	public void setProcesso(int processo) {
		this.processo = processo;
	}

	public int getDiasAnalise() {
		return diasAnalise;
	}

	public void setDiasAnalise(int diasAnalise) {
		this.diasAnalise = diasAnalise;
	}

	public int getDiasImplem() {
		return diasImplem;
	}

	public void setDiasImplem(int diasImplem) {
		this.diasImplem = diasImplem;
	}

	public int getDiasQA() {
		return diasQA;
	}

	public void setDiasQA(int diasQA) {
		this.diasQA = diasQA;
	}

	public int getDiasAnaliseRestantes() {
		return diasAnaliseRestantes;
	}

	public void setDiasAnaliseRestantes(int diasAnaliseRestantes) {
		this.diasAnaliseRestantes = diasAnaliseRestantes;
	}

	public int getDiasImplemRestantes() {
		return diasImplemRestantes;
	}

	public void setDiasImplemRestantes(int diasImplemRestantes) {
		this.diasImplemRestantes = diasImplemRestantes;
	}

	public int getDiasQARestantes() {
		return diasQARestantes;
	}

	public void setDiasQARestantes(int diasQARestantes) {
		this.diasQARestantes = diasQARestantes;
	}

	@Override
	public String toString() {
		return "Card [processo=" + processo + ", diasAnalise=" + diasAnalise + ", diasImplem=" + diasImplem
				+ ", diasQA=" + diasQA + ", diasAnaliseRestantes=" + diasAnaliseRestantes + ", diasImplemRestantes="
				+ diasImplemRestantes + ", diasQARestantes=" + diasQARestantes + "]";
	}
}
