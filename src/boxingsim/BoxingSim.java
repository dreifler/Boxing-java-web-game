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
public class BoxingSim implements ISimulation{
    private IFighter f1, f2;
    
    @Override
    public void fightSim(IFighter f1, IFighter f2) {
        this.f1 = f1;
        this.f2 = f2;
        this.f1.SetOpponent(f2);
        this.f2.SetOpponent(f1);
    }

    @Override
    public void setf1Strategy(IFighter f1, int agg, int def) {
        this.f1.SetAgg(agg);
        this.f1.SetDef(def);
    }
    
    @Override
    public void setf2Strategy(IFighter f2, int agg, int def) {
        this.f2.SetAgg(agg);
        this.f2.SetDef(def);
    }

    @Override
    public IFighter rest(IFighter f1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IFighter GetF1() {
        return f1;
    }

    @Override
    public IFighter GetF2() {
        return f2;
    }
    
    
}
