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
public interface Boxertemp extends IFighter {

    @Override
	int AbilityGen();

    @Override
	void CreateAbilities();

    @Override
	void CreateHiddens();

    @Override
	int GetAgg();

    @Override
	int GetAgl();

    @Override
	int GetCnd();

    @Override
	int GetDef();

    @Override
	int GetFtg();

    //Getter and Setter Methods
    @Override
	String GetName();

    @Override
	IFighter GetOpponent();

    @Override
	int GetPwr();

    @Override
	int GetSpd();

    @Override
	int GetStr();

    @Override
	Style GetStyle();

    @Override
	int GetTgh();

    @Override
	void SetAgg(int agg);

    @Override
	void SetAgl(int agl);

    @Override
	void SetCnd(int cnd);

    @Override
	void SetDef(int def);

    @Override
	void SetFtg(int ftg);

    @Override
	void SetOpponent(IFighter opp);

    @Override
	void SetPwr();

    @Override
	void SetSpd(int spd);

    @Override
	void SetStr(int str);

    @Override
	void SetTgh();
    
}
