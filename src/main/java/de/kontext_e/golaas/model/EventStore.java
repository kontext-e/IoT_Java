package de.kontext_e.golaas.model;

import org.apache.log4j.Logger;
import org.joou.UByte;

import de.kontext_e.golaas.jni.GetVersionReplyDto;

public class EventStore {
    private static final Logger LOGGER = Logger.getLogger(EventStore.class);

    public static void append(final CommandKey commandKey, final UByte returnCode, final ReplyDto dto) {
        // here goes the business logic for the applications

        // for demo lets print the result of the GetVersion command
        final CommandKey getVersionKey = CommandKey.getKey(UByte.valueOf(3), UByte.valueOf(1));
        if(getVersionKey.equals(commandKey)) {
            LOGGER.info("Version is " + new String(((GetVersionReplyDto) dto).getVersion()));
        }
    }
}
