class H2O {

    private Semaphore hydrogen=new Semaphore(2);
    private Semaphore oxygen=new Semaphore(0);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hydrogen.acquire();
        releaseHydrogen.run();
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxygen.acquire(2);
		releaseOxygen.run();
        hydrogen.release(2);

    }
}