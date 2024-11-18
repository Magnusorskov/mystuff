package model;

import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private Random random = new Random();

    public YatzyDice() {
    }

    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Sets the 5 face values of the dice. Pre: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    void setValues(int[] values) {
        for (int i = 0; i < 5; i++) {
            this.values[i] = values[i];
        }
    }

    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Pre: whatever contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        throwCount++;
        for (int i = 0; i < 5; i++) {
            if (!holds[i]) {
                this.values[i] = random.nextInt(1, 7);
            }
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    public int[] frequency() {
        int[] frequency = new int[7];
        for (int i = 0; i < 5; i++) {
            frequency[values[i]]++;
        }
        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        return frequency()[value] * value;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int sum = 0;
        int[] frequency = frequency();

        for (int i = 1; i < 7; i++) {
            if (frequency[i] >= 2) {
                sum = i * 2;
            }
        }
        return sum;
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int maxPair = 0;
        int secondMax = 0;
        int[] frequency = frequency();

        for (int i = 1; i < 7; i++) {
            if (frequency[i] >= 2) {
                secondMax = maxPair;
                maxPair = i * 2;
            }
        }
        if (secondMax == 0) {
            maxPair = 0;
        }
        return maxPair + secondMax;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        int sum = 0;
        int[] frequency = frequency();

        for (int i = 1; i < 7; i++) {
            if (frequency[i] >= 3) {
                sum = i * 3;
            }
        }
        return sum;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        int sum = 0;
        int[] frequency = frequency();

        for (int i = 1; i < 7; i++) {
            if (frequency[i] >= 4) {
                sum = i * 4;
            }
        }
        return sum;
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int pair = 0;
        int threesome = 0;
        int i = 1;
        int[] frequency = frequency();

        while (i < 7) {
            if (frequency[i] == 2) {
                pair = i * 2;
            } else if (frequency[i] == 3) {
                threesome = i * 3;
            }
            i++;
        }
        if (pair == 0 || threesome == 0) {
            pair = 0;
            threesome = 0;
        }

        return pair + threesome;
    }


    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int sum = 15;
        int[] frequency = frequency();

        for (int i = 1; i < 6; i++) {
            if (frequency[i] == 0) {
                sum = 0;
            }
        }
        return sum;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int sum = 20;
        int[] frequency = frequency();

        for (int i = 2; i < 7; i++) {
            if (frequency[i] == 0) {
                sum = 0;
            }
        }
        return sum;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        boolean yatzy = false;
        int i = 1;
        int sum = 0;
        int[] frequency = frequency();


        while (!yatzy && i < 7) {
            if (frequency[i] == 5) {
                yatzy = true;
                sum = 50;

            }
            i++;
        }
        return sum;
    }

}
