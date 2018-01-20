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

    int GetAgg();

    int GetAgl();

    int GetCnd();

    int GetDef();

    String GetName();

    int GetSpd();

    int GetStr();

    Style GetStyle();
    
    Action getCurrent();

    void SetAgg(int agg);

    void SetAgl(int agl);

    void SetCnd(int cnd);

    void SetDef(int def);

    void SetSpd(int spd);

    void SetStr(int str);
    
    void selectAction();
    
    boolean landed();

	void SetOpponent(IFighter opp);

	IFighter GetOpponent();

	int GetID();
    
}
