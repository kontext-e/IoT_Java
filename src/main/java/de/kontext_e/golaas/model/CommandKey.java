package de.kontext_e.golaas.model;

import org.joou.UByte;

public class CommandKey {
    private final UByte opcode;
    private final UByte groupCode;

    public CommandKey(final UByte opcode, final UByte groupCode) {
        this.opcode = opcode;
        this.groupCode = groupCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CommandKey commandKey = (CommandKey) o;

        if (opcode != null ? !opcode.equals(commandKey.opcode) : commandKey.opcode != null) return false;
        return groupCode != null ? groupCode.equals(commandKey.groupCode) : commandKey.groupCode == null;
    }

    @Override
    public int hashCode() {
        int result = opcode != null ? opcode.hashCode() : 0;
        result = 31 * result + (groupCode != null ? groupCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommandKey{" +
               "opcode=" + opcode +
               ", groupCode=" + groupCode +
               '}';
    }

    public UByte getOpcode() {

        return opcode;
    }

    public UByte getGroupCode() {
        return groupCode;
    }

    public static CommandKey getKey(final UByte opcode, final UByte groupCode) {
        return new CommandKey(opcode, groupCode);
    }

}
