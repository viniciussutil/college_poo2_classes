package aula_01;

import javax.swing.JFrame;

public class InterfaceGrafica extends JFrame
{
		public InterfaceGrafica()
		{
			setSize(400, 500);
			setTitle("Tela inicial");
			setVisible(true);
		}
		
		public static void main(String[] args)
		{
			InterfaceGrafica telainicial = new InterfaceGrafica();
		}
		
}