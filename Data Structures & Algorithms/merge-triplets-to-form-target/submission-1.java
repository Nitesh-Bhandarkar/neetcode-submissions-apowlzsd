class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> validTriplet = new ArrayList<>();

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            validTriplet.add(triplet);
        }

        boolean hasFirst = false;
        boolean hasSecond = false;
        boolean hasThird = false;

        for (int[] triplet : validTriplet) {
            if (triplet[0] == target[0]) {
                hasFirst = true;
            }

            if (triplet[1] == target[1]) {
                hasSecond = true;
            }

            if (triplet[2] == target[2]) {
                hasThird = true;
            }
        }

        return hasFirst && hasSecond && hasThird;
    }
}
