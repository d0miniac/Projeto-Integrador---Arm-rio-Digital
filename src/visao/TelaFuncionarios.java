package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controle.FornecedorController;
import controle.FornecedorDAO;
import controle.FuncionarioController;
import controle.FuncionarioDAO;
import modelo.FornecedorTableModel;
import modelo.Funcionario;
import modelo.FuncionarioTableModel;
import net.miginfocom.swing.MigLayout;

public class TelaFuncionarios extends JFrame {

	protected static final String Funcionario = null;
	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;
	private JTable tableFuncionarios;
	private FuncionarioTableModel futm;
	private ArrayList<Funcionario> listarFuncionarios;

	

	public TelaFuncionarios(Funcionario func, String mensagem) throws SQLException {
		setTitle("Funcionarios");

		listarFuncionarios = new ArrayList<>();
		FuncionarioDAO fu = new FuncionarioDAO();
		try {
			listarFuncionarios = fu.selecionarFuncionarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new ImagePanel("src/img/bgFuncionarios.png");
		contentPane.setBackground(new Color(243, 244, 240));

		setSize(1215, 850);
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,fill]", "[120px][grow]"));

		JPanel panelVazio = new JPanel();
		panelVazio.setBackground(new Color(0, 0, 0));
		panelVazio.setOpaque(false);
		contentPane.add(panelVazio, "cell 0 0,grow");
		panelVazio.setLayout(null);

		JPanel panelComponentes = new JPanel();
		panelComponentes.setBackground(new Color(255, 0, 0));
		panelComponentes.setOpaque(false);
		contentPane.add(panelComponentes, "cell 0 1,grow");
		panelComponentes.setLayout(new MigLayout("", "[][][][][grow][]", "[][][grow]"));

		txtFiltro = new JTextField();
		txtFiltro.setUI(new HintTextFieldUI("Pesquisa"));
		txtFiltro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFiltro.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(txtFiltro, "cell 4 0,alignx left");
		txtFiltro.setColumns(90);
		txtFiltro.setPreferredSize(new Dimension(450, 45));

		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroFuncionario tela = new TelaCadastroFuncionario(mensagem);
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		btnAdd.setBackground(new Color(243, 244, 240));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAdd.setMinimumSize(new Dimension(150, 30));
		btnAdd.setMaximumSize(new Dimension(150, 30));
		btnAdd.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnAdd, "cell 4 1,alignx left,growy");

		// Botão Alterar
		JButton btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i != -1) {
					Funcionario funcionario = listarFuncionarios.get(i);
					TelaEditarFuncionario telaEditar = new TelaEditarFuncionario(funcionario,func, mensagem);
					dispose();
					telaEditar.setVisible(true);
					telaEditar.setSize(657, 425);
					telaEditar.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário para alterar.");
				}
			}
		});
		btnUpdate.setBackground(new Color(243, 244, 240));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdate.setMinimumSize(new Dimension(150, 30));
		btnUpdate.setMaximumSize(new Dimension(150, 30));
		btnUpdate.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnUpdate, "cell 4 1,alignx left,growy");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(scrollPane, "cell 4 2,grow");
		// Inicializa a tabela
		try {
			carregarFuncionarios();
		} catch (Exception e) {
			e.printStackTrace();
		}

		futm = new FuncionarioTableModel(listarFuncionarios);
		tableFuncionarios = new JTable(futm);
		tableFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableFuncionarios.setBackground(new Color(123, 150, 212));
		scrollPane.setViewportView(tableFuncionarios);

		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int i = table.getSelectedRow(); 
		        if (i == -1) {
		            JOptionPane.showMessageDialog(TelaFuncionarios.this, "Selecione um funcionário para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        Object idObj = table.getModel().getValueAt(i, 0); // Obtém o ID da tabela
		        Long id;

		        // Verifica se o ID é Integer ou Long e faz a conversão
		        if (idObj instanceof Integer) {
		            id = ((Integer) idObj).longValue(); // Converte Integer para Long
		        } else if (idObj instanceof Long) {
		            id = (Long) idObj;
		        } else {
		            JOptionPane.showMessageDialog(TelaFuncionarios.this, "Erro ao obter o ID do funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            fu.excluirFuncionario(id); 
		            listarFuncionarios = fu.selecionarFuncionarios(); 
		            atualizarTabela(); 
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(TelaFuncionarios.this, "Erro ao deletar funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnDelete.setBackground(new Color(243, 244, 240));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setMinimumSize(new Dimension(150, 30));
		btnDelete.setMaximumSize(new Dimension(150, 30));
		btnDelete.setBorder(new LineBorder(new Color(123, 150, 212), 2, true));
		panelComponentes.add(btnDelete, "cell 4 1");

		JLabel lblSeta = new JLabel();
		lblSeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSeta.setIcon(new ImageIcon(new ImageIcon(TelaCadastroProdutos.class.getResource("/img/de-volta.png"))
				.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		lblSeta.setBounds(0, 0, 110, 100);
		panelVazio.add(lblSeta);
		lblSeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaMenu tela = new TelaMenu(func, mensagem);
				dispose();
				tela.setVisible(true);
			}
		});

		FuncionarioController funcionarioController = new FuncionarioController();
		listarFuncionarios = funcionarioController.listarFuncionarios();

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setGridColor(new Color(0, 0, 0));
		table.setBackground(new Color(123, 150, 212));
		table.setForeground(new Color(255, 255, 255));

		atualizarTabela();

		theader();
		scrollPane.setViewportView(table);
	}

	private void theader() {
		JTableHeader thead = table.getTableHeader();
		thead.setForeground(new Color(123, 150, 212));
		thead.setBackground(new Color(255, 255, 255));
		thead.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}

	protected void atualizarTabela() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Email", "CPF", "Senha" });

		for (Funcionario funcionario : listarFuncionarios) {
			tableModel.addRow(new Object[] { funcionario.getId(), funcionario.getNome(), funcionario.getEmail(),
					funcionario.getCpf(), funcionario.getSenha() });
		}

		table.setModel(tableModel);
	}

	public void cadastrar(Funcionario funcionario) {
		listarFuncionarios.add(funcionario);
		atualizarTabela();
	}

	private void carregarFuncionarios() throws SQLException {
		FuncionarioController controller = new FuncionarioController();
		listarFuncionarios = controller.listarFuncionarios();
		futm = new FuncionarioTableModel(listarFuncionarios);
	}
}
