package exp4j;

import net.objecthunter.exp4j.operator.Operator;

public class Functions {

    public enum Designation {
        NOT("not"),
        XOR("xor"),
        AND("and"),
        OR("or");

        public final String value;

        private Designation(String value) {
            this.value = value;
        }
    }

    public enum Precedence {
        NOT(4),
        XOR(3),
        AND(2),
        OR(1);

        public final Integer value;

        private Precedence(Integer value) {
            this.value = value;
        }
    }

    private static boolean isArgumentBoolean(int arg) {
        return arg == 1 || arg == 0;
    }

    public static Operator negation = new Operator(Designation.NOT.value, 1, false, Precedence.NEGOTIATION.value) {
        @Override
        public double apply(double... args) {
            final int arg = (int) args[0];
            if (!isArgumentBoolean(arg)) {
                throw new IllegalArgumentException("Not boolean value of input");
            }
            return 1 - arg;
        }
    }

}
