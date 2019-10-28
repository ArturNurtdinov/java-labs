public class Main {
    public static void main(String[] args) {
        //just some tests
        UndoStringBuilder sb = new UndoStringBuilder("Artur");
        sb.append(500);
        sb.append("dasd");
        sb.insert(0, 5123.33);
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());

        sb.deleteCharAt(4);
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());

        sb.setCharAt(0, 'J');
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());

        sb.delete(0, 5);
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());


        sb.reverse();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());

        //tests with big stack
        System.out.println("-----------------------------------------");
        sb = new UndoStringBuilder("Test");
        System.out.println(sb.toString());
        sb.deleteCharAt(2);
        System.out.println(sb.toString());
        sb.append("333");
        System.out.println(sb.toString());
        sb.insert(4, "alo11");
        System.out.println(sb.toString());
        sb.setCharAt(0, 'R');
        System.out.println(sb.toString());
        sb.delete(3, 5);
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
        //now after 6 undo operations we should get back our "Test" string
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
        sb.undo();
        System.out.println(sb.toString());
    }
}
