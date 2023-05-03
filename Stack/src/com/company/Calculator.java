package com.company;

public class Calculator {
    Item[] expr;
    int ip;
    Stack stack; //switch to normal

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new DynamicStack(); //switch to normal
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.getType()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE: {
                stack.push(nxt.getValue());
                break;
            }
            case MOD10: {
                int x = stack.pop();
                stack.push(x%10);
                break;
            }
            case WEIRD_MUL: {
                int y = stack.pop();
                int x = stack.pop();

                if(x*y>9)
                    stack.push((x*y)%10+(x*y)/10);
                else
                    stack.push(x * y);
                break;
            }
        }
    }
}
