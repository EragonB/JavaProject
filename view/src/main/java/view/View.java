package view;


public final class View {
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};
	
	String Contenu = "Coucou";
	
	public View() {
		for(int x = 0; x<2; x++) {
			for(int y = 0; y<3; y++) {
				System.out.print(Tableau[x][y]);
			}
			
			System.out.println();
		}
		
		System.out.println(Contenu);
	}
	
}
