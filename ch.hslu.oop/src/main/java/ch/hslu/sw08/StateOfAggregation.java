package ch.hslu.sw08;

public enum StateOfAggregation {
    GAS,
    LIQUID,
    SOLID;

    public String getName(StateOfAggregation stateOfAggregation) {
        if (stateOfAggregation == StateOfAggregation.GAS) {
            return "gaseous";
        }

        if (stateOfAggregation == StateOfAggregation.LIQUID) {
            return "liquid";
        }

        if (stateOfAggregation == StateOfAggregation.SOLID) {
            return "solid";
        }

        return "undefined";
    }
}
