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
public class Boxer implements IFighter {
    private String name;
    private Style style;
    //Fighter abilities that are visible to the player
    //Starting abilities are set by the fighter style
    private int str,spd, agl; //physical abilities
    private int cnd = 0; //aerobic/aerobic conditioning (must be trained from 0)
    private int ftg = 100; //fighters current fatigue level (100 fully rested)
    
    //Hidden abilities common to all fighters. Expand on these over time.
    //Add unique hiddens for sub-classes
    private int tgh; //fighter toughness, ability to withstand KOs and take damage
    private int pwr; //punching power effects stun/KO
    
    //Variables for use during fight sim
    private int agg, def;
    private IFighter opponent;
    private Action cAction;
    
    //Sub classes will have learnable skills unique to that class

    //Look into using an enum for the different types of boxers
    //build can be created using a selection associated with the enum
     
    Boxer(String name, Style style) {
        this.name = name;
        this.style = style;
        CreateAbilities();
        CreateHiddens();
    }
    
    @Override
    public void CreateHiddens() {
        tgh = AbilityGen();
        pwr = AbilityGen();
    }
    
    @Override
    public void CreateAbilities() {
        switch (this.style) {
            case SLUGGER:
                this.str = 60;
                this.spd = 30;
                this.agl = 30;
                break;
            case DANCER:
                this.str = 30;
                this.spd = 60;
                this.agl = 30;
                break;
            case BALANCED:
                this.str = 40;
                this.spd = 40;
                this.agl = 40;
                break;
        }
    }
    
    @Override
    public int AbilityGen() {
        int rand = (int)(Math.random()*100);
        
        return rand;
    }
    
    //Getter and Setter Methods
    @Override
    public String GetName() {
        return name;
    }
    
    @Override
    public Style GetStyle() {
        return style;
    }
    
    @Override
    public int GetStr() {
        return str;
    }
    
    @Override
    public int GetSpd() {
        return spd;
    }
    
    @Override
    public int GetAgl() {
        return agl;
    }
    
    @Override
    public int GetCnd() {
        return cnd;
    }
    
    @Override
    public int GetFtg() {
        return ftg;
    }
    
    @Override
    public int GetTgh() {
        return tgh;
    }
    
    @Override
    public int GetPwr() {
        return pwr;
    }
    
    @Override
    public int GetAgg() {
       return agg;
    }
    
    @Override
    public int GetDef() {
        return def;
    }

    @Override
    public IFighter GetOpponent() {
        return opponent;
    }
    
    @Override
    public Action getCurrent() {
        return cAction;
    }
    
    @Override
    public void SetStr(int str) {
        this.str = str;
    }
    
    @Override
    public void SetSpd(int spd) {
        this.spd = spd;
    }
    
    @Override
    public void SetAgl(int agl) {
        this.agl = agl;
    }
    
    @Override
    public void SetCnd(int cnd) {
        this.cnd = cnd;
    }
    
    @Override
    public void SetFtg(int ftg) {
        this.ftg = ftg;
    }
    
    @Override
    public void SetTgh() {
        this.tgh = tgh;
    }
    
    @Override
    public void SetPwr() {
        this.pwr = pwr;
    }
    
    @Override
    public void SetAgg(int agg) {
        this.agg = agg;
    }

    @Override
    public void SetDef(int def) {
        this.def = def;
    }

    public void SetOpponent(Boxer boxer) {
        this.opponent = boxer;
    }

    @Override
    public void SetOpponent(IFighter opp) {
        this.opponent = opp;
    }

    @Override
    public void selectAction() {
             double punch;
       
       punch = Math.random()*100;
       if(punch < GetAgg()*10)
           cAction = Action.PUNCH;
       else cAction = Action.DEFEND;
    }

    @Override
    public boolean landed() {
        if((GetSpd()*Math.random() - GetOpponent().GetDef()*Math.random()) > 0)
            return true;
        else return false;
    }


    
}
