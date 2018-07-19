/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lucasduete.dac.sessionbeans.jse;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author aguirresabino
 */
public class ContatoLocator {
    private static final String SERVICE_REMOTE = "java:global/core/ContatoDao";

    public <T> T lookup() {
        try {
            Properties properties = new Properties();
            properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            Context context = new InitialContext(properties);
            return (T) context.lookup(SERVICE_REMOTE);
        } catch (NamingException ex) {
            Logger.getLogger(ContatoLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
