import java.util.Locale;

public class Produto {
	int codigoSequencial;
	String nome;
	int qty;
	String tipo;
	double valor;
	
	Produto(int codigoSequencial){
		this.codigoSequencial = codigoSequencial;
	}
	Produto(int codigoSequencial, String nome){
		this.codigoSequencial = codigoSequencial;
		this.nome = nome;
	}
	Produto(int codigoSequencial, String nome, int qty){
		this.codigoSequencial = codigoSequencial;
		this.nome = nome;
		this.qty = qty;
	}
	Produto(int codigoSequencial, String nome, int qty, String tipo, double valor){
		this.codigoSequencial = codigoSequencial;
		this.nome = nome;
		this.qty = qty;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public double Vender(int qtyVenda) {
		if(this.qty < qtyVenda) {
			System.out.println("Não há a quantidade necessária para realizar a venda");
			return 0;
		}
		this.qty -= qtyVenda;
		return this.valor*qtyVenda;
	}
	
	public void Comprar(int qtyCompra, float novoValor) {
		this.qty += qtyCompra;
		this.valor = novoValor;
	}
	
	public void Comprar (int qtyCompra) {
		this.qty = qtyCompra;
	}
	
	public String Consultar () {
		return String.format(Locale.ROOT,"Produto %i: %s - %i - %s -R$%d", this.codigoSequencial, this.nome, this.qty, this.tipo, this.valor);
	}
	
	public String Inserir (String nome, int qty, String tipo, double valor) {
		this.nome = nome;
		this.qty = qty;
		this.tipo = tipo;
		this.valor = valor;
		return this.Consultar();
	}
	
	public boolean Igual (Produto produto) {
		return this.nome.equals(produto.nome) && this.tipo.equals(produto.tipo);
	}
}