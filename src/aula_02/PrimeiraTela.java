package aula_02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrimeiraTela extends JFrame implements ActionListener {
	private JButton btnok;
	private JTextField txtNome;
	private JLabel lblNome;
	private Container ctn;
	private PrimeiraTela()
	{
		setSize(300, 140);
		setTitle("Eventos em Java Swing");
		ctn = getContentPane();
		ctn.setLayout(null);
		btnok = new JButton("Enviar");
		lblNome = new JLabel("Nome");
		txtNome.setBounds(10,10,100,25);
		lblNome.setBounds(70,10,200,25);
		btnok.setBounds(90,50,80,40);
		ctn.add(lblNome);
		ctn.add(txtNome);
		ctn.add(btnok);
		
		btnok.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public static void main(String[] args) {
		PrimeiraTela tela = new PrimeiraTela();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Enviar"));
		{
			txtNome.setText("Botão clicado");
		}
	}

}