package Sorted;

import java.util.Random;

class Bench {
	public static boolean search_unsorted(int[] array, int key) {
		for (int index = 0; index < array.length ; index++) {
			if (array[index] == key) {
				return true;
			}
		}
		return false;
	}

	public static boolean improved_search_unsorted(int[] array, int key) {
		for (int index = 0; index < array.length ; index++) {
			if (array[index] == key) {
				return true;
			}
			else if (array[index] < key){
				return false;
			}
		}
		return false;
	}

    private static void linear(int[] array, int[] index) {
		for (int i = 0; i < index.length ; i++) {
	    	Linear.search(array, index[i]);
		}
    }
    

    private static void binary(int[] array, int[] index) {
		for (int i = 0; i < index.length ; i++) {
	    	Binary.search(array, index[i]);
		}
    }

	private static void binary2(int[] array, int[] array2) {
		int pointer1 = 0;
		int pointer2 = 0;

		while (pointer1 < array.length && pointer2 < array2.length)
		if (array[pointer1] == array2[pointer2]){
			pointer1++;
			pointer2++;
		} else if (array[pointer1] < array2[pointer2]) {
			pointer1++;
		} else {
			pointer2++;
		}
	}

    private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = rnd.nextInt(10);

		for (int i = 0; i < n ; i++) {
	    	array[i] = nxt;
	    	nxt += rnd.nextInt(10) + 1 ;
		}
	return array;
    }


    private static int[] keys(int loop, int n) {
		Random rnd = new Random();
		int[] index = new int[loop];
		for (int i = 0; i < loop ; i++) {
	    	index[i] = rnd.nextInt(n*5);
		}
		return index;
    }

    
    public static void main(String[] arg) {
		int[] sizes = {100, 200, 400, 800, 1600, 3200};
		/*
		//int[] sizes = {100, 200, 400, 800, 1600, 3200};
		int[] sizes = {100, 1000, 10000, 100000, 1000000, 64000000};
		Random rand = new Random();

		for (int j = 0; j < 1000; j++){



		}


		for (int i = 0; i < sizes.length; i++){
			int[] array = new int[sizes[i]];
			long t0 = System.nanoTime();
			search_unsorted(array, 1);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			System.out.print("n: " + sizes[i] + " ");
			System.out.printf("%8.0f\n" , t / Math.pow(10, 3));
		}




		for (int i = 0; i < sizes.length; i++){
			int[] array = sorted(sizes[i]);

			double time = 0;
			int key = 0;

			for (int j = 0; j < 1000; j++){
				key = rand.nextInt(sizes[i]);
				long t0 = System.nanoTime();
				improved_search_unsorted(array, key);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				time += t;
			}

			time = time/1000;

			System.out.println("n: " + sizes[i] + " " + time);
		}




		System.out.printf("# searching through an unsorted array of length n, time in ns\n");
		System.out.println("n time");
		for (int i = 0; i < sizes.length; i++){
			int[] array = new int[sizes[i]];

			for (int j = 0; j < sizes[i]; j++) {
				array[j] = rand.nextInt(sizes[i]);
			}

			double time = 0;
			int key = 0;

			for (int j = 0; j < 1000; j++){
				key = rand.nextInt(sizes[i]);
				long t0 = System.nanoTime();
				search_unsorted(array, key);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				time += t;
			}

			time = time/1000;

			System.out.println("n: " + sizes[i] + " " + time);

		}

		*/


		System.out.printf("# searching through an array of length n, time in ns\n");
		//System.out.printf("#%7s%8s\n", "n", "binary");

		System.out.printf("#%7s%8s%8s%8s\n", "n", "linear", "binary", "final version");
		for ( int n : sizes) {

			int loop = 10000;

			int[] array = sorted(n);
			int[] array2 = sorted(n);
			//for (int i = 0; i < n; i++) {
			//	array[i] = rand.nextInt(n);
			//}

			int[] indx = keys(loop, n);
			System.out.printf("%8d", n);

			int k = 1000;

			double min = Double.POSITIVE_INFINITY;



			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			//linear(array, indx);
			for (int j = 0; j < array.length; j++){
				linear(array, array2);
			}
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}




			System.out.printf("%8.0f", (min/loop));




			min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			binary(array, indx);
			//for (int j = 0; j < array.length; j++){
			//  binary(array, array2);
			//}
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}

			//System.out.printf("%8.0f" , (min/loop));
			System.out.printf("%8.0f\n" , (min/loop));



			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int j = 0; j < array.length; j++){
					binary2(array, array2);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
			}

			System.out.printf("%8.0f\n" , (min/loop));


		}
	}
}