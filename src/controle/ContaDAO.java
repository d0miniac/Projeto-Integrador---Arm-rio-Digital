package controle;

import java.util.ArrayList;

import modelo.Conta;

public class ContaDAO {
	private static ArrayList<Conta> listaFuncionarios;
	public boolean CadastrarFuncionario(Conta c){
		listaFuncionarios.add(c);
		return false;
	}
}
