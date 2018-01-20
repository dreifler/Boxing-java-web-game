/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxing.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import boxingsim.Action;
import boxingsim.IFighter;
import boxingsim.Style;

/**
 *
 * @author darrenreifler
 */
@Entity
@Table(name="Boxers")
public class Boxer implements IFighter {
	@Transient
    private Style style;
	@Transient
    private Action cAction;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private int ID;
	
	@Column(name="name")
    private String name;
	
    //Fighter abilities that are visible to the player
    //Starting abilities are set by the fighter style
	@Column(name="str")
    private int str;  
	@Column(name="spd")
    private int spd;  
	@Column(name="agl")
    private int agl; 
	@Column(name="cnd")
    private int cnd;
    
    //Used in fight simulation   
	@Transient
    private int agg;  
	@Transient
    private int def;
    
    //Sub classes will have learnable skills unique to that class

    //Look into using an enum for the different types of boxers
    //build can be created using a selection associated with the enum
     
    public Boxer(String name, Style style) {
        this.name = name;
        this.style = style;
        CreateAbilities();
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
 

    public int GetID(){
    		return ID;
    }
    
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
    public int GetAgg() {
       return agg;
    }
    
    @Override
    public int GetDef() {
        return def;
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
    @Column(name="agg")
    public void SetAgg(int agg) {
        this.agg = agg;
    }

    @Override
    @Column(name="def")
    public void SetDef(int def) {
        this.def = def;
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
	public String toString() {
		return "Boxer [style=" + style + ", ID=" + ID + ", name=" + name + ", str=" + str + ", spd=" + spd + ", agl="
				+ agl + ", cnd=" + cnd + ", ftg=" + "]";
	}

	@Override
	public boolean landed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void SetOpponent(IFighter opp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IFighter GetOpponent() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
