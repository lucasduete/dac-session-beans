package io.github.lucasduete.dac.sessionbeans.shared.services;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContatoLocator {
    private static final String SERVICE_REMOTE = "java:global/core/ContatoService";

    public ContatoServiceInterface lookup() {
        try {
            Properties properties = new Properties();
            properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("org.omg.CORBA.ORBInitialHost", "core");
            properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            Context context = new InitialContext(properties);
            return (ContatoServiceInterface) context.lookup(SERVICE_REMOTE);
        } catch (NamingException ex) {
            Logger.getLogger(ContatoLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
