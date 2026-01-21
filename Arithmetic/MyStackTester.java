public class MyStackTester {
    
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();

        s.push("Derp");
        s.push("Hi");

        //System.out.println(s);

        String str = s.peek();

        System.out.println(str);

        str = s.pop();

        System.out.println(str);

        String str2 = s.peek();

        System.out.println(str2);

        System.out.println(s.empty());

        s.pop();

        System.out.println(s.empty());





    }
}
