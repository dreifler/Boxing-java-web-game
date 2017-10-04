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
public class Boxer {
    String name;
    int age;
    //Fighter abilities that are visible to the player
    //Starting abilities are set by the fighter style
    private int str; //physical strength
    private int spd; //hand speed
    private int agl; //footwork
    private int cnd = 0; //aerobic/aerobic conditioning (must be trained from 0)
    private int ftg = 100; //fighters current fatigue level (100 fully rested)
    
    //Hidden abilities common to all fighters. Expand on these over time.
    //Add unique hiddens for sub-classes
    private int tgh; //fighter toughness, ability to withstand KOs and take damage
    private int lrn; //fighters general intelligence and learning speed
    private int pwr; //punching power effects stun/KO
    private int chn; //ability to take punches, effects stun/KO
    
    //Sub classes will have learnable skills unique to that class

    //Look into using an enum for the different types of boxers
    //build can be created using a selection associated with the enum
    {
        CreateHiddens();
        CreateAbilities();
    }
    
    Boxer(){ }
    
    Boxer(String name,BoxerStyle style) {
        this.name = name;
        switch (style) {
            case SLUGGER:
                str = 60;
                spd = 30;
                agl = 30;
                break;
            case DANCER:
                str = 30;
                spd = 60;
                agl = 30;
                break;
            case BALANCED:
                str = 40;
                spd = 40;
                agl = 40;
                break;
            case ROPIST:
                str = 30;
                spd = 30;
                agl = 30;
                break;
        }
    }
    
    //

    public void CreateHiddens() {
        tgh = AbilityGen();
        lrn = AbilityGen();
        pwr = AbilityGen();
        chn = AbilityGen();
    }
    
    public void CreateAbilities() {
        
    }
    
    public int AbilityGen() {
        int rand = (int)Math.random()*100;
        
        return rand;
    }
    
    //Getter and Setter Methods
    public int GetStr() {
        return str;
    }
    
    public int GetSpd() {
        return spd;
    }
    
    public int GetAgl() {
        return agl;
    }
    
    public int GetCnd() {
        return cnd;
    }
    
    public int GetFtg() {
        return ftg;
    }
    
    public int GetTgh() {
        return tgh;
    }
    
    public int GetLrn() {
        return lrn;
    }
    
    public int GetPwr() {
        return pwr;
    }
    public int GetChn() {
        return chn;
    }
    
    public void SetStr(int str) {
        this.str = str;
    }
    
    public void SetSpd(int spd) {
        this.spd = spd;
    }
    
    public void SetAgl(int agl) {
        this.agl = agl;
    }
    
    public void SetCnd(int cnd) {
        this.cnd = cnd;
    }
    
    public void SetFtg(int ftg) {
        this.ftg = ftg;
    }
    
    public void SetTgh() {
        this.tgh = tgh;
    }
    
    public void SetLrn() {
        this.lrn = lrn;
    }
    
    public void SetPwr() {
        this.pwr = pwr;
    }
    public void SetChn() {
        this.chn = chn;
    }
    
}
