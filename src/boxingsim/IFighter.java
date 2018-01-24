/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingsim;

/**
 *
 * @author darrenreifler
 */
public interface IFighter {

    int AbilityGen();

    void CreateAbilities();

    int getAgg();

    int getAgl();

    int getCnd();

    int getDef();

    String getName();

    int getSpd();

    int getStr();

    Style getStyle();
    
    Action getCurrent();

    void setAgg(int agg);

    void setAgl(int agl);

    void setCnd(int cnd);

    void setDef(int def);

    void setSpd(int spd);

    void setStr(int str);
    
    void selectAction();
    
    boolean landed();

	void setOpponent(IFighter opp);

	IFighter getOpponent();

	int getID();
    
}
