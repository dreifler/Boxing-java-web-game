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
	@Transient
    private IFighter opponent;
	@Transient
    private Action cAction;
    
    //Sub classes will have learnable skills unique to that class

    //Look into using an enum for the different types of boxers
    //build can be created using a selection associated with the enum
	
	public Boxer() {
		
	};
     
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
    public int getID(){
    		return ID;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public Style getStyle() {
        return style;
    }
    
    @Override
    public int getStr() {
        return str;
    }
    
    @Override
    
    public int getSpd() {
        return spd;
    }
    
    @Override
   
    public int getAgl() {
        return agl;
    }
    
    @Override
    public int getCnd() {
        return cnd;
    }
    
    @Override
    public int getAgg() {
       return agg;
    }
    
    @Override
    public int getDef() {
        return def;
    }
    
    @Override
    public Action getCurrent() {
        return cAction;
    }
    
    @Override
    public IFighter getOpponent() {
        return opponent;
    }
    
    @Override
    public void setStr(int str) {
        this.str = str;
    }
    
    @Override
    public void setSpd(int spd) {
        this.spd = spd;
    }
    
    @Override
    public void setAgl(int agl) {
        this.agl = agl;
    }
    
    @Override
    public void setCnd(int cnd) {
        this.cnd = cnd;
    }
    
    @Override
    @Column(name="agg")
    public void setAgg(int agg) {
        this.agg = agg;
    }

    @Override
    @Column(name="def")
    public void setDef(int def) {
        this.def = def;
    }
    
    public void setOpponent(IFighter boxer) {
        this.opponent = boxer;
    }

    @Override
    public void selectAction() {
             double punch;
       
       punch = Math.random()*100;
       if(punch < getAgg()*10)
           cAction = Action.PUNCH;
       else cAction = Action.DEFEND;
    }

	@Override
	public boolean landed() {
		if((getSpd()*Math.random() - getOpponent().getDef()*Math.random()) > 0)
            return true;
        else return false;
	}
	
	@Override
	public String toString() {
		return "Boxer [style=" + style + ", ID=" + ID + ", name=" + name + ", str=" + str + ", spd=" + spd + ", agl="
				+ agl + ", cnd=" + cnd + "]";
	}

}
