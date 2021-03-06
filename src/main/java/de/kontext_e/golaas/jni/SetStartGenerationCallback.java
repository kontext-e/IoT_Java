package de.kontext_e.golaas.jni;

/*Generated by MPS */

import javax.annotation.Generated;
import org.apache.log4j.Logger;
import de.kontext_e.golaas.model.CommandKey;
import org.joou.UByte;
import de.kontext_e.golaas.model.EventStore;
import org.joou.Unsigned;

@Generated(value = "MPS JNI Java Generator")
public class SetStartGenerationCallback {
  private static final int OK = 0;
  private static final Logger LOGGER = Logger.getLogger(SetStartGenerationCallback.class);

  public static final CommandKey commandKey = CommandKey.getKey(UByte.valueOf(1), UByte.valueOf(2));

  public void callback(byte returnCode) {
    try {
      LOGGER.debug("Parameter " + "returnCode" + ": " + returnCode);
      final SetStartGenerationReplyDto dto = new SetStartGenerationReplyDto(returnCode);
      EventStore.append(commandKey, Unsigned.ubyte(returnCode), dto);
    } catch (Throwable t) {
      LOGGER.warn("Error while receiving " + "SetStartGeneration" + ":" + t, t);
    }
  }
}
