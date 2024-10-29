package stacks;

public class Tester {
    public static void main(String[] args) {
        ArrayStack<Integer> demo = new ArrayStack<>(10);
        ArrayStack<String> stringDemo = new ArrayStack<>(10);
        ArrayStack<Double> dDemo = new ArrayStack<>(10);

        demo.push(10);
        demo.push(133);
        demo.pop();
        demo.push(13);
        System.out.println("Peek:" + demo.top());

        stringDemo.push("Musa Camara");
        stringDemo.push("Fatou Njie");
        stringDemo.pop();
        System.out.println("Peek "+ stringDemo.top());
    }
}
