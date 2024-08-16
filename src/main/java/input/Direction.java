package input;

public enum Direction {
    N, E, S, W;

    public static int getCorrectDirectionIndex(int n){
        if (n < 0) n+=4;
        if (n>3) n-=4;
        return n;
    }
}
