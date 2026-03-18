package com.cosc210.models;

import java.util.ArrayList;

public interface Loadable {
    public int saveGame(ArrayList<GameProperties> properties,double money,String file);
    public int loadGame(ArrayList<GameProperties> thing,String file);
}
