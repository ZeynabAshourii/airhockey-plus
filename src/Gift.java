package src;

import java.awt.*;

public class Gift extends Rectangle {
    int type;
    int nafar;

    public Gift(int x, int y, int width, int height, int type , int nafar) {
        super(x, y, width, height);
        this.type = type;
        this.nafar = nafar;
    }
}
