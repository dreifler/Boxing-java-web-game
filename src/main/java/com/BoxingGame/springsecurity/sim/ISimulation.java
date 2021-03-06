/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BoxingGame.springsecurity.sim;

import com.BoxingGame.springsecurity.entity.Boxer;

/**
 *
 * @author darrenreifler
 */
public interface ISimulation {
    
    void fightSim(IFighter b1, IFighter b2);
    
    void setf1Strategy(IFighter f1, int agg, int def);
    
    void setf2Strategy(IFighter f2, int agg, int def);
    
    IFighter rest(IFighter f1);
    
    IFighter GetF1();
    
    IFighter GetF2();
    
}
