package aula_03;

public class Votacao
{

	private int Candidato1;
	private int Candidato2;
	private int VotoBranco;
	private int TotalVotos;
	
	public Votacao() {
		Candidato1 = 0;
		Candidato2 = 0;
		VotoBranco = 0;
		TotalVotos = 0;
	}
	
	public int Votar (int Voto)
	{
		switch (Voto)
		{
			case 1: Candidato1++;
					break;
			case 2: Candidato2++;
					break;
			case 3: VotoBranco++;
					break;
			default: return -1;
		}
	
	
		TotalVotos++;
	
		return 1;
	
	}
	
	public int getCandidato1() {
		return Candidato1;
	}
	
	public int getCandidato2() {
		return Candidato2;
	}
	
	public int getVotoBranco() {
		return VotoBranco;
	}
	
	public int getTotalVotos() {
		return TotalVotos;
	}
	
}