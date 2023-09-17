//Source : https://askcodez.com/java-ecouteur-devenement-a-detecter-un-changement-de-variable.html
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Etienne
 */
interface BooleanChangeDispatcher {

    public void addBooleanChangeListener(BooleanChangeListener listener);

    public boolean getFlag();

    public void setFlag(boolean flag);
}
