public class Tester {

	public static void main(String[] args) {
		
		Grid m;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Grid m = new Grid();
				Grid.Board b = m.new Board();
				
				m.print();
				m.printBombs();
			}
		});
		
		//Grid g = new Grid(3, 3, 1);
		
		//Grid.Board b = g.new Board();
		
		

	}

}
