public class Q4_b {
    public class MyThread extends Thread{
        private int tid;
        private int startValue, endValue, inc;
        private double z;
        public MyThread(int tid, int sv, int ev){
            this.tid=tid;
            this.startValue=sv;
            this.endValue=ev;
// Write your code here
            inc = 3; // increment
            z = 1.0;

        }
        public void run(){
// Write your code here to compute partial z
            
            while(startValue <= endValue){
                z=z*(1.0/startValue);
                startValue+=3;
            }


        }
        public double get_z(){return z;}

    }
        public void main(String[] args) {
            Thread t1 = new MyThread(1, 5, 14);
            Thread t2 = new MyThread(2, 17, 26);
            Thread t3 = new MyThread(3, 29, 38);
            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try {
                t3.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if(!t1.isAlive() && !t2.isAlive() && !t3.isAlive()){
                double r = ((MyThread)t1).get_z();
// Write your code here to compute final z
                r*= ((MyThread)t2).get_z();
                r*= ((MyThread)t3).get_z();

                System.out.println(r);

            }
        }

}
