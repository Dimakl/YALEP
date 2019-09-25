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

    public static Operator not =
            new Operator(Designation.NOT.value, 1, false, Precedence.NOT.value) {
        @Override
        public double apply(double... args) {
            final int arg = (int) args[0];
            if (!isArgumentBoolean(arg)) {
                throw new IllegalArgumentException("Not boolean value of input");
            }
            return 1 - arg;
        }
    };

    public static Operator xor =
            new Operator(Designation.XOR.value, 2, false, Precedence.XOR.value) {
        @Override
        public double apply(double... args) {
            final int arg1 = (int) args[0];
            final int arg2 = (int) args[1];
            if (!isArgumentBoolean(arg1) || !isArgumentBoolean(arg2)) {
                throw new IllegalArgumentException("Not boolean value of input");
            }

            return arg1 ^ arg2;
        }
    }

}
