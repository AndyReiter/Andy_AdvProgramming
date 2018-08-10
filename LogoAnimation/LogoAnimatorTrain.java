import java.security.SecureRandom;

class LogoAnimatorTrain extends Thread
{
    int number;

    LogoAnimator andyObj; // creating logo animator object called andyObj
    Junction andyObj2; // creating logo animation junction class object andyObj2
    
    
    int distance = 0;
    int count = 0;

    public LogoAnimatorTrain(LogoAnimator paramLogoAnimator, int paramInt, Junction paramJunction)
    {
        this.number = paramInt;
        this.andyObj2 = paramJunction;
        SecureRandom localSecureRandom = new SecureRandom();
        this.count = (1 + localSecureRandom.nextInt(2));
    }

    public void run()
    {
        while (this.distance != 1400)
        {
            this.distance += 1;
            if (this.number == 1) {
            andyObj.setDis2(this.distance);
        }
        else {
        andyObj.setDis1(this.distance);
        }
        if (this.distance == 400) {
            andyObj2.pass(this.number);
        }
        try
        {
            if (this.number == 1) {
                Thread.sleep((int)(Math.random() * this.count * 70.0D));
            }
            else {
                Thread.sleep((int)(Math.random() * this.count * 70.0D));
            }
        }
        catch (Exception localException) {}
        }
    }
}

