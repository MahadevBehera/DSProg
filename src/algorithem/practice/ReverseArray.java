package algorithem.practice;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[] = new int[]{10,20,30,50,60};
		
		int i = 0;
		int j = arr.length -1 ;
		
		while( i < j ) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++ ;
			j-- ;
		}
		
		for (int k : arr) {
			System.out.print(k+" ");
		}
		System.out.println();
	}

}
