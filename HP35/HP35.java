package HP35;

class HP35{
    public static void main(String[] args) {

        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation


        StaticStack staticStack = new StaticStack(1024);
        DynamicStack dynamicStack = new DynamicStack();

        int[] n = {10, 100, 500, 1000, 2000, 4000, 8000};

        System.out.println("n\t\t static \t dynamic");

        for (int i = 0; i < n.length; i++){
            long s0 = System.nanoTime();
            bench(n[i], staticStack);
            long s1 = System.nanoTime();

            long d0 = System.nanoTime();
            bench(n[i], dynamicStack);
            long d1 = System.nanoTime();

            System.out.printf("%s\t\t%.2f\t%.2f%n", n[i], (double)(s1 - s0) * Math.pow(10, -6), (double)(d1 - d0) * Math.pow(10, -6));
        }

        /*

        Item[] expr = {
                new Item(ItemType.VALUE, 10),
                new Item(ItemType.VALUE, 2),
                new Item(ItemType.VALUE, 5),
                new Item(ItemType.MUL),
                new Item(ItemType.ADD)
        };

        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
        */
    }

    public static void bench(int ops, Stack stack){
        for (int i = 0; i < ops; i++){
            for (int j = 0; j < 1000; j++){
                stack.push(0);
            }

            for (int j = 0; j < 1000; j++){
                stack.pop();
            }
        }
    }
}