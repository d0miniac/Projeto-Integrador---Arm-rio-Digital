package controle;

import javax.swing.JOptionPane;

import modelo.UsuarioModel;
import visao.LoginView;
import visao.TelaLogin;

public class LoginController {

	private LoginView view;
	private TelaLogin loginn;
	private UsuarioModel modelo;

	this.visao=visao;this.modelo=new UsuarioModel();

	if(model.conexao!=null)
	{

		view.lblStatus.setText("conectao ao bd");
		System.out.println("Conectado ao bd");

	}else
	{
		System.out.println("Nao conectado");
		view.lblStatus.setText("nao conectao ao bd");
	}
	this.view.btnLogin.addActionListener(e->logar ());
}

public void logar () {
	
	String login = view.textUsuario.getText();
	String senha= new String (loginn.txtSenha.getPassword());
	String perfil = modelo.autenticar (login, senha);
	if (perfil != null) {
		JOptionPane.showMessageDialog (null, "tudo certo");
	} else {
		JOptionPane.showMessageDialog (null, "login ou senha invalidos");
	}
	
}
}
}
