public class Class {
    private static int count = 0;
    public static void main(String[] args){
        while(count < 100){
            try{
                Thread.sleep(500);
                System.out.println("Tomasz Potato");
                count++;
                } catch(InterruptedException ie){
                    ie.printStackTrace();
                }
        }
    }
}