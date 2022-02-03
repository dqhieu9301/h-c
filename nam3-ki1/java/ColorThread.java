package bai1;

public class ColorThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            switch(i) {
                case 0:
                    System.out.println("do");
                    break;
                case 1:
                    System.out.println("vang");
                    break;
                default:
                    System.out.println("xanh");
                    break;
            }
            i++;
            if(i == 3) {
                i = 0;
            }
        }
    }
}
