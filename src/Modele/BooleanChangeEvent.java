/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.EventObject;

/**
 *
 * @author Etienne
 */
//Source : https://askcodez.com/java-ecouteur-devenement-a-detecter-un-changement-de-variable.html
/**
 * This class lets the listener know when the change occured and what object was
 * changed.
 */
public class BooleanChangeEvent extends EventObject {

    private final BooleanChangeDispatcher dispatcher;

    public BooleanChangeEvent(BooleanChangeDispatcher dispatcher) {
        super(dispatcher);
        this.dispatcher = dispatcher;
    }
//type safe way to get source (as opposed to getSource of EventObject

    public BooleanChangeDispatcher getDispatcher() {
        return dispatcher;
    }
}
