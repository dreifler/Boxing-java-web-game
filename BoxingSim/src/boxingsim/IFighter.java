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

    void CreateHiddens();

    int GetAgg();

    int GetAgl();

    int GetCnd();

    int GetDef();

    int GetFtg();

    String GetName();

    IFighter GetOpponent();

    int GetPwr();

    int GetSpd();

    int GetStr();

    Style GetStyle();

    int GetTgh();

    void SetAgg(int agg);

    void SetAgl(int agl);

    void SetCnd(int cnd);

    void SetDef(int def);

    void SetFtg(int ftg);

    void SetOpponent(IFighter opp);

    void SetPwr();

    void SetSpd(int spd);

    void SetStr(int str);

    void SetTgh();
    
}
