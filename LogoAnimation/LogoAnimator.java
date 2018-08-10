import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LogoAnimator
extends JPanel
{
    int train1Distance = 0;
    int train2Distance = 0;
    boolean flag1 = false;
    boolean flag2 = false;
    public ImageIcon train2;
    public ImageIcon train21;
    public ImageIcon train4;
    public ImageIcon train41;
    public ImageIcon cross;
    public ImageIcon green;
    public ImageIcon red;
    Junction j;
    LogoAnimator.Train one;
    LogoAnimator.Train two;
    URL url;

    
    public LogoAnimator() // default constructor for Logo Animator Class!
    {
        this.j = new Junction();
        this.one = new LogoAnimator.Train(1, this.j);
        this.two = new LogoAnimator.Train(2, this.j);
        this.one.start();
        this.two.start();
        
        initializeAnimation();
        setBackground(Color.white);
    }
    
    protected void initializeAnimation()
    {
        this.train2 = new ImageIcon(getClass().getResource("train2.gif"));
        this.train21 = new ImageIcon(getClass().getResource("train21.gif"));
        this.train4 = new ImageIcon(getClass().getResource("train4.gif"));
        this.train41 = new ImageIcon(getClass().getResource("train41.gif"));
        this.cross = new ImageIcon(getClass().getResource("crossing3.gif"));
        this.green = new ImageIcon(getClass().getResource("greensignal.gif"));
        this.red = new ImageIcon(getClass().getResource("redsignal.gif"));
    }
    
    public void setDis1(int paramInt)
    {
        this.train1Distance = paramInt;
        repaint();
    }
    
    public void setDis2(int paramInt)
    {
        this.train2Distance = paramInt;
        repaint();
    }
    public void setflag1(boolean paramBoolean)
    {
        this.flag1 = paramBoolean;repaint();
    }
    public void setflag2(boolean paramBoolean)
    {
        this.flag2 = paramBoolean;repaint();
    }
    
    public void paintComponent(Graphics paramGraphics)
    {
        super.paintComponent(paramGraphics);
        this.cross.paintIcon(this, paramGraphics, 475, 20);
        if (this.train1Distance < 400) {
            this.red.paintIcon(this, paramGraphics, 570, 400);
        } else {
            this.green.paintIcon(this, paramGraphics, 570, 400);
        }
        if (this.train2Distance < 400) {
            this.red.paintIcon(this, paramGraphics, 425, 200);
        } else {
            this.green.paintIcon(this, paramGraphics, 425, 200);
        }
        if (this.train1Distance < 400) {
            this.train2.paintIcon(this, paramGraphics, 800 - this.train1Distance, 220);
        } else if (!this.flag2) {
            this.train21.paintIcon(this, paramGraphics, 800 - this.train1Distance, 220);
        } else if (this.flag2) {
            this.train2.paintIcon(this, paramGraphics, 800 - this.train1Distance, 220);
        }
        if (this.train2Distance < 400) {
            this.train4.paintIcon(this, paramGraphics, this.train2Distance, 450);
        } else if (!this.flag1) {
            this.train41.paintIcon(this, paramGraphics, this.train2Distance, 450);
        } else if (this.flag1) {
            this.train4.paintIcon(this, paramGraphics, this.train2Distance, 450);
        }
    }
    
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(600, 600);
    }
    
    public static void main(String[] paramArrayOfString)
    {
        LogoAnimator localLogoAnimator = new LogoAnimator();
        JFrame localJFrame = new JFrame("Train Animator");
        Container localContainer = localJFrame.getContentPane();
        localContainer.add(localLogoAnimator);
        localJFrame.setDefaultCloseOperation(3);
        localJFrame.setSize(1200, 1000);        
        localJFrame.setVisible(true);
    }
    
class Train
    extends Thread
    {
        int number;
        Junction signal;
        int dis = 0;
        int count = 0;
        
        public Train(int paramInt, Junction paramJunction)
        {
            this.number = paramInt;
            this.signal = paramJunction;
            SecureRandom localSecureRandom = new SecureRandom();
            this.count = (1 + localSecureRandom.nextInt(2));
        }
        
        public void run()
        {
            while (this.dis != 1400)
            {
                this.dis += 1;
                if (this.number == 1) {
                    LogoAnimator.this.setDis1(this.dis);
                } else {
                    LogoAnimator.this.setDis2(this.dis);
                }
                if (this.dis == 400) {
                    this.signal.pass(this.number);
                }
                try
                {
                    if (this.number == 1) {
                        Thread.sleep((int)(Math.random() * this.count * 70.0D));
                    } else {
                        Thread.sleep((int)(Math.random() * this.count * 70.0D));
                    }
                }
                catch (Exception localException) {}
            }
        }
    }
}
