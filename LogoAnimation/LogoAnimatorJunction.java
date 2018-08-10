import java.io.PrintStream;

class LogoAnimatorJunction
{
private boolean flag1 = false;
private boolean flag2 = false;
LogoAnimator andyObj3; // creates object of LogoAnimator class

    
LogoAnimatorJunction(LogoAnimator paramLogoAnimator)
{
    // default constructor
}
public synchronized void pass(int andyInteger)
{
    if (andyInteger == 1)
    {
        this.flag1 = true;
        andyObj3.setflag1(true);
        if (!this.flag2)
        {
        try
        {
            System.out.println("Train 1 is waiting");
            wait();
        }
        catch (Exception localException1) {}
        }
        System.out.println("Train 1 has left the junction");
    }
    if (andyInteger == 2)
    {
        this.flag2 = true;
        andyObj3.setflag2(true);
        if (!this.flag1) {
        try
        {
            System.out.println("Train 2 is waiting");
            wait();
        }
        catch (Exception localException2) {
        }
    }
    System.out.println("Train 2 has left the junction");
    }
notify();
}
}

