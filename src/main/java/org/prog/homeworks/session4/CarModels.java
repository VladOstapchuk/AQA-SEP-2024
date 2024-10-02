package org.prog.homeworks.session4;

//Enum for cars Models
public enum CarModels {
    MODEL10(10),
    MODEL50(50),
    MODEL1005(1005);

    private int modelNumber;

    CarModels(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getModelNumber() {
        return modelNumber;
    }
}
