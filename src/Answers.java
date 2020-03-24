public class Answers {
    long countCompressions;
    long countCalls;
    long countOverwrites;
    long bubbleTimeExtra;
    long bubbleTime;

    public Answers() {
    }

    public Answers(long bubbleTime, long countCompressions, long countCalls,
                   long countOverwrites, long bubbleTimeExtra) {
        this.bubbleTime = bubbleTime;
        this.countCompressions = countCompressions;
        this.countCalls = countCalls;
        this.countOverwrites = countOverwrites;
        this.bubbleTimeExtra = bubbleTimeExtra;
    }

    public long getCountCompressions() {
        return countCompressions;
    }

    public void setCountCompressions(long countCompressions) {
        this.countCompressions = countCompressions;
    }

    public long getCountCalls() {
        return countCalls;
    }

    public void setCountCalls(long countCalls) {
        this.countCalls = countCalls;
    }

    public long getCountOverwrites() {
        return countOverwrites;
    }

    public void setCountOverwrites(long countOverwrites) {
        this.countOverwrites = countOverwrites;
    }

    public long getBubbleTimeExtra() {
        return bubbleTimeExtra;
    }

    public void setBubbleTimeExtra(long bubbleTimeExtra) {
        this.bubbleTimeExtra = bubbleTimeExtra;
    }

    public long getBubbleTime() {
        return bubbleTime;
    }

    public void setBubbleTime(long bubbleTime) {
        this.bubbleTime = bubbleTime;
    }
}
