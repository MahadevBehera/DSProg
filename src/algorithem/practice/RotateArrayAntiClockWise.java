package algorithem.practice;
//Rotate the Array 
public class RotateArrayAntiClockWise {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		int result[]=rotate(arr, 3);
		
		for (int i : result) {
			System.out.print(i+", ");
		}
	}
	
	static int[] rotate(int arr[], int n) {
		int length = arr.length;
		n = n % length;
		if(n == 0) {
		return arr;
		}
		int temp[]= new int[length];
//		System.arraycopy(arr, n, temp, 0, length - n);//predefined native method
//		System.arraycopy(arr, 0, temp, length-n, n);
		arrayCopy(arr, n, temp, 0, length - n);
		arrayCopy(arr, 0, temp, length-n, n);
		return temp;
	}
	
	//to copy 2 int array 
	static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int len) {
		int arr1[]=null;
		int arr2[]=null;
		if(src instanceof int[]) {
		arr1 = (int[])src; 
		}
		if(dest instanceof int[]) {
		arr2 = (int[])dest; 
		}
		int counter = 0; 
		for(int i = srcPos; counter < len; i++,counter++ ) {
			if(i > arr1.length) {
				break;
			}
			arr2[destPos] = arr1[i];
			destPos++;
		}
		
	}

}
