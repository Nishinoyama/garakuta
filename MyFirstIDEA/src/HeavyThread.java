public class HeavyThread extends Thread{
    private String name;
    private int interval;
    public HeavyThread(String name, int time){
        this.name = name;
        this.interval = time;
    }
    public void run(){
    }
}