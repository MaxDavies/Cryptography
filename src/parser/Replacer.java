/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author kevin.lawrence
 */
public class Replacer implements Parser {
    
    //<editor-fold defaultstate="collapsed" desc="Parser Interface Methods">
    public String parse(String input) {
        return input.replace(target, replacement);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Replacer(String target, String replacement){
        this.target = target;
        this.replacement = replacement;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String target;
    private String replacement;
    /**
     * @return the target
     */
    public String getTarget() {
        return target;
    }
    
    /**
     * @param target the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }
    
    /**
     * @return the replacement
     */
    public String getReplacement() {
        return replacement;
    }
    
    /**
     * @param replacement the replacement to set
     */
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }
    //</editor-fold>
    
}
