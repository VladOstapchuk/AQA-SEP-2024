package org.prog.homeworks.session4;

//Enum for cars Colors
public enum CarColors {
    RED {
        @Override
        public String toString() {
            return "RED";
        }
    },
    GREEN {
        @Override
        public String toString() {
            return "GREEN";
        }
    },
    BLUE {
        @Override
        public String toString() {
            return "BLUE";
        }
    }
}
