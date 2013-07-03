/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
public class Remover implements Parser {
    
    //<editor-fold defaultstate="collapsed" desc="Parser Interface Methods">
    public String parse(String input) {
        String parsed = input;
        for (CharSequence target : getTargets()) {
            parsed = parsed.replace(target, "");
        }
        return parsed;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        setTargets(new ArrayList<CharSequence>());
}
    
    public Remover(ArrayList<CharSequence> targets){
        this.targets= targets;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<CharSequence> targets;
    
    /**
     * @return the targets
     */
    public ArrayList<CharSequence> getTargets() {
        return targets;
    }
    
    /**
     * @param targets the targets to set
     */
    public void setTargets(ArrayList<CharSequence> targets) {
        this.targets = targets;
    }
    //</editor-fold>
    
}
