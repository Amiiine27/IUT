
public class Conversion {

	public static void main(String[] args) {
		afficherFenC(30);
	}
	
		 // 1)
		public static void afficherFenC(double f) {
			double result;
			result=(f-32)*5.0/9.0;
			System.out.println(result);
		}
}
