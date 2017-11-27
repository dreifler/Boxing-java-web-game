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
public interface Fighter {

    int AbilityGen();

    void CreateAbilities();

    void CreateHiddens();

    int GetAgl();

    int GetCnd();

    int GetFtg();

    String GetName();

    int GetPwr();

    int GetSpd();

    int GetStr();

    Style GetStyle();

    int GetTgh();

    void SetAgl(int agl);

    void SetCnd(int cnd);

    void SetFtg(int ftg);

    void SetPwr();

    void SetSpd(int spd);

    void SetStr(int str);

    void SetTgh();
    
}
