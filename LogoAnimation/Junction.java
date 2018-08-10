class Junction
{
    private boolean flag1 = false;
    private boolean flag2 = false;
    LogoAnimator andyObj;
    
    Junction()
    {
        // default constructor for the junction class
    }
    
    public synchronized void pass(int paramInt)
    {
        if (paramInt == 1)
        {
            this.flag1 = true;
            andyObj.setflag1(true);
            if (!this.flag2) {
                try
                {
                    System.out.println("Train 1 is waiting ");
                    wait();
                }
                catch (Exception localException1) {}
            }
            System.out.println("Train 1 leaves the junction");
        }
        if (paramInt == 2)
        {
            this.flag2 = true;
            andyObj.setflag2(true);
            if (!this.flag1) {
                try
                {
                    System.out.println("Train 2 is waiting ");
                    wait();
                }
                catch (Exception localException2) {}
            }
            System.out.println("Train 2 leaves the junction");
        }
        notify();
    }
}


