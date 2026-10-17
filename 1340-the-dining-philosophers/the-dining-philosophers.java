class DiningPhilosophers {

    private final Object[] forks=new Object[5];

    public DiningPhilosophers() {
        for(int i=0;i<5;i++){
            forks[i]=new Object();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left=philosopher;
        int right=(philosopher+1)%5;

        int first=Math.min(left,right);
        int second=Math.max(left,right);
        
        synchronized(forks[first]){
            synchronized(forks[second]){

                pickLeftFork.run();
                pickRightFork.run();

                eat.run();

                putLeftFork.run();
                putRightFork.run();
            }
        }
        
    }
}