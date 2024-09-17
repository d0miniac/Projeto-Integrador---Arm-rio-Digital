package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel backgroundLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login da Conta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // Permitir redimensionamento da janela

        // Configurar o tamanho da janela para ocupar toda a tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        // Usar BorderLayout para que a imagem de fundo ocupe todo o espaço do contentPane
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        // Criar JLabel para adicionar a imagem de fundo
        ImageIcon icon = new ImageIcon("src/img/background1.png");
        Image image = icon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        contentPane.setLayout(null);
        
        JButton btnCadastrese = new JButton("cadastre-se");
        btnCadastrese.setBackground(new Color(32, 60, 115));
        btnCadastrese.setForeground(Color.WHITE);
        btnCadastrese.setBorderPainted(false);
        btnCadastrese.setFocusPainted(false);
        btnCadastrese.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnCadastrese.setBounds(1365, 807, 164, 32);
        contentPane.add(btnCadastrese);
        
        JLabel lblNewLabel_4 = new JLabel("Ainda não tem uma conta?");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_4.setBounds(1064, 807, 345, 32);
        contentPane.add(lblNewLabel_4);
        
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.setBackground(new Color(103, 203, 239));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNewButton_1.setBounds(1064, 720, 680, 66);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Esqueci a senha");
        btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        btnNewButton.setBackground(new Color(32, 60, 115));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(1557, 541, 187, 32);
        contentPane.add(btnNewButton);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar senha");
        chckbxNewCheckBox.setBackground(new Color(32, 60, 115));
        chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chckbxNewCheckBox.setBounds(1064, 541, 192, 32);
        contentPane.add(chckbxNewCheckBox);
        
        lblNewLabel_3 = new JLabel("Senha:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(1064, 425, 208, 32);
        contentPane.add(lblNewLabel_3);
        
        lblNewLabel_1 = new JLabel("CPF:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(1064, 274, 208, 32);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(1064, 317, 680, 66);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(1064, 468, 680, 66);
        contentPane.add(textField);
        textField.setColumns(10);
        
        lblNewLabel_2 = new JLabel("novamente!");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel_2.setBounds(1064, 143, 306, 49);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel = new JLabel("Bem vindo");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel.setBounds(1064, 74, 264, 78);
        contentPane.add(lblNewLabel);
        backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setForeground(new Color(255, 255, 255));
        backgroundLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backgroundLabel.setBounds(-20, 0, 1904, 1041);
        contentPane.add(backgroundLabel);

        // Painel para conter os componentes de login (pode adicionar outros componentes aqui)
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(1894, 0, 10, 1041);
        contentPane.add(loginPanel);
    }
}
