public class Weight {
    int weight;

    public Weight(int weight) {
        this.weight = weight;
    }

    public boolean isHeavierThan(Weight other){
        return this.weight > other.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;

        Weight weight1 = (Weight) o;

        return weight == weight1.weight;

    }

    @Override
    public int hashCode() {
        return weight;
    }
}
