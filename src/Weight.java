public class Weight {
    int weight;

    public Weight(int weight) {
        this.weight = weight;
    }

    public boolean isHeavierThan(Weight other){
        return this.weight > other.weight;
    }
}
