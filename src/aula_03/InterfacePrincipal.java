package aula_03;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfacePrincipal extends JFrame implements ActionListener {

	private JLabel lblCandidato;
	private JLabel lblTotal;
	private JLabel lblTotalBranco;
	private JLabel lblCandidato1;
	private JLabel lblCandidato2;
	
	private JTextField txtVoto;
	private JLabel labelTotalVotoBranco;
	private JLabel labelTotalVotoCandidato1;
	private JLabel labelTotalVotoCandidato2;
	private JLabel labelTotalVotacao;
	
	private JLabel lblNome;
	private JLabel lblNome1;
	private JLabel lblNome2;
	private JLabel lblNome3;
	private JLabel lblMensagemVotacao;
	
	private JButton btnApurar;
	private JButton btnVotar;
	
	private Container ctn;
	
	public Votacao objetoVotacao;
	
	InterfacePrincipal()
	{
		setSize(300, 430);
		setTitle("URNA ELETRONICA");
		ctn = getContentPane();
		ctn.setLayout(null);
		
		lblCandidato = new JLabel ("Candidatos");
		lblCandidato.setBounds(10, 10, 100, 25);
		
		lblNome1 = new JLabel ("1 - Joaquim Santos");
		lblNome1.setBounds(150, 10, 150, 25);
		
		lblNome2 = new JLabel ("2 - Karina Constas");
		lblNome2.setBounds(150, 30, 150, 25);
		
		lblNome3 = new JLabel ("3 - Voto em Branco");
		lblNome3.setBounds(150, 50, 150, 25);
		
		lblNome = new JLabel ("Voto");
		lblNome.setBounds(10, 80, 100, 25);
		
		lblMensagemVotacao = new JLabel ("Digite o seu voto: ");
		lblMensagemVotacao.setBounds(60, 180, 300, 25);
		
		txtVoto = new JTextField();
		txtVoto.setBounds(50,  80, 25, 25);
		
		btnVotar = new JButton ("Votar");
		btnVotar.setBounds(170, 80, 75, 25);
		
		btnApurar = new JButton ("Apuração dos Votos");
		btnApurar.setBounds(10, 260, 250, 25);
		
		lblTotal = new JLabel ("Total de votos");
		lblTotal.setBounds(10, 290, 250, 25);
		labelTotalVotacao = new JLabel ("--");
		labelTotalVotacao.setBounds(170, 290, 30, 25);
		
		lblTotalBranco = new JLabel ("Total em branco");
		lblTotalBranco.setBounds(10, 310, 350, 25);
		labelTotalVotoBranco = new JLabel("--");
		labelTotalVotoBranco.setBounds(170, 310, 30, 25);
		
		lblCandidato1 = new JLabel ("Votos em candidato 1");
		lblCandidato1.setBounds(10, 330, 250, 25);
		labelTotalVotoCandidato1 = new JLabel("--");
		labelTotalVotoCandidato1.setBounds(170, 330, 30, 25);
		
		lblCandidato2 = new JLabel ("Votos em candidato 2");
		labelTotalVotoCandidato2 = new JLabel("--");
		labelTotalVotoCandidato2.setBounds(170, 350, 30, 25);
		lblCandidato2.setBounds(10, 350, 250, 25);
		
		ctn.add(btnVotar);
		ctn.add(btnApurar);
		ctn.add(lblCandidato);
		ctn.add(txtVoto);
		ctn.add(lblNome);
		ctn.add(lblNome1);
		ctn.add(lblNome2);
		ctn.add(lblNome3);
		ctn.add(lblTotal);
		ctn.add(lblTotalBranco);
		ctn.add(lblCandidato1);
		ctn.add(lblCandidato2);
		ctn.add(labelTotalVotacao);
		ctn.add(labelTotalVotoCandidato1);
		ctn.add(labelTotalVotoCandidato2);
		ctn.add(labelTotalVotoBranco);
		ctn.add(lblMensagemVotacao);
		
		btnVotar.addActionListener (this);
		btnApurar.addActionListener(this);
		
		objetoVotacao = new Votacao();
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (e.getActionCommand().equals("Votar"))
		{
			
			int numero = Integer.parseInt(txtVoto.getText());
			int resultado = objetoVotacao.Votar(numero);
			
			if (resultado == 1) {
				lblMensagemVotacao.setText("Voto computado com sucesso!");
			} else {
				lblMensagemVotacao.setText("Erro! Candidato inválido.");
			}
			
			txtVoto.setText("");
			
		}
		
		if (e.getActionCommand().equals("Apuração dos Votos"))
		{
			labelTotalVotacao.setText(Integer.toString(objetoVotacao.getTotalVotos()));
			labelTotalVotoBranco.setText(Integer.toString(objetoVotacao.getVotoBranco()));
			labelTotalVotoCandidato1.setText(Integer.toString(objetoVotacao.getCandidato1()));
			labelTotalVotoCandidato2.setText(Integer.toString(objetoVotacao.getCandidato2()));
		}
		
	}

	public static void main(String[] args)
	{

		InterfacePrincipal telaInicial = new InterfacePrincipal();
		
	}

}