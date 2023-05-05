package aula_01;

import java.awt.Container;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class PrimeiraTela extends JFrame
{

	private JLabel lbNome;
	private JTextField txtNome;
	private JLabel lbCPF;
	private JFormattedTextField txtCPF;
	private JLabel lbTipo;
	private JComboBox cmbTipo;
	private final String[] tiposUsuarios = {"Administrador", "Geral"};
	private JButton btnOK;
	private Container ctn;
	
	public PrimeiraTela()
	{		
		setSize(400, 300);
		setTitle("Tela Inicial");
		ctn = getContentPane();		
		lbNome = new JLabel ("Nome");
		txtNome = new JTextField();
		lbCPF = new JLabel("CPF");
		
		try
		{
			txtCPF = new JFormattedTextField (new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lbTipo = new JLabel("Tipo de usuario");
		cmbTipo = new JComboBox(tiposUsuarios);
		btnOK = new JButton("Enviar");
		ctn.setLayout(null);
		lbNome.setBounds(0, 0, 100, 25);
		txtNome.setBounds(150, 0, 200, 25);
		lbCPF.setBounds(0, 50, 100, 25);
		txtCPF.setBounds(150, 50, 200, 25);
		lbTipo.setBounds(0, 100, 200, 25);
		cmbTipo.setBounds(150, 100, 200, 25);
		btnOK.setBounds(150, 150, 100, 100);
		ctn.add(lbNome);
		ctn.add(txtNome);
		ctn.add(lbCPF);
		ctn.add(txtCPF);
		ctn.add(lbTipo);
		ctn.add(cmbTipo);
		ctn.add(btnOK);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		PrimeiraTela t1 = new PrimeiraTela();
	}

}