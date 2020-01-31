public class TwoBucket {

    private int totalMove;
    private String finalBucket;
    private int otherBucket;

    public TwoBucket(int oneCap, int twoCap, int targetLiter, String firstFill) {
        Bucket[] buckets = new Bucket[] {new Bucket("one", oneCap), new Bucket("two", twoCap)};
        if ("two".equals(firstFill)) {
            Bucket temp = buckets[0];
            buckets[0] = buckets[1];
            buckets[1] = temp;
        }

        totalMove = 0;
        while (true) {
            totalMove++;

            if (buckets[0].liter == 0) {
                buckets[0].liter = buckets[0].cap;
            } else if (buckets[1].cap == targetLiter) {
                buckets[1].liter = buckets[1].cap;
            } else if (buckets[1].liter == buckets[1].cap) {
                buckets[1].liter = 0;
            } else {
                int transfer = Math.min(buckets[0].liter, buckets[1].cap - buckets[1].liter);
                buckets[0].liter -= transfer;
                buckets[1].liter += transfer;
            }

            if (buckets[0].liter == targetLiter) {
                finalBucket = buckets[0].label;
                otherBucket = buckets[1].liter;
                break;
            }
            if (buckets[1].liter == targetLiter) {
                finalBucket = buckets[1].label;
                otherBucket = buckets[0].liter;
                break;
            }
        }

    }

    public int getTotalMoves() {
        return this.totalMove;
    }

    public String getFinalBucket() {
        return this.finalBucket;
    }

    public int getOtherBucket() {
        return this.otherBucket;
    }

    class Bucket {
        String label;
        int cap;
        int liter = 0;

        Bucket(String label, int cap) {
            this.label = label;
            this.cap = cap;
        }
    }
}
