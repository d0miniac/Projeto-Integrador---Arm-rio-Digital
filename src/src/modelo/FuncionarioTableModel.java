package modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import modelo.Fornecedor;

public class FuncionarioTableModel extends AbstractTableModel {
	private List<Funcionario> funcionarios;
	private String[] colunas = { "ID", "Nome", "Email", "CPF", "Senha"  };

	public FuncionarioTableModel(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int getRowCount() {
		return funcionarios.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario funcionario = funcionarios.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return funcionario.getId();
		case 1:
			return funcionario.getNome();
		case 2:
			return funcionario.getEmail();
		case 3:
			return funcionario.getCpf();
		case 4:
			return funcionario.getSenha();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}
