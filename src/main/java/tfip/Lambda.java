package tfip;

public class Lambda {
    public static void main(String[] args) {
        MyRunnableInterface<Integer> addOperation = (a,b)->{
            return a + b;
        };
        MyRunnableInterface<Integer> minusOperation = (a,b)->{
            return a - b;
        };
        MyRunnableInterface<Integer> multiplyOperation = (a,b)->{
            return a * b;
        };
        MyRunnableInterface<String> concatenateString = (a,b)->{
            return a + b;
        };
        MyMessageInterface printString = (msg)->{
            System.out.println(msg);
        };
        System.out.println("addOperation: "+addOperation.process(1, 1));
        System.out.println("minusOperation: "+minusOperation.process(9, 3));
        System.out.println("multiplyOperation: "+multiplyOperation.process(3, 5));
        System.out.println("concatenateString: "+concatenateString.process("What ", "are you?"));
        printString.printMessage("Lets take a break!!!");
    }
}
