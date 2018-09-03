package pinduoduo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CopyKele {
    public static void main(String[] args) {
        String[] name = new String[]{"Alice", "Bob", "Cathy", "Dave"};
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Queue<String> queue = new LinkedList<>();
        queue.offer(name[0]);
        queue.offer(name[1]);
        queue.offer(name[2]);
        queue.offer(name[3]);
        String str = null;
        while (N > 0) {
            str = queue.poll();
            String copy = new String(str);
            queue.offer(str);
            queue.offer(copy);
            N--;
        }
        System.out.println(str);
    }
}
