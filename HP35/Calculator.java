package HP35;

public class Calculator {
    Item[] expr;
    int ip;
    DynamicStack dynamicStack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.dynamicStack = new DynamicStack();
    }

    public int run() {
        while ( ip < expr.length ) {
            step();
        }
        return dynamicStack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.getType()) {
            case ADD: {
                int y = dynamicStack.pop();
                int x = dynamicStack.pop();
                dynamicStack.push(x + y);
                break;
            }
            case SUB: {
                int y = dynamicStack.pop();
                int x = dynamicStack.pop();
                dynamicStack.push(x - y);
                break;
            }
            case MUL: {
                int y = dynamicStack.pop();
                int x = dynamicStack.pop();
                dynamicStack.push(x * y);
                break;
            }
            case DIV: {
                int y = dynamicStack.pop();
                int x = dynamicStack.pop();
                dynamicStack.push(x / y);
                break;
            }
            case VALUE: {
                dynamicStack.push(nxt.getValue());
            }
        }
    }
}
