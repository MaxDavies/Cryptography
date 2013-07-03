/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author kevin.lawrence
 */
public class ParserFactory {
    public static Parser WhitespaceRemover(){
        return new Replacer(" ", "");
    }
    
}
