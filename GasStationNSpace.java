/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 */

public class GasStationNSpace {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int validStart = -1;
        int totalCost = 0;
        for (int start = 0, costFromStart = 0; start < gas.length; start++) {
            totalCost += gas[start] - cost[start];
            costFromStart += gas[start] - cost[start];
            if (costFromStart < 0) {
                costFromStart = 0;
                validStart = start;
            }
        }
        return totalCost >= 0 ? validStart + 1 : -1;
    }
}