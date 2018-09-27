package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Aplciacao {
	public static void main(String[] args) throws ParseException {
		Scanner s = new Scanner(System.in);
		List<Produto> lista = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o número de Produtos: ");
		int quantidade = s.nextInt();
		for(int i =0; i< quantidade ; i++) {
			System.out.print("Produto comum, importado ou usado? (c/u/i) ");
			String tipoProduto = s.next();
			System.out.println("Produto número: "+ i+1);
			System.out.print("Nome: ");
			String nome = s.next();
			System.out.print("Preco: ");
			Double preco = s.nextDouble();
			if(tipoProduto.equals("c")) {
				lista.add(new Produto(nome, preco));
			}else if(tipoProduto.equals("u")) {
				System.out.print("Data de Fabricacao (DD/MM/AAAA): ");
				Date data = sdf.parse(s.next());
				lista.add(new ProdutoUsado(nome, preco, data));
			}else if(tipoProduto.equals("i")) {
				System.out.print("Taxa da alfandega: ");
				double taxaAlfandega = s.nextDouble();
				lista.add(new ProdutoImportado(nome, preco, taxaAlfandega));
			}
		}
		
		for(Produto p : lista) {
			System.out.println(p.etiqueta());
		}
	}
}
