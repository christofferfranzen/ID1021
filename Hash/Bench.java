package Hash;

public class Bench {

    //public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\out\\production\\Inlämningar\\Hash\\postnummer.csv";
    public static final String file = "C:\\Users\\chris\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\Hash\\postnummer.csv";

    public static void main(String[] args) {
        //Zip zip = new Zip("C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\out\\production\\Inlämningar\\Hash\\postnummer.csv");

        /*

        {
            // Warm-up phase: call the method multiple times
            for (int i = 0; i < 10000; i++) {
                zip.linear("111 15");
            }

            for (int i = 0; i < 10000; i++) {
                zip.linear("111 15");
            }

            for (int i = 0; i < 10000; i++) {
                zip.binary("984 99");
            }

            for (int i = 0; i < 10000; i++) {
                zip.binary("984 99");
            }
        }

        int k = 10;

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            zip.linear("111 15");
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Linear search after 111 15 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            zip.binary("111 15");
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Binary search after 111 15 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            zip.linear("984 99");
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Linear search after 984 99 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            zip.binary("984 99");
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Binary search after 984 99 time: " + min);

         */

        /*

        intZip zip = new intZip("C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\out\\production\\Inlämningar\\Hash\\postnummer.csv");

        {
            // Warm-up phase: call the method multiple times
            for (int i = 0; i < 100000; i++) {
                zip.linear(11115);
            }

            for (int i = 0; i < 10000; i++) {
                zip.linear(11115);
            }

            for (int i = 0; i < 10000; i++) {
                zip.binary(98499);
            }

            for (int i = 0; i < 10000; i++) {
                zip.binary(98499);
            }
        }

        int k = 500;
        int n = 500;

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                zip.linear(11115);
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Linear search after 11115 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                zip.binary(11115);
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Binary search after 11115 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++){
                zip.linear(98499);
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Linear search after 98499 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                zip.binary(98499);
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Binary search after 98499 time: " + min);
         */

        /*

        keyZip keyZip = new keyZip("C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\out\\production\\Inlämningar\\Hash\\postnummer.csv");

        {
            // Warm-up phase: call the method multiple times
            for (int i = 0; i < 100000; i++) {
            keyZip.lookup("11115");
            }
            for (int i = 0; i < 100000; i++) {
                keyZip.lookup("98499");
            }
        }

        int k = 5;
        int n = 1;

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                keyZip.lookup("11115");
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Lookup after 11115 time: " + min);

        min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                keyZip.lookup("98499");
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        System.out.println("Lookup after 98499 time: " + min);

         */

        /*

        int[] values = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 12345, 13513, 13600, 14000};

        hashZip hashZip = new hashZip("C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\out\\production\\Inlämningar\\Hash\\postnummer.csv");

        for (int v : values){
            System.out.print("Modulo: ");
            hashZip.collisions(v);
        }

         */

        /*

        int[] values = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 12345, 13513, 13600, 14000};

        collisionsZip collisionsZip = new collisionsZip(file);

        for (int v : values){
            System.out.print("Modulo: ");
           collisionsZip.collisions(v);
        }

        collisionsZip.lookup("11115");

         */

        int[] values = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 12345, 13513, 13600, 14000};

        handelingZip handelingZip = new handelingZip(file);

        System.out.println(handelingZip.lookup("11115"));
    }
}
