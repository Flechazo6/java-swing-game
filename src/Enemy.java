
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



public class Enemy {
    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;

    //width，height是敌机宽度与高度
    public int width;
    public int height;

    //x，y是敌机的坐标
    public int x;
    public int y;

    public Image image;


    public int hp; //敌机的生命值

    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public void drawSelf(Graphics g) {

    }

    //移除死掉或者飞出界面的敌机
    public void killed() {
        this.myPanel.enemys.remove(this);
    }

    //敌机处在被攻击状态，其生命值减少
    public void underAttack() {
        if(hp>0) {
            hp--;
        }
    }



}


