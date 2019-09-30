public interface TaskContract {
    interface Task1{
        int[][] createMatrix(int n, int m);
        void printMatrix(int[][] matrix);
    }

    interface Task2{
        String[] splitAndReplace(String s);
        void printArray(String[] strings);
    }

    interface Task3{
        void printMenu();
        Book readBook();
        int readCode();
        int readIndex();
        int readNumber();
        String readAuthor();
        String readName();
        int readReleaseDate();
    }
}
