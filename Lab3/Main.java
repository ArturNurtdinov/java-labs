public class Main {
    public static void main(String[] args) {
        //just some tests
        try {
            UndoStringBuilder sb = new UndoStringBuilder("Artur");
            sb.append(500);
            sb.append("dasd");
            sb.insert(0, 5123.33);
            System.out.println(sb.length()); //19
            System.out.println(sb.undo().length()); //12
            System.out.println(sb.undo().length()); //8
            System.out.println(sb.undo().length()); //5 - Artur

            sb.deleteCharAt(2);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.setCharAt(0, 'J');
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.delete(0, 5);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());


            sb.reverse();
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.insert(1, "333", 0, 3);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.append("DSADASD");
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.replace(0, 2, "ARTTTT");
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.setCharAt(4, 'J');
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.insert(4, 123456789);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.append(3231231);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.insert(3, "asd");
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.append(32312.3323);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.insert(2, 33231.222);
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

            sb.insert(2, 'q');
            System.out.println(sb.toString());
            System.out.println(sb.undo().toString());

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
            System.out.println(sb.undo().toString());
            System.out.println(sb.undo().toString());
            System.out.println(sb.undo().toString());
            System.out.println(sb.undo().toString());
            System.out.println(sb.undo().toString());
            System.out.println(sb.undo().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
