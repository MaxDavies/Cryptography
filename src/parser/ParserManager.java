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
public class ParserManager implements Parser {

    //<editor-fold defaultstate="collapsed" desc="Parser Interface Methods">
    public String parse(String input) {
        for (Parser parser : parsers) {
            input = parser.parse(input);
        }

        return input;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        setParsers(new ArrayList<Parser>());
    }

    public ParserManager() {
    }

    public ParserManager(ArrayList<Parser> parsers) {
        this.parsers = parsers;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<Parser> parsers;

    /**
     * @return the parsers
     */
    public ArrayList<Parser> getParsers() {
        return parsers;
    }

    /**
     * @param parsers the parsers to set
     */
    public void setParsers(ArrayList<Parser> parsers) {
        this.parsers = parsers;
    }
    //</editor-fold>
}
