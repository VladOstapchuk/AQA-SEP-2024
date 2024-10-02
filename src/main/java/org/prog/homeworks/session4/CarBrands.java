package org.prog.homeworks.session4;

//Enum for cars Brands
public enum CarBrands {

    FORD {
        @Override
        public String toString() {
            return "FORD";
        }
    },
    SEAT {
        @Override
        public String toString() {
            return "SEAT";
        }
    },
    TOYOTA {
        @Override
        public String toString() {
            return "TOYOTA";
        }
    }
}
