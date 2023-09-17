//Source : https://askcodez.com/java-ecouteur-devenement-a-detecter-un-changement-de-variable.html
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.EventListener;

/**
 *
 * @author Etienne
 */
public interface BooleanChangeListener extends EventListener {

    public void stateChanged(BooleanChangeEvent event);
}
