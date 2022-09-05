

import java.awt.Image;
import java.awt.Toolkit;

public class Item001 extends Item{
    public Item001(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub
        this.width=30;
        this.height=30;
        this.images=new Image[] {
                Toolkit.getDefaultToolkit().getImage("star01.png"),
                Toolkit.getDefaultToolkit().getImage("star02.png"),
                Toolkit.getDefaultToolkit().getImage("star03.png"),
                Toolkit.getDefaultToolkit().getImage("star04.png"),
                Toolkit.getDefaultToolkit().getImage("star05.png"),
                Toolkit.getDefaultToolkit().getImage("star06.png"),
                Toolkit.getDefaultToolkit().getImage("star07.png"),
                Toolkit.getDefaultToolkit().getImage("star08.png"),
                Toolkit.getDefaultToolkit().getImage("star09.png"),
        };
        this.imageSpeed=(int)(Math.random()*20+5);
        this.speed=3;
    }

}
