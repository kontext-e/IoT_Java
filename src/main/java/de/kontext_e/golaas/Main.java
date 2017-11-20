package de.kontext_e.golaas;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import de.kontext_e.golaas.jni.CallbackRegistry;
import de.kontext_e.golaas.jni.JniInterface;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // since the generated callbacks use log4j, it has to be initialized
        BasicConfigurator.configure();

        // first do some basic initialization on JNI C side
        // like storing a global reference to the JVM
        log("initialize", JniInterface.initialize());

        // register the Java callbacks for asynchronous
        // calls from the C side
        CallbackRegistry.registerCallbacks();

        // this may be used to check whether the
        // callbacks work basically which is a very basic
        // integration test
        // JniInterface.testCallbackCalls();

        // from here goe the protocol calls

        // the protocol needs to open a connection explicitely
        log("Open", JniInterface.Open());

        // most protocols have a GetVersion call
        log("GetVersion", JniInterface.GetVersion());

        // the Game of Life hardware needs a start generation
        // note: only the living cells were given, all other cells are dead
        log("SetStartGeneration", JniInterface.SetStartGeneration((byte) 10, (byte) 10,
                                                                  new byte[]{3, 4, 5},
                                                                  new byte[]{5, 5, 5}));

        // after calculating a number of generations, we expect that the
        // callback is called with the resulting generation
        log("CalculateGenerations", JniInterface.CalculateGenerations((byte) 2));

        // last but not least don't forget to close the connection
        log("Close",JniInterface.Close());
    }

    private static void log(final String function, final long returnValue) {
        LOGGER.info(function+" JNI call returned "+returnValue);
    }

    static {
        System.loadLibrary("cygIoT");
        System.loadLibrary("cygwin1");
    }
}
